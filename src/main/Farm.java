package main;

import java.util.ArrayList;

public class Farm {

    private String farmName;
    private ArrayList<Crop> crops = new ArrayList<Crop>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    double surface;
    double buildingsCapacity;
    double price;

    private int cropSpace;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getBuildingsCapacity() {
        return buildingsCapacity;
    }

    public void setBuildingsCapacity(double buildingsCapacity) {
        this.buildingsCapacity = buildingsCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCropSpace() {
        return cropSpace;
    }

    public void setCropSpace(int cropSpace) {
        this.cropSpace = cropSpace;
    }

}