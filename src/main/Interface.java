package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Interface {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

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

    public static User shopMenu(User user, Scanner scanner, List<Farm> farms) {
        boolean wyjscieMainMenu = false;
        boolean wyjscieShopMenu = false;
        int choice;
        while (!wyjscieMainMenu) {
            System.out.println();
            System.out.println("Jezeli chcesz cos kupić wybierz 1");
            System.out.println("Jezeli chcesz cos sprzedac wybierz 2");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
            choice = scan(scanner);
            switch (choice) {
                case 1:
                    while (!wyjscieShopMenu) {
                        System.out.println("Przedmioty do zakupu:");
                        for (Farm farm : farms) {
                            System.out.print(farm.getFarmId() + ": ");
                            System.out.println(farm);
                        }
                        System.out.println("Jezeli chcesz cos kupić wybierz id farmy");
                        System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
                        choice = scan(scanner);
                        if (choice == 0) {
                            break;
                        }
                        for (Farm farm : farms) {
                            if (farm.getFarmId() == choice) {
                                if (user.getWallet() >= farm.getPrice()) {
                                    user.lands.add(farm);
                                    user.setWallet(user.getWallet() - farm.getPrice());
                                    farms.remove(farm);
                                    break;
                                } else {
                                    System.out.println("Nie masz wystarczajaco pieniedzy!");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Przedmioty do sprzedaży:");
                    break;
                case 0:
                    wyjscieMainMenu = true;
                    break;
                default:
                    System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
            }
        }
        return user;
    }

    public static int scan(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest Integer sprobuj ponownie!");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    public static List<Farm> createNewFarms(int farmId) {
        List<Farm> farms = new ArrayList<>();
        for (int i = farmId; i < farmId + 3; i++) {
            farms.add(new Farm(i, createRandomIntBetween(1, 10), createRandomIntBetween(1, 10),
                    createRandomDoubleBetween(100d, 1000d), createRandomIntBetween(1, 10)));
        }
        return farms;
    }

    public static int createRandomIntBetween(int low, int high) {
        Random random = new Random();

        return random.nextInt(high - low) + low;
    }

    public static double createRandomDoubleBetween(double low, double high) {
        Random random = new Random();
        BigDecimal bigDecimal = new BigDecimal(low + (high - low) * random.nextDouble()).setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}