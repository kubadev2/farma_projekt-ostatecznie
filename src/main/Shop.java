package main;

import animals.Chicken;
import animals.Cow;
import animals.Dog;
import buildings.Barn;
import crops.Seed;
import java.util.ArrayList;

public class Shop {

    private ArrayList<Animal> animalsForSale = new ArrayList<>();

    private ArrayList<Farm> itemsForSale = new ArrayList<>();

    private ArrayList<Barn> buildingsForSale = new ArrayList<>();

    private ArrayList<Seed> seedsForSale = new ArrayList<>();

    public Shop(int farmId) {
        itemsForSale = Interface.createNewFarms(farmId);
        buildingsForSale.add(new Barn());
        animalsForSale.add(new Cow(0.5));
        animalsForSale.add(new Chicken(0.5));
        animalsForSale.add(new Dog(0.5));
        seedsForSale.add(new Seed("Strawberry", 40));
        seedsForSale.add(new Seed("Corn", 20));
        seedsForSale.add(new Seed("Grain", 10));
    }


    public ArrayList<Animal> getAnimalsForSale() {
        return animalsForSale;
    }


    public Animal buyAnimals(int index) {
        return animalsForSale.get(index);
    }

    public ArrayList<Farm> getItemsForSale() {
        return itemsForSale;
    }

    public ArrayList<Seed> getSeedsForSale() {
        return seedsForSale;
    }

    public void setItemsForSale(ArrayList<Farm> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }
}