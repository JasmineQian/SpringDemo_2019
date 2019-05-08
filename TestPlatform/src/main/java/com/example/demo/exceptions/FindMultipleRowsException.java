package com.example.demo.exceptions;

public class FindMultipleRowsException extends RuntimeException {

    private int actual;

    public FindMultipleRowsException( int actual) {

        this.actual = actual;
    }

    @Override
    public String getMessage() {

        String className= this.getStackTrace()[1].getClassName();
        String method = this.getStackTrace()[1].getMethodName();
        int line = getStackTrace()[1].getLineNumber();
        return String.format("%s: %s [%s] : Expect 1, Actual: %s", className, method, line, actual);
    }
}
