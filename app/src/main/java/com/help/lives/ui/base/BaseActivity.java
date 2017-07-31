package com.help.lives.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.help.lives.R;

import javax.security.auth.login.LoginException;

import butterknife.ButterKnife;

/**
 * Created by Ying on 2017/7/25.
 */

public abstract class BaseActivity extends AppCompatActivity
{
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    public void setTextColor(TextView text, int color)
    {
        try
        {
            if (color != 0)
            {
                text.setTextColor(getResources().getColor(color));
            }
            else
            {
                text.setTextColor(getResources().getColor(R.color.tab_text_normal));
            }
        }
        catch (IllegalArgumentException e)
        {
            Log.e(TAG, "UnKnow color");
        }
    }
}
