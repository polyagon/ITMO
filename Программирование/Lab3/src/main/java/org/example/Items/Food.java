package org.example.Items;

import org.example.Enums.FOODStatus;
import org.example.Enums.ITEMStatus;
import org.example.Enums.METHODSofCooking;
import org.example.Excaptions.CustomException;
import org.example.Interfaces.Eatable;
import org.example.Interfaces.Belongable;
import org.example.Persons.Person;

import java.util.Arrays;

public class Food extends Item implements Eatable, Belongable{
    private FOODStatus status;
    private int calories;
    private METHODSofCooking[] methodSofCookings;

    public FOODStatus getFoodStatus(){
        return status;
    }
    public void setStatus(FOODStatus status){
        this.status = status;
    }
    public int getCalories(){
        return calories;
    }
    public void setCalories(int calories){
        this.calories = calories;
    }
    public METHODSofCooking[] getMethodSofCookings(){
        return methodSofCookings;
    }


    public Food(String name, int calories, FOODStatus status, METHODSofCooking[] methods){
        super(name, ITEMStatus.ACTIVE);
        this.calories = calories;
        this.status = status;
        this.methodSofCookings = methods;
    }
    public Food(String name, Person p,  int calories, FOODStatus status, METHODSofCooking[] methods){
        super(name, ITEMStatus.ACTIVE, p);
        this.calories = calories;
        this.status = status;
        this.methodSofCookings = methods;
    }


    public void cooked(METHODSofCooking method) throws CustomException {
        if(canMethod(method)){
            setStatus(FOODStatus.DONE);
            System.out.println("Food " + this.getName() + " is done");
        }else{
            throw new CustomException("Method " + method.name() + " don't  suitable for type of eat: "+ this.getName() + " \n");
        }
    }



    public boolean canEat(){
        if(this.status == FOODStatus.DEAD){
            return false;
        }
        if(this.status == FOODStatus.RAW && !canMethod(METHODSofCooking.NOTHING)){
            return false;
        }
        return true;
    }

    public boolean canMethod(METHODSofCooking method){
        if(Arrays.asList(methodSofCookings).contains(method)) return true;
        else return false;
    }

}
