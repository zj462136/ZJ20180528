package com.example.lenovo.zj20180528.net;

import com.example.lenovo.zj20180528.bean.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("mobile/?key=71e58b5b2f930eaf1f937407acde08fe")
    Observable<BaseBean> getData(@Query("num") int num);
}
