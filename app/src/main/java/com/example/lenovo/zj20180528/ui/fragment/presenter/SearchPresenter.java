package com.example.lenovo.zj20180528.ui.fragment.presenter;

import com.example.lenovo.zj20180528.bean.BaseBean;
import com.example.lenovo.zj20180528.net.Api;
import com.example.lenovo.zj20180528.ui.base.BasePresenter;
import com.example.lenovo.zj20180528.ui.fragment.contract.SearchContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter extends BasePresenter<SearchContract.View> implements SearchContract.Presenter {
    private Api api;
    @Inject
    public SearchPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getData(int num) {
        api.getData(num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        mView.onSuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
