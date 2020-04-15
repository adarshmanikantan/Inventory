package com.adarsh.smartinventory.Model;

import java.util.List;

public class ViewEmployeeModel {

    /**
     * status : Success
     * employee : {"results":[{"id":3,"shopowner_id":1,"Name":"aax","Email":"zxzxz","Employee_Code":"zxzx","Contact":2434,"Password":"dsssd"},{"id":4,"shopowner_id":1,"Name":"ccsfffsd","Email":"cybsdcccer@gmail.com","Employee_Code":"1dd23","Contact":2344232,"Password":"233322"}]}
     */

    private String status;
    private EmployeeBean employee;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public static class EmployeeBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 3
             * shopowner_id : 1
             * Name : aax
             * Email : zxzxz
             * Employee_Code : zxzx
             * Contact : 2434
             * Password : dsssd
             */

            private int id;
            private int shopowner_id;
            private String Name;
            private String Email;
            private String Employee_Code;
            private String Contact;
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

            public String getContact() {
                return Contact;
            }

            public void setContact(String Contact) {
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
