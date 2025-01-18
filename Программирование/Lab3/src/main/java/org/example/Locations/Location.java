package org.example.Locations;

import org.example.Interfaces.Belongable;
import org.example.Persons.Person;

public class Location extends AbstractLocation implements Belongable {

    Person owner;
    boolean isOwner = false;
    boolean isLocation = false;
    Location belong ;

    public Person getOwner(){
        return  owner;
    }
    public void setOwner(Person owner){
        this.owner = owner;
        isOwner = true;
    }

    public Location getBelong(){
        return  belong;
    }
    public void setLocation(Location loc){
        belong = loc;
        isLocation = true;
    }

    public Location(String name, double visabil, Person p){
        super(name, visabil);
        this.setOwner(p);
    }
    public Location(String name, double visabil){
        super(name, visabil);
    }

    public Location(String name, double visabil, Location loc){
        super(name, visabil);
        isLocation = true;
        belong = loc;
    }

    @Override
    public String toString(){
        return "Class: Location;\n name: " + this.getName() + ";\n owner: " + this.getOwner() + ";\n visability: " + this.getVisability();
    }
    @Override
    public int hashCode() {
        int hash = this.getName().hashCode();
        hash+= this.owner.hashCode();
        hash += this.belong.hashCode()*this.getVisability();
        return hash;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Location check = (Location) o;
        return this.hashCode() == check.hashCode();
    }


}
