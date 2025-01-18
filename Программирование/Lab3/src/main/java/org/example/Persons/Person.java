package org.example.Persons;

import org.example.Enums.REASONS;
import org.example.Excaptions.CustomException;
import org.example.Excaptions.FailedExcapiton;
import org.example.Excaptions.ItIsDied;
import org.example.Items.AbstractItem;
import org.example.Items.Food;
import org.example.Items.Item;
import org.example.Locations.AbstractLocation;
import org.example.Locations.Location;

import java.util.ArrayList;

public abstract class Person {
    public Location nowLocation = null;
    public boolean active = true;
    public ArrayList<Item> own = new ArrayList<>();
    public ArrayList<Location> own_loc = new ArrayList<>();
    private int age;
    private int height;
    private String name;

    public void addOwn(Item item) {
        this.own.add(item);
    }

    public void removeOwn(Item item) {
        this.own.add(item);
    }

    public void addOwn(Location loc) {
        this.own_loc.add(loc);
    }

    public void removeOwn(Location loc) {
        this.own_loc.add(loc);
    }


    public Location getNowLocation() {
        return nowLocation;
    }

    public void setNowLocation(Location loc) {
        this.nowLocation = loc;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void watch(AbstractLocation loc) {
        chek_die();
        System.out.println(this.getName() + " watch to " + loc.getName());
    }

    public void watch(AbstractLocation loc, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " watch to " + loc.getName() + " by reason" + reason);
    }

    public void moveTo(Location loc) {
        chek_die();
        this.nowLocation = loc;
        System.out.println(this.getName() + " move to" + loc.getName());
    }

    public String moveTo(Location loc, AbstractItem item) {
        chek_die();
        this.nowLocation = loc;
        return this.getName() + " move to" + loc.getName();
    }

    public void moveTo(Location loc, REASONS reason) {
        chek_die();
        this.nowLocation = loc;
        System.out.println(this.getName() + " move to" + loc.getName() + " by reason " + reason);
    }

    public String moveTo(Location loc, AbstractItem item, REASONS reason) {
        chek_die();
        this.nowLocation = loc;
        return this.getName() + " move to" + loc.getName() + " by reason " + reason;
    }

    public void create(Location loc) {
        chek_die();
        nowLocation = loc;
        System.out.println(this.getName() + " created " + loc.getName());
    }

    public void create(Item item) {
        chek_die();
        System.out.println(this.getName() + " created " + item.getName());
    }

    public void create(Item item, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " created " + item.getName() + " by reason" + reason);
    }

    public void find(Item item) {
        chek_die();
        item.setOwner(this);
        System.out.println(this.getName() + " find " + item.getName());
    }

    public String find(Location loc) {
        chek_die();
        loc.setOwner(this);
        return this.getName() + "find " + loc.getName();
    }

    public void find(Item item, REASONS reason) {
        chek_die();
        item.setOwner(this);
        System.out.println(this.getName() + " find " + item.getName() + " by reason " + reason);
    }

    public String find(Location loc, REASONS reason) {
        chek_die();
        loc.setOwner(this);
        return this.getName() + "find " + loc.getName() + " by reason " + reason;
    }

    public void scared(Item item) {
        chek_die();
        System.out.println(this.getName() + " scared of the " + item.getName());
    }

    public void scared(String item, REASONS reasons) {
        chek_die();
        System.out.println(this.getName() + " scared of the " + item + " by reason " + reasons);
    }

    public void scared(Person p) {
        chek_die();
        System.out.println(this.getName() + " scared of the " + p.getName());
    }

    public void scared(Person p, REASONS reasons) {
        chek_die();
        System.out.println(this.getName() + " scared of the " + p.getName() + " by reason " + reasons);
    }

    public void eat(Food food) throws CustomException {
        chek_die();
        if (food.canEat()) {
            System.out.println(this.getName() + " ate " + food.getName());
        } else {
            throw new CustomException(this.getName() + " can't eat the " + food.getName());
        }
    }

    public void scare(Person p) {
        chek_die();
        System.out.println(this.getName() + " scare a person " + p.getName());
    }

    public void scare(Person p, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " scare a person " + p.getName() + " by reason " + reason);
    }

    public void use(Item item) throws FailedExcapiton {
        chek_die();
        item.use(this);
    }

    public void use(Item item, REASONS reason) throws FailedExcapiton {
        chek_die();
        item.use(this, reason);
    }

    public void carry(Person person) {
        chek_die();
        System.out.println(this.getName() + " carry about " + person.getName());
    }

    public void carry(Person person, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " carry about " + person.getName() + " by reason " + reason);
    }

    public void carry(Item item) {
        chek_die();
        System.out.println(this.getName() + " carry about " + item.getName());
    }

    public void carry(Item item, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " carry about " + item.getName() + " by reason " + reason);
    }

    public void listen(Item item) {
        chek_die();
        System.out.println(this.getName() + " listning to " + item.getName());
    }

    public void listen(Person p) {
        chek_die();
        System.out.println(this.getName() + " listning to " + p.getName());
    }

    public void listen(Item item, REASONS reasons) {
        chek_die();
        System.out.println(this.getName() + " listning to " + item.getName() + " by reason " + reasons);
    }

    public void listen(Person p, REASONS reason) {
        chek_die();
        System.out.println(this.getName() + " listning to " + p.getName() + " by reason " + reason);
    }

    public void have(Item p) {
        chek_die();
        p.setOwner(this);
        System.out.println(this.getName() + " has " + p.getName());
    }

    public void have(Item p, REASONS reason) {
        chek_die();
        p.setOwner(this);
        System.out.println(this.getName() + " has " + p.getName() + " by reason " + reason);
    }

    public void die() {
        active = false;
        System.out.println(this.getName() + " died");
    }

    public void chek_die() {
        if (!this.active) {
            throw new ItIsDied(this.name);
        }
    }


}
