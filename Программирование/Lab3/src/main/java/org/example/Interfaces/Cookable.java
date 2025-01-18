package org.example.Interfaces;

import org.example.Enums.METHODSofCooking;
import org.example.Excaptions.CustomException;
import org.example.Items.Food;

public interface Cookable {
    public void eat(Food food) throws CustomException;

    public void cook(Food food, METHODSofCooking method) throws CustomException;

}
