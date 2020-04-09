package com.adarsh.smartinventory.Model;

public class ShopRegistrationRequest {

    /**
     * id : 1
     * ShopName : asas
     * username : asa
     * LiscenceNumber : asas
     * Contact : asa
     * District : asas
     * Address : sasa
     * email : sasa
     * password : asasa
     */

    private int id;
    private String ShopName;
    private String username;
    private String LiscenceNumber;
    private String Contact;
    private String District;
    private String Address;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLiscenceNumber() {
        return LiscenceNumber;
    }

    public void setLiscenceNumber(String LiscenceNumber) {
        this.LiscenceNumber = LiscenceNumber;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
