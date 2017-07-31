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

public class KnowledgeFragment extends Fragment
{
    private View mKnowledgeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mKnowledgeView = inflater.inflate(R.layout.fragment_knowledge, container, false);
        return mKnowledgeView;
    }
}
