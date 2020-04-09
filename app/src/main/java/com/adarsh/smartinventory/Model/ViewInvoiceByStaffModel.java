package com.adarsh.smartinventory.Model;

import java.util.List;

public class ViewInvoiceByStaffModel {

    /**
     * status : Success
     * customer : {"results":[{"id":10,"employee_id":16,"Name":"swxzsx","Customer_code":"xsxsx","product_name":"sss","quantity":33,"amount":"ded","sub_total":"eede","discount_percentage":"ededee","discount_rupees":"","tax":"eed","total_amount":"eded"},{"id":12,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"TV","quantity":5,"amount":"1000.0","sub_total":"5000.0","discount_percentage":"5.0","discount_rupees":"250.0","tax":"Exempted","total_amount":"0.0"},{"id":14,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"TV","quantity":5,"amount":"10000.0","sub_total":"50000.0","discount_percentage":"0.0","discount_rupees":"Rupee","tax":"Exempted","total_amount":"0.0"},{"id":15,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"TV","quantity":5,"amount":"10000.0","sub_total":"50000.0","discount_percentage":"5.0","discount_rupees":"2500.0","tax":"Exempted","total_amount":"0.0"},{"id":16,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"ghheh","quantity":3,"amount":"10000.0","sub_total":"30000.0","discount_percentage":"5.0","discount_rupees":"1500.0","tax":"GST@5%","total_amount":"30000.0"},{"id":17,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"ghheh","quantity":3,"amount":"10000.0","sub_total":"30000.0","discount_percentage":"5.0","discount_rupees":"1500.0","tax":"GST@0.25%","total_amount":"30000.0"},{"id":18,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"TV","quantity":5,"amount":"5000.0","sub_total":"25000.0","discount_percentage":"5.0","discount_rupees":"1250.0","tax":"GST@5%","total_amount":"25000.0"},{"id":19,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"g","quantity":5,"amount":"1000.0","sub_total":"5000.0","discount_percentage":"5.0","discount_rupees":"250.0","tax":"GST@0.25%","total_amount":"0.0"},{"id":20,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"g","quantity":5,"amount":"1000.0","sub_total":"5000.0","discount_percentage":"5.0","discount_rupees":"250.0","tax":"Exempted","total_amount":"0.0"},{"id":13,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"TV","quantity":5,"amount":"10000.0","sub_total":"50000.0","discount_percentage":"5.0","discount_rupees":"2500.0","tax":"GST@0.25%","total_amount":"0.0"},{"id":21,"employee_id":16,"Name":"Saurav","Customer_code":"S123","product_name":"Tv","quantity":5,"amount":"15000.0","sub_total":"75000.0","discount_percentage":"5.0","discount_rupees":"3750.0","tax":"GST@3%","total_amount":"0.0"}]}
     */

    private String status;
    private CustomerBean customer;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public static class CustomerBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 10
             * employee_id : 16
             * Name : swxzsx
             * Customer_code : xsxsx
             * product_name : sss
             * quantity : 33
             * amount : ded
             * sub_total : eede
             * discount_percentage : ededee
             * discount_rupees :
             * tax : eed
             * total_amount : eded
             */

            private int id;
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
    }
}
