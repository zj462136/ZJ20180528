package com.example.lenovo.zj20180528.ui.fragment.contract;

import com.example.lenovo.zj20180528.bean.BaseBean;
import com.example.lenovo.zj20180528.ui.base.BaseContract;

import java.util.List;

public interface SearchContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(BaseBean baseBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData(int num);
    }
}
