package dbbwz;

import java.util.List;
import java.util.Scanner;

public class WarenverkaufModel {
    private DbAccess dbAccess;

    public WarenverkaufModel(DbAccess dbAccess) {
        this.dbAccess = dbAccess;
    }
    public WarenverkaufModel(){

    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Alle Produkte anzeigen");
            System.out.println("2. Alle Benutzer anzeigen");
            System.out.println("3. Einen Kunden suchen");
            System.out.println("4. App beenden");
            System.out.print("Bitte wählen Sie eine Option (1-4): ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Wollen Sie einen Filter setzen? y/n ");
                    char filterChoice = scanner.nextLine().charAt(0);

                    if (filterChoice == 'n') {
                        displayAllProducts();
                    } else {
                        System.out.print("Geben Sie die Produktlinie ein: ");
                        String productLineFilter = scanner.nextLine();
                        displayFilteredProducts(productLineFilter);
                        break;
                    }
                    break;
                case 2:
                    displayAllCustomers();
                    break;

                case 3:
                    System.out.println("Geben sie den Namen ein: ");
                    String customerFilter = scanner.nextLine();
                    displayFilteredCustomers(customerFilter);
                    break;


                case 4:
                    System.out.println("Die App wird beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }

    private void displayAllProducts() {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "{password}");
        List<Produkte> produkte = dbAccess.getProdukte();
        System.out.println("Alle Produkte:");

        for (Produkte produkt : produkte) {
            System.out.println(produkt);
        }
    }

    private void displayAllCustomers() {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "{password}");
        List<Kunde> kunden = dbAccess.getKunden();
        System.out.println("Alle Produkte:");

        for (Kunde kunde : kunden) {
            System.out.println(kunde);
        }
    }

    private void displayFilteredProducts(String productLineFilter) {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "{password}");
        List<Produkte> filteredProducts = dbAccess.getFilteredProdukte(productLineFilter);

        if (filteredProducts.isEmpty()) {
            System.out.println("Keine Produkte für die angegebene Produktlinie gefunden.");
        } else {
            System.out.println("Gefilterte Produkte für Produktlinie '" + productLineFilter + "':");
            for (Produkte produkt : filteredProducts) {
                System.out.println(produkt);
            }
        }
    }

    private void displayFilteredCustomers(String filterUser) {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "{password}");
        List<Kunde> filteredUsers = dbAccess.searchUser(filterUser);

        if (filteredUsers.isEmpty()) {
            System.out.println("Keine Kunden mit diesem Namen gefunden.");
        } else {

            for (Kunde kunde : filteredUsers) {
                System.out.println(kunde);
            }
        }
    }
}

