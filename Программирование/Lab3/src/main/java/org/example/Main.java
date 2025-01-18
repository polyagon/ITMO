package org.example;

import org.example.Enums.FOODStatus;
import org.example.Enums.METHODSofCooking;
import org.example.Excaptions.CustomException;
import org.example.Excaptions.FailedExcapiton;
import org.example.Items.Fire;
import org.example.Items.Food;
import org.example.Items.Item;
import org.example.Locations.Location;
import org.example.Persons.Demon;
import org.example.Persons.Human;
import org.example.StoryTelling.Story;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static Story story = new Story();
    public static void main(String[] args) throws CustomException, FailedExcapiton {
        story.defaultStory();
    }
}