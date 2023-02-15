package main;

public class Crop implements Product {

    private String cropName;

    private double purchasePrice;

    private double sellPrice;

    private int daysToGrow;

    private int daysGrown = 0;

    public Crop(String name, double initPurchasePrice, double initSellPrice, int initDaysToGrow) {
        cropName = name;
        purchasePrice = initPurchasePrice;
        sellPrice = initSellPrice;
        daysToGrow = initDaysToGrow;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public String getName() {
        return cropName;
    }

    public int getDaysLeftToGrow() {
        return daysToGrow - daysGrown;
    }

    public void grow() {
        if (getDaysLeftToGrow() > 0) {
            daysGrown = daysGrown + 7;
        }

    }

    public boolean canHarvest() {
        if (daysGrown >= daysToGrow) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "cropName='" + cropName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellPrice=" + sellPrice +
                ", daysToGrow=" + daysToGrow +
                ", daysGrown=" + daysGrown +
                '}';
    }
}