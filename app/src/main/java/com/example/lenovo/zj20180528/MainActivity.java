package com.example.lenovo.zj20180528;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.lenovo.zj20180528.ui.fragment.FragmentImage;
import com.example.lenovo.zj20180528.ui.fragment.FragmentSearch;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    private FragmentManager fragmentManager;
    private FragmentSearch fragmentSearch;
    private FragmentImage fragmentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        fragmentSearch = new FragmentSearch();
        fragmentImage = new FragmentImage();
        fragmentManager.beginTransaction().replace(R.id.fl, fragmentSearch).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        fragmentManager.beginTransaction().replace(R.id.fl, fragmentSearch).commit();
                        break;
                    case R.id.rb2:
                        fragmentManager.beginTransaction().replace(R.id.fl, fragmentImage).commit();
                        break;
                    case R.id.rb3:
                        break;
                }
            }
        });
    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}
