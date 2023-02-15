package buildings;

import main.Product;

public class Barn implements Product
{
    private int capability = 1000;
    private String type;

    public Barn() {
        this.capability = 1000;
        this.type = "Barn";
    }

    @Override
    public double getPurchasePrice() {
        return 1000;
    }

    @Override
    public String getName() {
        return "Barn";
    }
}