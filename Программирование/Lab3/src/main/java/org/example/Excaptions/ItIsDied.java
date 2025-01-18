package org.example.Excaptions;

public class ItIsDied extends RuntimeException {
    public ItIsDied(String message) {
        super(message + " is died!");
    }
}
