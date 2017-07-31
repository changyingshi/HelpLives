package com.help.lives.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.lives.R;


/**
 * Created by Ying on 2017/7/25.
 */

public class HomePageFragment extends Fragment
{
    private View mHomepageView;

    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mHomepageView = inflater.inflate(R.layout.fragment_homepage, container, false);
        return mHomepageView;
    }

}
