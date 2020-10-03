package com.nig3l.cuttly.tools.builder;

import com.nig3l.cuttly.models.CuttlyDomain;
import com.nig3l.cuttly.models.CuttlyLink;
import com.nig3l.cuttly.models.devices.CuttlyDevice;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkBuilder {

    private CuttlyLink link;

    private String title;

    private URL fullLink;

    private URL shortLink;

    private String date;

    private int clicks;

    private int facebookClicks;

    private int twitterClicks;

    private int linkedinClicks;

    private int restClicks;

    private Map<URL, Integer> domains;

    private List<CuttlyDevice> devices;

    public LinkBuilder(CuttlyLink link) {
        this.link = link;
        this.link.setDomains(new HashMap<>());
        this.link.setDevices(new ArrayList<>());
    }

    public LinkBuilder() {
        this.link = new CuttlyLink();
        this.domains = new HashMap<>();
        this.devices = new ArrayList<>();
    }

    public LinkBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public LinkBuilder setFullLink(URL fullLink) {
        this.fullLink = fullLink;
        return this;
    }

    public LinkBuilder setShortLink(URL shortLink) {
        this.shortLink = shortLink;
        return this;
    }

    public LinkBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public LinkBuilder setClicks(int clicks) {
        this.clicks = clicks;
        return this;
    }

    public LinkBuilder setFacebookClicks(int facebookClicks) {
        this.facebookClicks = facebookClicks;
        return this;
    }

    public LinkBuilder setTwitterClicks(int twitterClicks) {
        this.twitterClicks = twitterClicks;
        return this;
    }

    public LinkBuilder setLinkedinClicks(int linkedinClicks) {
        this.linkedinClicks = linkedinClicks;
        return this;
    }

    public LinkBuilder setRestClicks(int restClicks) {
        this.restClicks = restClicks;
        return this;
    }

    public void addDevice(final CuttlyDevice device){
        this.devices.add(device);
    }

    public void addDomain(final CuttlyDomain domain){
        this.domains.put(domain.getLink(),this.domains.get(domain.getLink()) + domain.getClicks());
    }

    public CuttlyLink build(){
        link.setDate(date);
        link.setTitle(title);
        link.setFullLink(fullLink);
        link.setShortLink(shortLink);
        link.setClicks(clicks);
        link.setFacebookClicks(facebookClicks);
        link.setTwitterClicks(twitterClicks);
        link.setLinkedinClicks(linkedinClicks);
        link.setRestClicks(restClicks);
        link.setDomains(domains);
        link.setDevices(devices);
        return link;
    }
}
