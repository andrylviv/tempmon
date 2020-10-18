package com.example.tempmon;

public class Temperatureconf {
  //  int id;
    double temperature;

 //   public Temperatureconf(){}

    public Temperatureconf(double temperature) {
       // this.id = id;
        this.temperature = temperature;
    }

 /*   public int getId() {
        return id;
    }*/

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

}
