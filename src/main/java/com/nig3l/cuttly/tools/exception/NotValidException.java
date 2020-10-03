package com.nig3l.cuttly.tools.exception;

public class NotValidException extends CuttlyException {
    public NotValidException() {
        super("The link has not passed the validation. It includes invalid characters");
    }
}
