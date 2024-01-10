package dbbwz;

public class Produkte {
    private String productCode;
    private String productName;
    private String productLine;
    private String productVendor;
    private int quantityInStock;
    private double buyPrice;

    public Produkte() {
    }

    @Override
    public String toString() {

        return "Product - Code: " + productCode
                + ", Name: " + productName
                + ", Line: " + productLine
                + ", Vendor " + productVendor
                + ", Quantity in Stock: " + quantityInStock
                + ", Price: " + buyPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
}
