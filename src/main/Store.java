package main;

import animals.Chicken;
import animals.Cow;
import animals.Dog;
import java.util.ArrayList;

public class Store {

    private ArrayList<Crop> cropsForSale = new ArrayList<Crop>();

    private ArrayList<Animal> animalsForSale = new ArrayList<Animal>();

    private ArrayList<Farm> itemsForSale = new ArrayList<Farm>();

    public Store(double initAnimalHappiness) {
        // Crops
//    cropsForSale.add(new Wheat());
//    cropsForSale.add(new Corn());
//    cropsForSale.add(new Potato());
//    cropsForSale.add(new Parsnip());
//    cropsForSale.add(new Strawberry());
//    cropsForSale.add(new Pumpkin());

        // Animals
        animalsForSale.add(new Chicken(initAnimalHappiness));
        animalsForSale.add(new Cow(initAnimalHappiness));
        animalsForSale.add(new Dog(initAnimalHappiness));

        // Items
        // The bonus for crops is an increase in the days grown.
//    itemsForSale.add(new OrganicFertiliser());
//    itemsForSale.add(new InorganicFertiliser());
//    itemsForSale.add(new Compost());
//    //The bonus for Animals is health given from food.
//    itemsForSale.add(new Apples());
//    itemsForSale.add(new HayBales());
//    itemsForSale.add(new Lucerne());
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

}