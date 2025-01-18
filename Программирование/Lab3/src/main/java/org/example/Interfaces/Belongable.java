package org.example.Interfaces;

import org.example.Persons.Person;

public interface Belongable {
    public Person getOwner();
    public void setOwner(Person person);
}
