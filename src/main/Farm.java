package main;

import java.util.ArrayList;

public class Farm {

    private int farmId;
    private ArrayList<Crop> crops = new ArrayList<Crop>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    int surface;
    int buildingsCapacity;
    double price;
    int cropSpace;

    public Farm(int farmId, int surface, int buildingsCapacity, double price, int cropSpace) {
        this.farmId = farmId;
        this.surface = surface;
        this.buildingsCapacity = buildingsCapacity;
        this.price = price;
        this.cropSpace = cropSpace;
    }

    public int getFarmId() {
        return farmId;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmId='" + farmId + '\'' +
                ", crops=" + crops +
                ", animals=" + animals +
                ", surface=" + surface +
                ", buildingsCapacity=" + buildingsCapacity +
                ", price=" + price +
                ", cropSpace=" + cropSpace +
                '}';
    }
}