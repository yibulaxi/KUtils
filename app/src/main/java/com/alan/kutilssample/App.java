package com.alan.kutilssample;

import android.app.Application;

import com.zwy.kutils.KUtilLibs;

/**
 * ================================================================
 * 创建时间：2017/7/27 上午9:42
 * 创建人：Alan
 * 文件描述：
 * 至尊宝：长夜漫漫无心睡眠，我以为只有我睡不着，原来晶晶姑娘你也睡不着 ！
 * ================================================================
 */
public class App extends Application {
    public final String TAG = "KUtilsSample";

    @Override
    public void onCreate() {
        super.onCreate();
        KUtilLibs.init(true, TAG, getApplicationContext());
    }
}
