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
            scanner.nextLine();  // Clear the newline character from the buffer

            switch (option) {
                case 1:
                    System.out.println("Wollen Sie einen Filter setzen? y/n ");
                    char filterChoice = scanner.nextLine().charAt(0);

                    if (filterChoice == 'n') {
                        displayAllProducts();
                    } else {
                        System.out.println("Setzen Sie den Filter");
                        // Hier kannst du Logik für die Filterung hinzufügen
                    }
                    break;


                case 2:
                    displayAllUsers();
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

