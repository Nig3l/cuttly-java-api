package com.nig3l.cuttly.models;

import com.nig3l.cuttly.CuttlyAPI;
import com.nig3l.cuttly.models.devices.CuttlyDevice;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class CuttlyLink implements CuttlyObject {

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

    public CuttlyLink() {
        this.domains = new HashMap<>();
        this.devices = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFullLink(URL fullLink) {
        this.fullLink = fullLink;
    }

    public void setShortLink(URL shortLink) {
        this.shortLink = shortLink;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void setFacebookClicks(int facebookClicks) {
        this.facebookClicks = facebookClicks;
    }

    public void setTwitterClicks(int twitterClicks) {
        this.twitterClicks = twitterClicks;
    }

    public void setLinkedinClicks(int linkedinClicks) {
        this.linkedinClicks = linkedinClicks;
    }

    public void setRestClicks(int restClicks) {
        this.restClicks = restClicks;
    }

    public void setDomains(Map<URL, Integer> domains) {
        this.domains = domains;
    }

    public void setDevices(List<CuttlyDevice> devices) {
        this.devices = devices;
    }

    public String getTitle() {
        return title;
    }

    public URL getFullLink() {
        return fullLink;
    }

    public URL getShortLink() {
        return shortLink;
    }

    public String getDate() {
        return date;
    }

    public int getClicks() {
        return clicks;
    }

    public int getFacebookClicks() {
        return facebookClicks;
    }

    public int getTwitterClicks() {
        return twitterClicks;
    }

    public int getLinkedinClicks() {
        return linkedinClicks;
    }

    public int getRestClicks() {
        return restClicks;
    }

    public Map<URL, Integer> getDomains() {
        return domains;
    }

    public List<CuttlyDevice> getDevices() {
        return devices;
    }

    public <T> List<T> getDevices(Class<T> clazz){
        return devices.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuttlyLink that = (CuttlyLink) o;
        return clicks == that.clicks &&
                facebookClicks == that.facebookClicks &&
                twitterClicks == that.twitterClicks &&
                linkedinClicks == that.linkedinClicks &&
                restClicks == that.restClicks &&
                Objects.equals(title, that.title) &&
                Objects.equals(fullLink, that.fullLink) &&
                Objects.equals(shortLink, that.shortLink) &&
                Objects.equals(date, that.date) &&
                Objects.equals(domains, that.domains) &&
                Objects.equals(devices, that.devices);
    }

    public void getStats(){
        CuttlyAPI api = CuttlyAPI.getInstance();
        api.getStats(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, fullLink, shortLink, date, clicks, facebookClicks, twitterClicks, linkedinClicks, restClicks, domains, devices);
    }

    @Override
    public String toString() {
        return "CuttlyLink{" +
                "title='" + title + '\'' +
                ", fullLink=" + fullLink +
                ", shortLink=" + shortLink +
                ", date='" + date + '\'' +
                ", clicks=" + clicks +
                ", facebookClicks=" + facebookClicks +
                ", twitterClicks=" + twitterClicks +
                ", linkedinClicks=" + linkedinClicks +
                ", restClicks=" + restClicks +
                ", domains=" + domains +
                ", devices=" + devices +
                '}';
    }
}
