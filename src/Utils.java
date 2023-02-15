import java.util.Random;

public class Utils {

    public int random() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        return randomNumber + 1;
    }

}