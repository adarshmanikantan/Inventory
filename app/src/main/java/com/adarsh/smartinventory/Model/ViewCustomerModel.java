package com.adarsh.smartinventory.Model;

import java.util.List;

public class ViewCustomerModel {

    /**
     * status : Success
     * details : {"results":[{"id":4,"employee_id":1,"Name":"sasx","Email":"sdscsx","Phone":46,"Customer_code":"3r4","Password":"fd"}]}
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
             * employee_id : 1
             * Name : sasx
             * Email : sdscsx
             * Phone : 46
             * Customer_code : 3r4
             * Password : fd
             */

            private int id;
            private int employee_id;
            private String Name;
            private String Email;
            private int Phone;
            private String Customer_code;
            private String Password;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

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
    }
}
