package com.senac.cinema.BaseRepository;

public class ValidationRulesException extends RuntimeException {
    public ValidationRulesException() {
    }

    public ValidationRulesException(String message) {
        super(message);
    }

    public ValidationRulesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationRulesException(Throwable cause) {
        super(cause);
    }
}
