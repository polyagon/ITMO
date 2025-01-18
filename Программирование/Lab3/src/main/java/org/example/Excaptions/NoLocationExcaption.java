package org.example.Excaptions;

import java.io.IOException;

public class NoLocationExcaption extends IOException {
    public NoLocationExcaption(String message) {
        super(" Object haven't location : " + message);
    }
}
