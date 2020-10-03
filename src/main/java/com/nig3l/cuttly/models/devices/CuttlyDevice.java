package com.nig3l.cuttly.models.devices;

import com.nig3l.cuttly.models.CuttlyObject;

public abstract class CuttlyDevice implements CuttlyObject {

    protected String tag;

    protected int clicks;

    public CuttlyDevice(String tag, int clicks) {
        this.tag = tag;
        this.clicks = clicks;
    }

    public String getTag() {
        return tag;
    }

    public int getClicks() {
        return clicks;
    }

    @Override
    public String toString() {
        return "CuttlyDevice{" +
                "tag='" + tag + '\'' +
                ", clicks=" + clicks +
                '}';
    }
}
