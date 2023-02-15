package main;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static final Double DEFAULT_START_WALLET_BALANCE = 5000.0;
    public double wallet;
    public String name;

    public List<Farm> lands = new ArrayList<>();
    public List<Building> buildings = new ArrayList<>();
    public List<Flowers> crops = new ArrayList<>();
    public List<Animal> animals = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.wallet = DEFAULT_START_WALLET_BALANCE;
    }

    public boolean checkWinCondition() {
        return false;
    }

    public void buyAsset(List<Farm> farm, double price, int index, boolean isFarm) {
        if (this.wallet >= price) {
//            setAsset(index, isFarm, farm);
        }
    }

//    public void setAsset(int index, boolean isFarm, List<main.Farm>farm)
//    {
//        if(isFarm)
//        {
//            userBuildings.add(farm.get(index));
//            System.out.println(userBuildings.get(1));
//        }
//    }

    public void setAsset(Building buildingType, int index) {

    }
//    public void assets()
//    {
//        double totalStyCapacity;
//        double totalBarnCapacity;
//        double totalSurface;
//        int size = userBuildings.size();
//        for (int i=0; i<size; i++)
//        {
//            System.out.println(userBuildings.get(i));
//        }
//    }

}