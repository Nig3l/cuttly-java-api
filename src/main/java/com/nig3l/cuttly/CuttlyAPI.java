package com.nig3l.cuttly;

import com.nig3l.cuttly.tools.exception.CuttlyException;
import com.nig3l.cuttly.models.CuttlyLink;
import com.nig3l.cuttly.tools.dao.LinkDAO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 */
public class CuttlyAPI
{
    private static CuttlyAPI INSTANCE;

    private String key;

    private CuttlyAPI(){};

    public void setKey(String key) {
        this.key = key;
    }

    public static CuttlyAPI getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CuttlyAPI();
        }
        return INSTANCE;
    }

    public CuttlyLink getLink(String link, String linkName) {
        try {
            URL url = new URL("https://cutt.ly/api/api.php?key=" + this.key
                    + "&short=" + encodeValue(link) + "&name=" + linkName);
            JSONObject jsonObject = getJSONData(url);
            LinkDAO dao = new LinkDAO();
            return dao.jsonToObject((JSONObject) jsonObject.get("url"));
        } catch (IOException | ParseException | CuttlyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getStats(CuttlyLink link){
        try {
            URL url = new URL("https://cutt.ly/api/api.php?key=" + this.key
                    + "&stats=" + encodeValue(link.getShortLink().toString()));
            JSONObject jsonObject = getJSONData(url);
            LinkDAO dao = new LinkDAO(link);
            dao.jsonToObject((JSONObject) jsonObject.get("stats"));
        } catch (IOException | ParseException | CuttlyException e) {
            e.printStackTrace();
        }
    }

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    private static JSONObject getJSONData(URL url) throws IOException, ParseException {
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));
        JSONParser parser = new JSONParser();
        StringBuilder stringBuilder = new StringBuilder();
        read.lines().forEach(stringBuilder::append);
        read.close();
        return (JSONObject) parser.parse(stringBuilder.toString());
    }
}
