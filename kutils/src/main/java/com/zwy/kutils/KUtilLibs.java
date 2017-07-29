package com.zwy.kutils;

import android.content.Context;
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
    private static String TAG ="KUtilLibs";
    /**
     * 初始化库
     *
     * @param isDebug 是否打印日志
     * @param TAG     日志TAG
     * @param context application
     */
    public static void init(@NonNull boolean isDebug, @NonNull String TAG, @NonNull Context context) {
        android.util.Log.d(TAG,"看到这条消息表示KUtilsV2.1版本更新");
        if (TAG == null || context == null) throw new RuntimeException("KUtilLibs 初始化参数均不能为空");
        if (isDebug) Log.init(TAG, true);//开启日志打印
        DialogUIUtils.init(context);
    }
}
