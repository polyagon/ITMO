package org.example.Items;

import org.example.Enums.ITEMStatus;
import org.example.Excaptions.FailedExcapiton;
import org.example.Locations.Location;
import org.example.Persons.Person;

public abstract class AbstractItem {
    private String name;
    private ITEMStatus status;
    Person owner;
    boolean isOwner = false;
    boolean isBelongLocation = false;
    Location belong ;

    public String getName(){
        return name;
    }

    public AbstractItem(String name, ITEMStatus stat){
        this.name = name;
        this.status = stat;
    }
    public Person getOwner(){
        return this.owner;
    }
    public void setOwner(Person owner) {
        if(owner == null){
            this.owner = null;
            isOwner = false;
        }else if(this.isOwner == false){
            this.owner = owner;

            this.isOwner = true;
        }else
        {
            this.owner = owner;
        }

    }

    public Location getLocation(){
        return this.belong;
    }
    public void setLocation(Location loc){
        if(owner == null){
            this.belong = null;
            isBelongLocation = false;
        }else{
            this.belong = loc;
            this.isBelongLocation = true;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public ITEMStatus getStatus(){
        return status;
    }
    public void setStatus(ITEMStatus stat){
        this.status = stat;
    }
    public boolean checkActive(){
        return status == ITEMStatus.ACTIVE;
    }

    public abstract void use(Person p) throws FailedExcapiton;



}
