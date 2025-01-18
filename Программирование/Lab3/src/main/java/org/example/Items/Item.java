package org.example.Items;

import org.example.Enums.ITEMStatus;
import org.example.Enums.REASONS;
import org.example.Excaptions.FailedExcapiton;
import org.example.Interfaces.Locationable;
import org.example.Interfaces.Belongable;
import org.example.Locations.Location;
import org.example.Persons.Person;

public class Item extends AbstractItem  {
    Person owner;
    boolean isOwner = false;
    boolean isBelongLocation = false;
    Location belong ;


    public Item(String name, ITEMStatus status){
        super(name, status);
    }
    public Item(String name, ITEMStatus status,  Person p){
        super(name, status);
        isOwner = true;
        owner = p;
        p.addOwn(this);
    }
    public Item(String name, ITEMStatus sts, Location loc){
        super(name, sts);
        isBelongLocation = true;
        belong = loc;
    }
    public Item(String name, ITEMStatus sts, Person p, Location loc){
        super(name, sts);
        isOwner = true;
        isBelongLocation = true;
        owner = p;
        belong = loc;
        p.addOwn(this);
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
            owner.addOwn(this);
            this.isOwner = true;
        }else
        {
            this.owner.removeOwn(this);
            this.owner = owner;
            owner.addOwn(this);
        }

    }



    public void use() throws FailedExcapiton {

        if(this.checkActive()){
            System.out.println( this.getName() + " is used");
        }else throw new FailedExcapiton(this.getStatus());

    }

    public void use(Person p) throws FailedExcapiton{

        if(this.checkActive()){
            System.out.println(p.getName() + " use the " + this.getName());
        }else throw new FailedExcapiton(this.getStatus());
    }
    public void use(Person p, REASONS reason) throws FailedExcapiton{

        if(this.checkActive()){
            System.out.println(p.getName() + " use the " + this.getName() + "by reason " + reason);
        }else throw new FailedExcapiton(this.getStatus());
    }

    @Override
    public String toString(){
        return "Class: Item;\n name: " + this.getName() + ";\n owner: " + this.getOwner() + ";\n location: " + this.getLocation();
    }
    @Override
    public int hashCode() {
        int hash = this.getName().hashCode();
        hash+= this.owner.hashCode();
        hash += this.belong.hashCode();
        return hash;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item check = (Item) o;
        return hashCode() == check.hashCode();
    }
}