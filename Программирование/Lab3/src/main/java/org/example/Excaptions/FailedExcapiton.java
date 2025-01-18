package org.example.Excaptions;

import org.example.Enums.ITEMStatus;

import java.io.IOException;

public class FailedExcapiton extends IOException {
    public FailedExcapiton(ITEMStatus message) {
        super(" Item is unactive. His status is  " + message);
    }
}
