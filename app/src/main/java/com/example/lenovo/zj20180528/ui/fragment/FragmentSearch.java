package com.example.lenovo.zj20180528.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lenovo.zj20180528.R;
import com.example.lenovo.zj20180528.bean.BaseBean;
import com.example.lenovo.zj20180528.component.DaggerHttpComponent;
import com.example.lenovo.zj20180528.ui.base.BaseFragment;
import com.example.lenovo.zj20180528.ui.fragment.adapter.MyAdapter;
import com.example.lenovo.zj20180528.ui.fragment.contract.SearchContract;
import com.example.lenovo.zj20180528.ui.fragment.presenter.SearchPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends BaseFragment<SearchPresenter> implements SearchContract.View {

    private View view;
    private RecyclerView rv;
    private int num=10;
    private MyAdapter adapter;
    private SmartRefreshLayout smart_refresh;
    @Override
    public int getContentLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        rv= view.findViewById(R.id.rv);
        smart_refresh = view.findViewById(R.id.smart_refresh);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mPresenter.getData(num);
        smart_refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getData(num);
                smart_refresh.finishLoadmore(2000);
            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                num++;
                mPresenter.getData(num);
                smart_refresh.finishRefresh(2000);
            }
        });
    }


    @Override
    public void onSuccess(BaseBean baseBean) {
        List<BaseBean.NewslistBean> newslist = baseBean.getNewslist();
        adapter = new MyAdapter(getActivity(), newslist);
        rv.setAdapter(adapter);
    }
}
