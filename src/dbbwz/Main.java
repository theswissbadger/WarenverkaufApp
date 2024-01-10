package dbbwz;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        DbAccess dbZugriff = new DbAccess("jdbc:mysql://localhost:3306/classicmodels", "root", "ims2022?Ja-Rappi");
        List<Produkte> produkte = dbZugriff.getProdukte();

        for (Produkte produkt : produkte) {
            System.out.println(produkt);
        }

    }
}
