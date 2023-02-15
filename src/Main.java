import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2020, 01, 01);
        System.out.println("Rozpoczynamy grę");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        String name = scanner.next();
        User user = new User(name);

        List<Farm> farms = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            farms.add(new Farm());
        }

        int choice;

        while (!user.checkWinCondition()) {
            System.out.println("Witaj " + user.name + " Aktualnie jest: " + currentDate);
            System.out.println("Posiadasz " + user.lands.size() + " farm/y");
            System.out.println("Posiadasz " + user.buildings.size() + " budynków");
            System.out.println("Posiadasz " + user.animals.size() + " zwierząt");
            System.out.println("Posiadasz " + user.crops.size() + " upraw");
            System.out.println("Posiadasz " + user.wallet + " gotowki");
            System.out.println("Jeśli chcesz kupić farmę wybierz 1");
            System.out.println("Jeśli chcesz zakonczyc ture wybierz 2");
            choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    System.out.println("Wybierz numer aby kupić: ");
                    for (int i = 1; i <= farms.size(); i++) {
                        System.out.println("Farma " + i);
                        System.out.println("Cena:  " + farms.get(i - 1).price);
                        System.out.println();
                    }
                    break;
                case 2:
                    currentDate = currentDate.plusWeeks(1);
                    break;
                default:
                    // code block
            }
        }
    }
}