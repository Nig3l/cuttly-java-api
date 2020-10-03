package com.nig3l.cuttly.tools.dao;

import com.nig3l.cuttly.models.CuttlyDomain;
import com.nig3l.cuttly.models.CuttlyLink;
import com.nig3l.cuttly.models.devices.*;
import com.nig3l.cuttly.tools.exception.*;
import com.nig3l.cuttly.tools.builder.LinkBuilder;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LinkDAO implements CuttlyDAO<CuttlyLink> {

    private CuttlyLink link;

    public LinkDAO(CuttlyLink link) {
        this.link = link;
    }

    public LinkDAO() {
    }

    @Override
    public void handleErrors(int status) throws CuttlyException {
        if (link == null) {
            handleLinkCreationErrors(status);
            this.link = new CuttlyLink();
        } else {
            handleStatsCreationErrors(status);
        }
    }

    private void handleLinkCreationErrors(final int status) throws CuttlyException {
        switch (status) {
            case 1:
                throw new AlreadyShortException();
            case 2:
                throw new NotLinkException();
            case 3:
                throw new NameAlreadyTakenException();
            case 4:
                throw new InvalidAPIKeyException();
            case 5:
                throw new NotValidException();
            case 6:
                throw new BlockedDomainException();
        }
    }

    private void handleStatsCreationErrors(final int status) throws CuttlyException {
        switch (status) {
            case 0:
                throw new LinkNotExistException();
            case 2:
                throw new InvalidAPIKeyException();
        }
    }

    private static int jsonToInt(final JSONObject json, final String key) {
        Long longValue;
        longValue = (Long) json.get(key);
        return longValue.intValue();
    }

    private List<CuttlyDevice> jsonToDevices(JSONObject json, String device) {
        List<CuttlyDevice> devices = new ArrayList<>();
        JSONObject jsonObject = (JSONObject) json.get(device);
        if(jsonObject != null) {
            for (Object objectDevice : jsonObject.values()) {
                JSONObject jsonDevice = (JSONObject) objectDevice;
                String tag = (String) jsonDevice.get("tag");
                int clicks = Integer.parseInt((String) jsonDevice.get("clicks"));
                devices.add(newCuttlyDevice(tag, clicks, device));
            }
        }
        return devices;
    }

    private CuttlyDevice newCuttlyDevice(String tag, int clicks, String device) {
        switch (device) {
            case "geo":
                return new CuttlyGeoDevice(tag, clicks);
            case "sys":
                return new CuttlySysDevice(tag, clicks);
            case "dev":
                return new CuttlyDevDevice(tag, clicks);
            case "bro":
                return new CuttlyBroDevice(tag, clicks);
        }
        return null;
    }

    private List<CuttlyDevice> jsonToDevices(JSONObject json) {
        List<CuttlyDevice> devices = new ArrayList<>();
        devices.addAll(jsonToDevices(json, "geo"));
        devices.addAll(jsonToDevices(json, "sys"));
        devices.addAll(jsonToDevices(json, "bro"));
        devices.addAll(jsonToDevices(json, "dev"));
        return devices;
    }

    private List<CuttlyDomain> jsonToDomain(JSONObject json) {
        List<CuttlyDomain> domains = new ArrayList<>();
        for (Object objectDomain : json.values()) {
            JSONObject jsonDomain = (JSONObject) objectDomain;
            try {
                URL url = new URL((String) jsonDomain.get("link"));
                int clicks = Integer.parseInt((String) jsonDomain.get("clicks"));
                domains.add(new CuttlyDomain(url, clicks));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return domains;
    }

    @Override
    public CuttlyLink jsonToObject(JSONObject json) throws CuttlyException {
        Long status = (Long) json.get("status");
        handleErrors(status.intValue());

        LinkBuilder builder = new LinkBuilder(this.link);

        builder.setDate((String) json.get("date"));
        builder.setTitle((String) json.get("title"));
        try {
            builder.setFullLink(new URL((String) json.get("fullLink")));
            builder.setShortLink(new URL((String) json.get("shortLink")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (json.containsKey("clicks")) {
            builder.setClicks(Integer.parseInt((String) json.get("clicks")));
            builder.setFacebookClicks(jsonToInt(json, "facebook"));
            builder.setTwitterClicks(jsonToInt(json, "twitter"));
            builder.setLinkedinClicks(jsonToInt(json, "linkedin"));
            builder.setRestClicks(jsonToInt(json, "rest"));

            jsonToDevices((JSONObject) json.get("devices")).forEach(builder::addDevice);
            jsonToDomain((JSONObject) json.get("refs")).forEach(builder::addDomain);
        }

        return builder.build();
    }

    @Override
    public JSONObject objectToJson(CuttlyLink object) {
        return null;
    }
}
