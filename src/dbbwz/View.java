package dbbwz;

import java.util.List;
import java.util.Scanner;

public class View {
    private DbAccess dbAccess;

    public View(DbAccess dbAccess) {
        this.dbAccess = dbAccess;
    }
    public View(){

    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Alle Produkte anzeigen");
            System.out.println("2. Alle Benutzer anzeigen");
            System.out.println("3. App beenden");
            System.out.print("Bitte wählen Sie eine Option (1-3): ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Clear the newline character from the buffer

            switch (option) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    displayAllUsers();
                    break;
                case 3:
                    System.out.println("Die App wird beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }

    private void displayAllProducts() {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "ims2022?Ja-Rappi");
        List<Produkte> produkte = dbAccess.getProdukte();
        System.out.println("Alle Produkte:");

        for (Produkte produkt : produkte) {
            System.out.println(produkt);
        }
    }

    private void displayAllUsers() {
        DbAccess dbAccess = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "ims2022?Ja-Rappi");
        List<Kunde> kunden = dbAccess.getKunden();
        System.out.println("Alle Produkte:");

        for (Kunde kunde : kunden) {
            System.out.println(kunde);
        }
    }
}

