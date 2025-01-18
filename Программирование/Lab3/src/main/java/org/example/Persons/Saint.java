package org.example.Persons;

public class Saint extends Person {
    public Saint(String name, int age, int height) {
        this.setAge(age);
        this.setHeight(height);
        this.setName(name);
    }


    @Override
    public String toString() {
        return "Class: Saint;\n name: " + this.getName() + ";\n age: " + this.getAge() + ";\n height: " + this.getHeight();
    }

    @Override
    public int hashCode() {
        int hash = this.getName().hashCode();
        hash += this.getAge();
        hash += this.getNowLocation().hashCode();
        hash += this.getHeight();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Saint check = (Saint) o;
        return this.hashCode() == check.hashCode();
    }
}
