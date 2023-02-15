package crops;

public class Seed {
    String type;
    int prize;

    public Seed(String type, int prize) {
        this.type = type;
        this.prize = prize;
    }

    public String getType() {
        return type;
    }

    public int getPrize() {
        return prize;
    }
}