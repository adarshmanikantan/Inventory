package com.adarsh.smartinventory.Model;

public class AddProductRequestModel {

    /**
     * id : 2
     * shopowner_id : 2
     * name : dsfsf
     * description : sfs
     * price : 333
     * quantity : 33
     * dealer_name : sdsf
     * dealer_phone : 999
     */

    private int id;
    private int shopowner_id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String dealer_name;
    private String dealer_phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopowner_id() {
        return shopowner_id;
    }

    public void setShopowner_id(int shopowner_id) {
        this.shopowner_id = shopowner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDealer_name() {
        return dealer_name;
    }

    public void setDealer_name(String dealer_name) {
        this.dealer_name = dealer_name;
    }

    public String getDealer_phone() {
        return dealer_phone;
    }

    public void setDealer_phone(String dealer_phone) {
        this.dealer_phone = dealer_phone;
    }
}
