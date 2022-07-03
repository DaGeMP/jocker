package com.dagework.jocker;

public class CommandExecutionException extends RuntimeException {
    CommandExecutionException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
