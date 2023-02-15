package main;

import java.time.LocalDate;
import java.util.Scanner;

public class Interface {

    public static void mainMenu(User user, LocalDate currentDate) {
        System.out.println();
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
        System.out.println("-------------------------------");
    }

    public static void shopMenu(Scanner scanner) {
        boolean wyjscie = false;
        int choice;
        while (!wyjscie) {
            System.out.println();
            System.out.println("Jezeli chcesz cos kupić wybierz 1");
            System.out.println("Jezeli chcesz cos sprzedac wybierz 2");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
            choice = scan(scanner);
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
    }

    public static int scan(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest Integer sprobuj ponownie!");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }
}