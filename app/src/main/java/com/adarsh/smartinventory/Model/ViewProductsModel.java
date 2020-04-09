package com.adarsh.smartinventory.Model;

import java.util.List;

public class ViewProductsModel {

    /**
     * status : Success
     * product : {"results":[[{"id":3,"shopowner_id":1,"name":"tvSDS","description":"wdDSSDs","price":1700550,"quantity":33,"dealer_name":"SDSDee","dealer_phone":"dSDeed"},{"id":1,"shopowner_id":1,"name":"tv","description":"wds","price":17000,"quantity":3,"dealer_name":"ee","dealer_phone":"deed"}]]}
     */

    private String status;
    private ProductBean product;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        private List<List<ResultsBean>> results;

        public List<List<ResultsBean>> getResults() {
            return results;
        }

        public void setResults(List<List<ResultsBean>> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 3
             * shopowner_id : 1
             * name : tvSDS
             * description : wdDSSDs
             * price : 1700550
             * quantity : 33
             * dealer_name : SDSDee
             * dealer_phone : dSDeed
             */

            private int id;
            private int shopowner_id;
            private String name;
            private String description;
            private int price;
            private int quantity;
            private String dealer_name;
            private String dealer_phone;

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
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getDealer_name() {
                return dealer_name;
            }

            public void setDealer_name(String dealer_name) {
                this.dealer_name = dealer_name;
            }

            public String getDealer_phone() {
                return dealer_phone;
            }

            public void setDealer_phone(String dealer_phone) {
                this.dealer_phone = dealer_phone;
            }
        }
    }
}
