package com.adarsh.smartinventory.Model;

public class InvoiceRequestModel {

    /**
     * employee_id : 1
     * Name : swxzsx
     * Customer_code : xsxsx
     * product_name : sxss
     * quantity : 33
     * amount : ded
     * sub_total : eede
     * discount_percentage : ededee
     * discount_rupees : ede
     * tax : eed
     * total_amount : eded
     */

    private int employee_id;
    private String Name;
    private String Customer_code;
    private String product_name;
    private int quantity;
    private String amount;
    private String sub_total;
    private String discount_percentage;
    private String discount_rupees;
    private String tax;
    private String total_amount;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCustomer_code() {
        return Customer_code;
    }

    public void setCustomer_code(String Customer_code) {
        this.Customer_code = Customer_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSub_total() {
        return sub_total;
    }

    public void setSub_total(String sub_total) {
        this.sub_total = sub_total;
    }

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getDiscount_rupees() {
        return discount_rupees;
    }

    public void setDiscount_rupees(String discount_rupees) {
        this.discount_rupees = discount_rupees;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
}
