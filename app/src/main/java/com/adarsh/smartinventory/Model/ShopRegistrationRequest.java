package com.adarsh.smartinventory.Model;

public class ShopRegistrationRequest {

    /**
     * user : {"id":2,"first_name":"","username":"anjali","email":"","password":"pbkdf2_sha256$180000$A0LS301fBWpu$mcqdm5vmgAXNboPEk4Y1SwJuoxmYiNFFqMDU4YszkC0="}
     * id : 1
     * ShopName : ssss
     * LiscenceNumber : ssss
     * Contact : 23322
     * District : eewew
     * Address : wewe
     */

    private UserBean user;
    private int id;
    private String ShopName;
    private String LiscenceNumber;
    private int Contact;
    private String District;
    private String Address;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

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

    public String getLiscenceNumber() {
        return LiscenceNumber;
    }

    public void setLiscenceNumber(String LiscenceNumber) {
        this.LiscenceNumber = LiscenceNumber;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
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

    public static class UserBean {
        /**
         * id : 2
         * first_name :
         * username : anjali
         * email :
         * password : pbkdf2_sha256$180000$A0LS301fBWpu$mcqdm5vmgAXNboPEk4Y1SwJuoxmYiNFFqMDU4YszkC0=
         */

        private int id;
        private String first_name;
        private String username;
        private String email;
        private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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
}
