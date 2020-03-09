package com.adarsh.smartinventory.Model;

public class AddEmployeeRequest {


    /**
     * shopowner_id : 1
     * Name : dsds
     * Email : sds
     * Employee_Code : sds
     * Contact : 34343
     * Password : sdsds
     */

    private int shopowner_id;
    private String Name;
    private String Email;
    private String Employee_Code;
    private int Contact;
    private String Password;

    public int getShopowner_id() {
        return shopowner_id;
    }

    public void setShopowner_id(int shopowner_id) {
        this.shopowner_id = shopowner_id;
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

    public String getEmployee_Code() {
        return Employee_Code;
    }

    public void setEmployee_Code(String Employee_Code) {
        this.Employee_Code = Employee_Code;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
