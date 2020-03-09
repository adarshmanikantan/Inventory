package com.adarsh.smartinventory.Model;

import java.util.List;

public class StaffLogin {

    /**
     * status : Success
     * empdata : {"results":[[{"id":15,"shopowner_id":4,"Name":"s","Email":"s@gmail.com","Employee_Code":"s","Contact":1234,"Password":"1234"}]]}
     */

    private String status;
    private EmpdataBean empdata;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmpdataBean getEmpdata() {
        return empdata;
    }

    public void setEmpdata(EmpdataBean empdata) {
        this.empdata = empdata;
    }

    public static class EmpdataBean {
        private List<List<ResultsBean>> results;

        public List<List<ResultsBean>> getResults() {
            return results;
        }

        public void setResults(List<List<ResultsBean>> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 15
             * shopowner_id : 4
             * Name : s
             * Email : s@gmail.com
             * Employee_Code : s
             * Contact : 1234
             * Password : 1234
             */

            private int id;
            private int shopowner_id;
            private String Name;
            private String Email;
            private String Employee_Code;
            private int Contact;
            private String Password;

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
    }
}
