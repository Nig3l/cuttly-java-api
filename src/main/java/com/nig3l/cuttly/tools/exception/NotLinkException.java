package com.nig3l.cuttly.tools.exception;

public class NotLinkException extends CuttlyException {
    public NotLinkException() {
        super("The link is not a valid link.");
    }
}
