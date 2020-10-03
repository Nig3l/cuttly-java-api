package com.nig3l.cuttly.tools.exception;

public class AlreadyShortException extends CuttlyException {
    public AlreadyShortException() {
        super("The link has already be shortened.");
    }
}
