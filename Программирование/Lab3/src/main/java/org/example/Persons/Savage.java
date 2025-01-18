package org.example.Persons;

import org.example.Enums.METHODSofCooking;
import org.example.Excaptions.CustomException;
import org.example.Interfaces.Cookable;
import org.example.Interfaces.Fireable;
import org.example.Items.AbstractItem;
import org.example.Items.Fire;
import org.example.Items.Food;

public class Savage extends Person implements Cookable, Fireable {
    public Savage(String name, int age, int height) {
        this.setAge(age);
        this.setHeight(height);
        this.setName(name);
    }


    public void cook(Food food, METHODSofCooking method) throws CustomException {
        try {
            System.out.println(this.getName() + " cook " + food.getName());
            food.cooked(method);
        } catch (CustomException e) {
            System.out.println(this.getName() + " couldn't cook " + food.getName());
        }
    }

    public void lightTheFire(Fire fire) {
        fire.light();
        nowLocation.dayVisability();
        System.out.println(this.getName() + " is able to light the fire");
    }

    public void burn(Fire fire, AbstractItem item) {
        nowLocation.setUpVisability();
        System.out.println(this.getName() + " be able to burn the " + item.getName());
    }


    @Override
    public String toString() {
        return "Class: Savage;\n name: " + this.getName() + ";\n age: " + this.getAge() + ";\n height: " + this.getHeight();
    }

    @Override
    public int hashCode() {
        int hash = this.getName().hashCode();
        hash += this.getAge();
        hash += this.nowLocation.hashCode();
        hash += this.getHeight();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Savage check = (Savage) o;
        return this.hashCode() == check.hashCode();
    }
}
