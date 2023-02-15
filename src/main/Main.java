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
            System.out.println();
            System.out.println("-------------------------------");
            System.out.println("Witaj " + user.name + " Aktualnie jest: " + currentDate);
            System.out.println("Posiadasz " + user.lands.size() + " farm/y");
            System.out.println("Posiadasz " + user.buildings.size() + " budynków");
            System.out.println("Posiadasz " + user.animals.size() + " zwierząt");
            System.out.println("Posiadasz " + user.lands.size() + " upraw");
            System.out.println("Posiadasz " + user.wallet + " gotowki");
            System.out.println("-------------------------------");
            System.out.println("Jeśli chcesz zakonczyc gre wybierz 0");
            System.out.println("Jeśli chcesz wejść do sklepu wybierz 1");
            System.out.println("Jeśli chcesz sprawdzić status zwierząt i upraw wybierz 2");
            System.out.println("Jeśli chcesz sprawdzić status farm wybierz 3");
            System.out.println("Jeśli chcesz zebrać zbiory wybierz 4");
            System.out.println("Jeśli chcesz nakarmić zwierzęta wybierz 5");
            System.out.println("Jeśli chcesz pobawić się z zwierzętami wybierz 6");
            System.out.println("Jeśli chcesz zasiaść nasiona wybierz 7");
            System.out.println("Jeśli chcesz sprawdzic stan zapasow wybierz 8");
            System.out.println("Jeśli chcesz zakonczyc ture wybierz 9");
            choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    while (!wyjscie) {
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Jezeli chcesz cos kupić wybierz 1");
                        System.out.println("Jezeli chcesz cos sprzedac wybierz 2");
                        System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
                        choice = Integer.parseInt(scanner.next());
                        switch (choice) {
                            case 1:
                                System.out.println("Przedmioty do zakupu:");
                                break;
                            case 2:
                                System.out.println("Przedmioty do sprzedaży:");
                                break;
                            case 0:
                                wyjscie = true;
                                break;
                            default:
                                System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
                        }
                    }
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