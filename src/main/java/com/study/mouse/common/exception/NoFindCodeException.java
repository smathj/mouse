package com.study.mouse.common.exception;

public class NoFindCodeException extends RuntimeException {
    public NoFindCodeException() {
    }

    public NoFindCodeException(String message) {
        super(message);
    }

    public NoFindCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFindCodeException(Throwable cause) {
        super(cause);
    }

    public NoFindCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
