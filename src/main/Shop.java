package main;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Crop> cropsForSale = new ArrayList<Crop>();

    private ArrayList<Animal> animalsForSale = new ArrayList<Animal>();

    private ArrayList<Farm> itemsForSale = new ArrayList<Farm>();

    public Shop(int farmId) {
        itemsForSale = Interface.createNewFarms(farmId);

    }

    public ArrayList<Crop> getCropsForSale() {
        return cropsForSale;
    }

    public ArrayList<Animal> getAnimalsForSale() {
        return animalsForSale;
    }

    public Crop buyCrops(int index) {
        return cropsForSale.get(index);
    }

    public Animal buyAnimals(int index) {
        return animalsForSale.get(index);
    }

    public ArrayList<Farm> getItemsForSale() {
        return itemsForSale;
    }

    public void setItemsForSale(ArrayList<Farm> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }
}