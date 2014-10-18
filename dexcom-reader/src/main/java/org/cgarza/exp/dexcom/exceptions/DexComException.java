package org.cgarza.exp.dexcom.exceptions;

public class DexComException extends Exception {

    public DexComException() {
    }

    public DexComException(String message) {
        super(message);
    }

    public DexComException(String message, Throwable cause) {
        super(message, cause);
    }

    public DexComException(Throwable cause) {
        super(cause);
    }
    
}
