package main;

import crops.Seed;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Interface {

    public static void mainMenu(User user, LocalDate currentDate) {
        System.out.println();
        System.out.println("Witaj " + user.name + " Aktualnie jest: " + currentDate);
        System.out.println("-------------------------------");
        System.out.println("Jeśli chcesz zakonczyc gre wybierz 0");
        System.out.println("Jeśli chcesz wejść do sklepu wybierz 1");
        System.out.println("Jeśli chcesz sprawdzić status zwierząt i upraw wybierz 2");
        System.out.println("Jeśli chcesz sprawdzić status farm wybierz 3");
        System.out.println("Jeśli chcesz zebrać zbiory wybierz 4");
        System.out.println("Jeśli chcesz nakarmić zwierzęta wybierz 5");
        System.out.println("Jeśli chcesz pobawić się z zwierzętami wybierz 6");
        System.out.println("Jeśli chcesz zasiaść nasiona wybierz 7");
        System.out.println("Jeśli chcesz sprawdzic stan zasobów wybierz 8");
        System.out.println("Jeśli chcesz zakonczyc ture wybierz 9");
        System.out.println("-------------------------------");
    }

    public static void resourcesMenu(User user) {
        System.out.println("Posiadasz " + user.lands.size() + " farm/y");
        System.out.println("Posiadasz " + user.buildings.size() + " budynków");
        System.out.println("Posiadasz " + user.animals.size() + " zwierząt");
        System.out.println("Posiadasz " + user.getFood() + " jedzenia");
        System.out.println("Posiadasz " + user.crops.size() + " upraw");
        System.out.println("Posiadasz " + user.seeds.size() + " nasion");
        System.out.println("Posiadasz " + new BigDecimal(user.wallet).doubleValue() + " gotowki");
        System.out.println("-------------------------------");
    }

    public static void displayFarms(User user) {
        System.out.println("Twoje farmy: ");
        if (user.lands.size() == 0) {
            System.out.println("Brak");
        } else {
            for (Farm farm : user.lands) {
                System.out.println(farm);
            }
        }
        System.out.println("-------------------------------");
    }

    public static void animalsAndCropsStatus(User user) {
        System.out.println("Twoje zwierzeta i ich stan: ");
        if (user.animals.size() == 0) {
            System.out.println("Brak");
        } else {
            for (Animal animal : user.animals) {
                System.out.println(animal);
            }
        }
        System.out.println("Twoje nasiona: ");
        if (user.seeds.size() == 0) {
            System.out.println("Brak");
        } else {
            for (Seed seed : user.seeds) {
                System.out.println(seed.getType());
            }
        }
        System.out.println("Twoje rosliny i ich stan: ");
        if (user.crops.size() == 0) {
            System.out.println("Brak");
        } else {
            for (Crop crop : user.crops) {
                System.out.println(crop);
            }
            System.out.println("-------------------------------");
        }
    }

    public static void shopMainMenu(User user, Scanner scanner, Shop shop) {
        boolean wyjscieMainMenu = false;
        int choice;
        while (!wyjscieMainMenu) {
            System.out.println("-------------------------------");
            System.out.println("Jezeli chcesz cos kupić wybierz 1");
            System.out.println("Jezeli chcesz cos sprzedac wybierz 2");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
            choice = scan(scanner);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    shopBuyMenu(user, scanner, shop);
                    break;
                case 2:
                    shopSellMenu(user, scanner, shop);
                    break;
                case 0:
                    wyjscieMainMenu = true;
                    break;
                default:
                    System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
            }
        }
    }

    public static void shopBuyMenu(User user, Scanner scanner, Shop shop) {
        boolean wyjscieMainMenu = false;
        String choice;
        while (!wyjscieMainMenu) {
            System.out.println("-------------------------------");
            System.out.println(
                    "Witaj podrozniku w sklepie! Jaki produkt Ciebie interesuje? Aktualnie posiadam 'Farm','Seed','Animal'}");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wpisz 'exit'");
            choice = scanner.nextLine();
            switch (choice) {
                case "Farm":
                    shopBuyFarm(user, scanner, shop);
                    break;
                case "Seed":
                    shopBuySeed(user, scanner, shop);
                    break;
                case "Animal":
                    shopBuyAnimal(user, scanner, shop);
                    break;
                case "exit":
                    wyjscieMainMenu = true;
                    break;
                default:
                    System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
            }
        }
    }

    public static void shopBuyFarm(User user, Scanner scanner, Shop shop) {
        boolean wyjscieShopMenu = false;
        int choice;
        while (!wyjscieShopMenu) {
            System.out.println("-------------------------------");
            System.out.println("Przedmioty do zakupu:");
            for (Farm farm : shop.getItemsForSale()) {
                System.out.print(farm.getFarmId() + ": ");
                System.out.println(farm);
            }
            System.out.println("Jezeli chcesz cos kupić wybierz id farmy");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
            choice = scan(scanner);
            if (choice == 0) {
                break;
            }
            for (Farm farm : shop.getItemsForSale()) {
                if (farm.getFarmId() == choice) {
                    if (user.getWallet() >= farm.getPrice()) {
                        user.lands.add(farm);
                        user.setWallet(user.getWallet() - farm.getPrice());
                        shop.getItemsForSale().remove(farm);
                        break;
                    } else {
                        System.out.println("Nie masz wystarczajaco pieniedzy!");
                    }
                }
            }
        }
    }

    public static void shopBuyAnimal(User user, Scanner scanner, Shop shop) {
        boolean wyjscieShopMenu = false;
        int counter = 0;
        String choice;
        while (!wyjscieShopMenu) {
            System.out.println("-------------------------------");
            System.out.println("Zwierzeta do zakupu:");
            for (Animal animal : shop.getAnimalsForSale()) {
                System.out.print(animal.getName() + ": ");
                System.out.println(animal);
            }
            System.out.println("Jezeli chcesz zakupic ktores z zwierzat wpisz 'Cow','Dog','Chicken'");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wpisz 'exit'");
            choice = scanner.nextLine();
            if (choice == "exit") {
                break;
            }
            for (Animal animal : shop.getAnimalsForSale()) {
                if (animal.getName().equals(choice)) {
                    if (user.getWallet() >= animal.getPurchasePrice()) {
                        user.animals.add(animal);
                        user.setWallet(user.getWallet() - animal.getPurchasePrice());
                        break;
                    } else {
                        System.out.println("Nie masz wystarczajaco pieniedzy!");
                    }
                }
                counter = counter + 1;
            }
            if (counter == 0) {
                System.out.println("Wpisales nie poprawna nazwe sadzonki, sprobuj jeszcze raz");
            }
        }
    }

    public static void shopBuySeed(User user, Scanner scanner, Shop shop) {
        boolean wyjscieShopMenu = false;
        String choice;
        int counter = 0;
        while (!wyjscieShopMenu) {
            System.out.println("-------------------------------");
            System.out.println("Nasiona do zakupu:");
            for (Seed seed : shop.getSeedsForSale()) {
                System.out.println(seed.getType());
            }
            System.out.println("Jezeli chcesz cos kupić wybierz nazwe sadzonki ");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wpisz exit");
            choice = scanner.nextLine();
            if (choice.equals("exit")) {
                break;
            }
            for (Seed seed : shop.getSeedsForSale()) {
                if (seed.getType().equals(choice)) {
                    if (user.getWallet() >= seed.getPrize()) {
                        user.seeds.add(seed);
                        user.setWallet(user.getWallet() - seed.getPrize());
                        System.out.println("Zakupiles jedna sadzonke: " + seed.getType());
                    } else {
                        System.out.println("Nie masz wystarczajaco pieniedzy!");
                    }
                    counter = counter + 1;
                }
            }
            if (counter == 0) {
                System.out.println("Wpisales nie poprawna nazwe sadzonki, sprobuj jeszcze raz");
            }
        }
    }

    public static void shopSellMenu(User user, Scanner scanner, Shop shop) {
        boolean wyjscieShopMenu = false;
        int choice;
        while (!wyjscieShopMenu) {
            System.out.println("-------------------------------");
            System.out.println("Przedmioty do sprzedazy:");
            for (Farm farm : shop.getItemsForSale()) {
                System.out.print(farm.getFarmId() + ": ");
                System.out.println(farm);
            }
            System.out.println("Jezeli chcesz cos kupić wybierz id farmy");
            System.out.println("Jezeli chcesz wrocic do poprzedniego menu wybierz 0");
            choice = scan(scanner);
            if (choice == 0) {
                break;
            }
            for (Farm farm : shop.getItemsForSale()) {
                if (farm.getFarmId() == choice) {
                    if (user.getWallet() >= farm.getPrice()) {
                        user.lands.add(farm);
                        user.setWallet(user.getWallet() - farm.getPrice());
                        shop.getItemsForSale().remove(farm);
                        break;
                    } else {
                        System.out.println("Nie masz wystarczajaco pieniedzy!");
                    }
                }
            }
        }
    }

    public static void finalResult(LocalDate currentDate) {
        long finalResult = ChronoUnit.DAYS.between(LocalDate.of(2020, 01, 01), currentDate);
        System.out.print("BRAWO! Udało Ci się przejść grę w: ");
        System.out.print(finalResult);
        System.out.print(" dni");
    }

    public static int scan(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest Integer sprobuj ponownie!");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    public static ArrayList<Farm> createNewFarms(int farmId) {
        ArrayList<Farm> farms = new ArrayList<>();
        for (int i = farmId; i < farmId + 3; i++) {
            farms.add(new Farm(i, createRandomIntBetween(1, 10), createRandomIntBetween(1, 3),
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