package com.example.demo.exceptions;

/**
 * @author robgao
 */
public class PeException extends RuntimeException {

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public PeException(String msg) {
        this.message = msg;
    }

    @Override
    public String toString() {
        String className= this.getStackTrace()[1].getClassName();
        String method = this.getStackTrace()[1].getMethodName();
        int line = getStackTrace()[1].getLineNumber();
        return String.format("%s: %s [%s] : %s", className, method, line, this.message);
    }
}
