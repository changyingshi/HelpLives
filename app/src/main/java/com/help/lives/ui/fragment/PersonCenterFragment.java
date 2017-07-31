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

public class PersonCenterFragment extends Fragment
{
    private View mPersonView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPersonView = inflater.inflate(R.layout.fragment_person, container, false);
        return mPersonView;
    }
}
