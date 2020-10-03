package com.nig3l.cuttly.tools.exception;

public class NameAlreadyTakenException extends CuttlyException {
    public NameAlreadyTakenException() {
        super("The preferred link name is already taken.");
    }
}
