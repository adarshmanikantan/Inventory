package com.adarsh.smartinventory.Model;

public class QrRequestModel {

    /**
     * employee_id : 2
     * Customer_code : wwq
     * product_name : qqwq
     * qrcode : qwqw
     */

    private int employee_id;
    private String Customer_code;
    private String product_name;
    private String qrcode;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
