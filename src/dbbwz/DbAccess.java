package dbbwz;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAccess {
    private String url = "jdbc:mysql://localhost:3306/classicmodels";
    private String user = "root";
    private String pass = "ims2022?Ja-Rappi";

    public DbAccess(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public List<Produkte> getProdukte() {
        List<Produkte> produkte = new ArrayList<>();

        try {
            Connection con = connectToDatabase();
            Statement statement = con.createStatement();
            String abfrage = "SELECT productCode, productName, productLine, productVendor, quantityInStock, buyPrice FROM products";
            ResultSet resultSet = statement.executeQuery(abfrage);

            while (resultSet.next()) {
                Produkte produkt = mapResultSetToProdukt(resultSet);
                produkte.add(produkt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkte;
    }

    private Connection connectToDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC-Treiber nicht gefunden", e);
        }
    }

    private Produkte mapResultSetToProdukt(ResultSet resultSet) throws SQLException {
        Produkte produkt = new Produkte();
        produkt.setProductCode(resultSet.getString("productCode"));
        produkt.setProductName(resultSet.getString("productName"));
        produkt.setProductLine(resultSet.getString("productLine"));
        produkt.setProductVendor(resultSet.getString("productVendor"));
        produkt.setQuantityInStock(resultSet.getInt("quantityInStock"));
        produkt.setBuyPrice(resultSet.getDouble("buyPrice"));
        return produkt;
    }
}