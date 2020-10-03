package com.nig3l.cuttly;

import com.nig3l.cuttly.tools.exception.InvalidAPIKeyException;

public class CuttlyAPIBuilder {

    private String key;

    public CuttlyAPIBuilder(String key) {
        this.key = key;
    }

    public CuttlyAPIBuilder() {
    }

    public CuttlyAPIBuilder setKey(final String key){
        this.key = key;
        return this;
    }

    public CuttlyAPI build(){
        if(this.key == null){
            try {
                throw new InvalidAPIKeyException();
            } catch (InvalidAPIKeyException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        CuttlyAPI api = CuttlyAPI.getInstance();
        api.setKey(this.key);
        return api;
    }
}
