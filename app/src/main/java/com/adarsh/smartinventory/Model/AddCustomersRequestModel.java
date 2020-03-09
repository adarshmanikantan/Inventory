package com.adarsh.smartinventory.Model;

public class AddCustomersRequestModel {


    /**
     * employee_id : 1
     * Name : sasx
     * Email : sdscsx
     * Phone : 46
     * Customer_code : 3r4
     * Password : fd
     */

    private int employee_id;
    private String Name;
    private String Email;
    private int Phone;
    private String Customer_code;
    private String Password;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getCustomer_code() {
        return Customer_code;
    }

    public void setCustomer_code(String Customer_code) {
        this.Customer_code = Customer_code;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
