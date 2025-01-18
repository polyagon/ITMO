package org.example.Excaptions;

public class CustomException extends Exception {
    String message = "Error";

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
