package com.nig3l.cuttly.tools.exception;

public class InvalidAPIKeyException extends CuttlyException {


    public InvalidAPIKeyException() {
        super("The Key is not a valid Cuttly API key.");
    }
}
