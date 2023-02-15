package main;

import static java.lang.System.exit;
import static main.Interface.animalsAndCropsStatus;
import static main.Interface.displayFarms;
import static main.Interface.finalResult;
import static main.Interface.mainMenu;
import static main.Interface.resourcesMenu;
import static main.Interface.shopMainMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int farmId = 1;
        LocalDate currentDate = LocalDate.of(2020, 01, 01);
        System.out.println("Rozpoczynamy grę");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        String name = scanner.next();
        User user = new User(name);

        Shop shop = new Shop(farmId);
        int choice;

        while (!user.checkWinCondition()) {
            mainMenu(user, currentDate);
            choice = Interface.scan(scanner);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    shopMainMenu(user, scanner, shop);
                    break;
                case 2:
                    animalsAndCropsStatus(user);
                    break;
                case 3:
                    displayFarms(user);
                    break;
                case 8:
                    resourcesMenu(user);
                    break;
                case 9:
                    currentDate = currentDate.plusWeeks(1);
                    farmId = farmId + 3; // Zwiekszamy id o 3 aby zapobiec duplikatom id farm.
                    shop.setItemsForSale(Interface.createNewFarms(farmId));
                    break;
                case 0:
                    System.out.println("Dziękuje za gre, do zobaczenia następnym razem!");
                    exit(0);
                default:
                    System.out.println("Wybrano nie poprawna wartosc, sprobuj jeszcze raz!");
            }
        }
        finalResult(currentDate);
    }
}