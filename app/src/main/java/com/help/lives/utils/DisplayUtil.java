package com.help.lives.utils;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 *
 * Created by Ying on 2017/7/26.
 */

public class DisplayUtil
{
    // 根据手机的分辨率将dp的单位转成px(像素)
    public static int dip2px(Context context, float dpValue)
    {
        if (context != null)
        {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int)(dpValue * scale + 0.5f);
        }
        else
        {
            return 0;
        }
    }

    // 根据手机的分辨率将px(像素)的单位转成dp
    public static int px2dip(Context context, float pxValue)
    {
        if (context != null)
        {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int)(pxValue / scale + 0.5f);
        }
        else
        {
            return 0;
        }
    }

    // 将px值转换为sp值
    public static int px2sp(Context context, float pxValue)
    {
        if (context != null)
        {
            final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
            return (int) (pxValue / fontScale + 0.5f);
        }else
        {
            return 0;
        }
    }

    // 将sp值转换为px值
    public static int sp2px(Context context, float spValue)
    {
        if (context != null)
        {
            final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
            return (int) (spValue * fontScale + 0.5f);
        }
        else
        {
            return 0;
        }
    }

    private static WindowManager windowManager;

    private static WindowManager getWindowManager(Context context)
    {
        if (windowManager == null)
        {
            windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return windowManager;
    }

    // 屏幕宽度和高度（像素）
    public static String getScreenMetrics(Context context)
    {
        String an = "";
        if (context != null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            {
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager(context).getDefaultDisplay().getRealMetrics(metrics);
                an = metrics.widthPixels + "x" + metrics.heightPixels;
            }
        }
        return an;
    }
}
