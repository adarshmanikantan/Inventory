package com.adarsh.smartinventory.Retro;

import com.adarsh.smartinventory.Model.AddCustomerResponseModel;
import com.adarsh.smartinventory.Model.AddEmployeeResponse;
import com.adarsh.smartinventory.Model.AddProductResponseModel;
import com.adarsh.smartinventory.Model.CustomerLoginModel;
import com.adarsh.smartinventory.Model.InvoiceResponseModel;
import com.adarsh.smartinventory.Model.QrResponseModel;
import com.adarsh.smartinventory.Model.ShopLoginResponse;
import com.adarsh.smartinventory.Model.ShopRegResponse;
import com.adarsh.smartinventory.Model.StaffLogin;
import com.adarsh.smartinventory.Model.ViewCustomerModel;
import com.adarsh.smartinventory.Model.ViewInvoiceByCustomerModel;
import com.adarsh.smartinventory.Model.ViewInvoiceByStaffModel;
import com.adarsh.smartinventory.Model.ViewProductsModel;
import com.adarsh.smartinventory.Model.ViewQrModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("accshop/shopreg/")
    Call<ShopRegResponse>SHOP_REG_RESPONSE_CALL(@Body RequestBody requestBody);
    @GET("accshop/shoplogin/?")
    Call<ShopLoginResponse>SHOP_LOGIN_RESPONSE_CALL(@Query("email")String email,@Query("password")String password);

    @POST("shopowner/empreg/")
    Call<AddEmployeeResponse>ADD_EMPLOYEE_RESPONSE_CALL(@Body RequestBody requestbody);

    @GET("shopowner/emplogin/?")
    Call<StaffLogin>STAFF_LOGIN_CALL(@Query("employee_code")String email,@Query("password")String password);

    @POST("employee/customerreg/")
    Call<AddCustomerResponseModel>ADD_CUSTOMER_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("employee/CustomerDetails/?emp_id=1")
    Call<ViewCustomerModel>VIEW_CUSTOMER_MODEL_CALL(@Query("emp_id")int emp_id);

    @POST("employee/invoice/")
    Call<InvoiceResponseModel>INVOICE_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("employee/empinvoice/?")
    Call<ViewInvoiceByStaffModel>VIEW_INVOICE_BY_STAFF_MODEL_CALL(@Query("emp_id")int emp_id);

    @GET("employee/customerlog/?")
    Call<CustomerLoginModel>CUSTOMER_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);

    @POST("shopowner/addproduct/")
    Call<AddProductResponseModel>ADD_PRODUCT_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("shopowner/productdetails/?")
    Call<ViewProductsModel>VIEW_PRODUCTS_MODEL_CALL(@Query("shop_id")int shop_id);

    @GET("employee/custinvoice/?")
    Call<ViewInvoiceByCustomerModel>VIEW_INVOICE_BY_CUSTOMER_MODEL_CALL(@Query("customer_code")String cust_code);

    @POST("qrcode/qrcode/")
    Call<QrResponseModel>QR_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("qrcode/customer/?")
    Call<ViewQrModel>VIEW_QR_MODEL_CALL(@Query("customer_code")String cust_code);
}
