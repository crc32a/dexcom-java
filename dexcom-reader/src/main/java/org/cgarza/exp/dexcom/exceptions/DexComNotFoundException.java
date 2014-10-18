package org.cgarza.exp.dexcom.exceptions;

public class DexComNotFoundException extends DexComException{

    public DexComNotFoundException() {
    }

    public DexComNotFoundException(String message) {
        super(message);
    }

    public DexComNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DexComNotFoundException(Throwable cause) {
        super(cause);
    }
   
}
