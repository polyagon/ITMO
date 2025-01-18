package org.example.Excaptions;

import java.io.IOException;

public class NoOwnerExcaption extends IOException {
    public NoOwnerExcaption(String message){
        super(" Object haven't owner : " + message);
    }
}
