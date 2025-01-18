package org.example;

import org.example.Excaptions.CustomException;
import org.example.Excaptions.FailedExcapiton;
import org.example.StoryTelling.Story;

public class Main {

    static Story story = new Story();

    public static void main(String[] args) throws CustomException, FailedExcapiton {
        story.defaultStory();
    }
}