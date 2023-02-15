import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Farm
{
    double surface;
    double styCapacity;
    double barnCapacity;
    double price;

    public int sty;
    public int barn;
    public int field;


    public int _random()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        return randomNumber+1;
    }
    public Farm ()
    {
        this.sty = _random();
        this.barn = _random();
        this.field = _random();
        List<Building> buildings = new ArrayList<>();

        for (int j = 0; j < this.sty; j++)
        {
            buildings.add(new Building("sty"));
        }
        for (int z = 0; z < this.barn; z++)
        {
            buildings.add(new Building("barn"));
        }
        for (int x = 0; x < this.sty; x++)
        {
            buildings.add(new Building("field"));
        }


    }
}