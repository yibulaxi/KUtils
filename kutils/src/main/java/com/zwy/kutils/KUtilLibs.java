package com.zwy.kutils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.zwy.kutils.utils.Log;
import com.zwy.kutils.widget.loadingdialog.DialogUIUtils;

/**
 * ================================================================
 * 创建时间：2017/7/27 上午9:27
 * 创建人：Alan
 * 文件描述：基类
 * 至尊宝：长夜漫漫无心睡眠，我以为只有我睡不着，原来晶晶姑娘你也睡不着 ！
 * ================================================================
 */
public class KUtilLibs {
    private static String TAG_ = "KUtilLibs";
    private static KUtilLibs mKUtilLibs;
    private Context appContext;

    public static KUtilLibs getInstance() {
        return mKUtilLibs == null ? new KUtilLibs() : mKUtilLibs;
    }

    /**
     * 初始化库
     *
     * @param isDebug 是否打印日志
     * @param TAG     日志TAG
     * @param context application
     */
    public KUtilLibs init(@NonNull boolean isDebug, @NonNull String TAG, @NonNull Context context) {
        android.util.Log.d(TAG_, "==============您使用的KUtils版本:2.3==============");
        if (TAG == null || context == null) throw new RuntimeException("KUtilLibs 初始化参数均不能为空");
        this.appContext = context;
        if (isDebug) Log.init(TAG, true);//开启日志打印
        DialogUIUtils.init(appContext);
        return mKUtilLibs;
    }
}
