package com.android.petopia.network;

import com.android.petopia.model.LoginData;
import com.android.petopia.model.PostLogin;
import com.android.petopia.model.PostRegister;
import com.android.petopia.model.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    String URL = "http://10.0.2.2:8080/api/v1/";

    @POST("users/register")
    Call<UserData> apiRegister(@Body PostRegister postRegister);

    @POST("users/login")
    Call<LoginData> apiLogin(@Body PostLogin postLogin);
}
