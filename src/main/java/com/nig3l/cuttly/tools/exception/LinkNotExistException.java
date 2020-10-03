package com.nig3l.cuttly.tools.exception;

public class LinkNotExistException extends CuttlyException{
    public LinkNotExistException() {
        super("The shortened link not exist");
    }
}
