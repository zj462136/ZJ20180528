package com.example.lenovo.zj20180528.component;

import com.example.lenovo.zj20180528.module.HttpModule;
import com.example.lenovo.zj20180528.ui.fragment.FragmentSearch;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(FragmentSearch fragmentSearch);
}
