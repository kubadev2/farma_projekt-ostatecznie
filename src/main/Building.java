package main;

import java.util.Random;

public class Building
{
    double buyPrice;
    double sellPrice;
    double styCapacity;
    double barnCapacity;
    double surface;
    public double _random2()
    {
        Random rand2 = new Random();
        double randomNumber = rand2.nextInt(3);
        return randomNumber+1;
    }

    public Building(String buildingType)
    {
        switch (buildingType)
        {
            case ("field"):
                this.surface=_random2()+2.0;
                break;
            case ("sty"):
                this.styCapacity=_random2()*10.0;
                break;
            case ("barn"):
                this.barnCapacity=_random2()+5.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + buildingType);
        }
    }
}