package main;

import buildings.Barn;
import crops.Seed;
import java.util.ArrayList;
import java.util.List;

public class User {

    public static final Double DEFAULT_START_WALLET_BALANCE = 1000.0;
    public double wallet;
    public String name;
    public int food;
    public List<Farm> lands = new ArrayList<>();
    public List<Barn> buildings = new ArrayList<>();
    public List<Animal> animals = new ArrayList<>();
    public List<Seed> seeds = new ArrayList<>();

    public List<Crop> crops = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.wallet = DEFAULT_START_WALLET_BALANCE;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean checkWinCondition() {
        return false;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

}