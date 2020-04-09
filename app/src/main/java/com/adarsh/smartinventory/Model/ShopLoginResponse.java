package com.adarsh.smartinventory.Model;

import java.util.List;

public class ShopLoginResponse{


    /**
     * status : Success
     * details : {"results":[{"id":4,"ShopName":"q","username":"bh","LiscenceNumber":"26272","Contact":"26262","District":"ghh","Address":"gs","email":"q@gmail.com","password":"1234"}]}
     */

    private String status;
    private DetailsBean details;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DetailsBean getDetails() {
        return details;
    }

    public void setDetails(DetailsBean details) {
        this.details = details;
    }

    public static class DetailsBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 4
             * ShopName : q
             * username : bh
             * LiscenceNumber : 26272
             * Contact : 26262
             * District : ghh
             * Address : gs
             * email : q@gmail.com
             * password : 1234
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
    }
}
