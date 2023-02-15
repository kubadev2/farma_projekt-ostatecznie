package main;

public class Animal implements Product {

    private String animalName;

    private Double purchasePrice;

    private Double happiness;

    private Double dailyMoneyMade;

    private Double health;

    public Animal(String name, Double initPurchasePrice, Double initHappiness, Double initdailyMoneyMade) {
        animalName = name;
        purchasePrice = initPurchasePrice;
        happiness = initHappiness;
        dailyMoneyMade = initdailyMoneyMade;
        health = 1.0;
    }

    public void increaseHappiness() {
        happiness += 0.1;
    }

    public void increaseHealth(double healthToIncrease) {
        health += healthToIncrease;
    }

    public double getDailyProfit() {
        return happiness * health * dailyMoneyMade;
    }

    public String getName() {
        return animalName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getHappiness() {
        return happiness;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", happiness=" + happiness +
                ", dailyMoneyMade=" + dailyMoneyMade +
                ", health=" + health +
                '}';
    }
}