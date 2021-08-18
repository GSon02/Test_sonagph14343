package com.example.test_sonagph14343.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.test_sonagph14343.Fragment.HienThiFragment;
import com.example.test_sonagph14343.Fragment.ThemFragment;

public class PageTabAdapter extends FragmentStatePagerAdapter {


    public PageTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HienThiFragment();
            case 1:
                return new ThemFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Hiển thị";
            case 1:
                return "Thêm sách";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
