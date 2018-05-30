package com.example.lenovo.zj20180528.module;

import com.example.lenovo.zj20180528.net.Api;
import com.example.lenovo.zj20180528.net.ApiService;
import com.example.lenovo.zj20180528.net.Contracts;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }
    @Provides
    Api provideApi(OkHttpClient.Builder builder) {
        ApiService apiService = new Retrofit.Builder()
                .baseUrl(Contracts.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
                .create(ApiService.class);
        return Api.getApi(apiService);
    }
}
