package org.example.Locations;

public abstract class AbstractLocation {
    private String name;
    private double visability;

    public AbstractLocation(String name, double visability){
        this.name = name;
        this.visability = visability;
    }

    public String getName(){
        return this.name;
    }
    public double getVisability(){
        return this.visability;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setVisability(double visability){
        if(visability < 0.0){ this.visability = 0.0;}
        else{
            this.visability = Math.min(10.0, visability);
        }

    }
    public void setUpVisability(){
        this.visability += 1.0;
    }
    public void setDownVisability(){
        this.visability -=1.0;
    }
    public  void darkVisability(){
        this.visability = 0;
    }
    public void punumbraVisability(){
        this.visability = 4.0;
    }
    public void dayVisability(){
        this.visability = 8.0;
    }
}
