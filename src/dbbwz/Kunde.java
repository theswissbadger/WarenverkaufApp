package dbbwz;

public class Kunde {
    @Override
    public String toString() {

        return "Customer Numer: " + customerNumber
                + ", Name: " + customerName
                + ", Last Name Contact: " + contactLastName
                + ", First Name Contact: " + contactFirstName
                + ", Postal Code: " + postalCode
                + ", City: " + city
                + ", State: " + state;
    }
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String postalCode;
    private String city;
    private String state;

    public Kunde() {
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
