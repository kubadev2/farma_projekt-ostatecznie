package main;

import static java.lang.System.exit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean wyjscie = false;

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
            Interface.mainMenu(user, currentDate);
            choice = Interface.scan(scanner);
            switch (choice) {
                case 1:
                    Interface.shopMenu(scanner);
                case 9:
                    currentDate = currentDate.plusWeeks(1);
                    break;
                case 0:
                    System.out.println("Dziękuje za gre, do zobaczenia następnym razem!");
                    exit(0);
                default:
                    System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
            }
        }
        long finalResult = ChronoUnit.DAYS.between(LocalDate.of(2020, 01, 01), currentDate);
        System.out.print("Udało Ci się przejść grę w: ");
        System.out.print(finalResult);
        System.out.print(" dni");
    }
}