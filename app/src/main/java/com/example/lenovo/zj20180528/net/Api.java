package com.example.lenovo.zj20180528.net;

import com.example.lenovo.zj20180528.bean.BaseBean;

import io.reactivex.Observable;

public class Api {
    private static Api api;
    private ApiService apiService;

    public Api(ApiService apiService) {
        this.apiService = apiService;
    }
    public static Api getApi(ApiService apiService){
        if (api==null) {
            api=new Api(apiService);
        }
        return api;
    }
    public Observable<BaseBean> getData(int num){
        return apiService.getData(num);
    }
}
