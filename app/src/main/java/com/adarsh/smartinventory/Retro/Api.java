package com.adarsh.smartinventory.Retro;

import com.adarsh.smartinventory.Model.AddCustomerResponseModel;
import com.adarsh.smartinventory.Model.AddEmployeeResponse;
import com.adarsh.smartinventory.Model.ShopLoginResponse;
import com.adarsh.smartinventory.Model.ShopRegResponse;
import com.adarsh.smartinventory.Model.ShopRegistrationRequest;
import com.adarsh.smartinventory.Model.StaffLogin;
import com.adarsh.smartinventory.Model.ViewCustomerModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("accounts/shopreg/")
    Call<ShopRegResponse>SHOP_REG_RESPONSE_CALL(@Body RequestBody requestBody);
    @GET("accounts/shoplogin/?")
    Call<ShopLoginResponse>SHOP_LOGIN_RESPONSE_CALL(@Query("email")String email,@Query("password")String password);

    @POST("shop/empreg/")
    Call<AddEmployeeResponse>ADD_EMPLOYEE_RESPONSE_CALL(@Body RequestBody requestbody);

    @GET("shop/emplogin/?")
    Call<StaffLogin>STAFF_LOGIN_CALL(@Query("employee_code")String email,@Query("password")String password);

    @POST("employee/customerreg/")
    Call<AddCustomerResponseModel>ADD_CUSTOMER_RESPONSE_MODEL_CALL(@Body RequestBody requestBody);

    @GET("employee/CustomerDetails/?emp_id=1")
    Call<ViewCustomerModel>VIEW_CUSTOMER_MODEL_CALL(@Query("emp_id")int emp_id);
}
