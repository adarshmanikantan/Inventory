package com.adarsh.smartinventory.Model;

import java.util.List;

public class ViewQrModel {

    /**
     * status : Success
     * details : {"results":[{"id":2,"employee_id":1,"Customer_code":"123","product_name":"qqeeewq","qrcode":"qwqeew"},{"id":3,"employee_id":6,"Customer_code":"123","product_name":"Tv","qrcode":",hhxjxjxjxjxhxjxjxjxjxzfh  nju"}]}
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
             * id : 2
             * employee_id : 1
             * Customer_code : 123
             * product_name : qqeeewq
             * qrcode : qwqeew
             */

            private int id;
            private int employee_id;
            private String Customer_code;
            private String product_name;
            private String qrcode;

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
    }
}
