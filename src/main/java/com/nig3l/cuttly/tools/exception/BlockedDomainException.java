package com.nig3l.cuttly.tools.exception;

public class BlockedDomainException extends CuttlyException{
    public BlockedDomainException() {
        super("The link is from a blocked domain");
    }
}
