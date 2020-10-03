package com.nig3l.cuttly.models;

import java.net.URL;

public class CuttlyDomain {

    private final URL link;

    private final int clicks;

    public CuttlyDomain(final URL links, final int clicks) {
        this.link = links;
        this.clicks = clicks;
    }

    public URL getLink() {
        return link;
    }

    public int getClicks() {
        return clicks;
    }
}
