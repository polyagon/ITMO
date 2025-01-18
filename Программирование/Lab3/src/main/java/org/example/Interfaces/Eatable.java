package org.example.Interfaces;

import org.example.Enums.FOODStatus;
import org.example.Enums.METHODSofCooking;
import org.example.Excaptions.CustomException;

public interface Eatable {

    public void cooked(METHODSofCooking method) throws CustomException;
    public boolean canEat();
    public boolean canMethod(METHODSofCooking method);
    public FOODStatus getFoodStatus();

}
