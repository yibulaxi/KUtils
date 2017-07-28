package com.alan.kutilssample;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.zwy.kutils.utils.Log;
import com.zwy.kutils.widget.baseview.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.rv)
    RecyclerView mRv;
    private String json = "{\"key_a\":999,\"key_b\":\"这是b的值\"}";
    private String text = "这是一条测试日志";


    /**
     * 是否需要沉浸式状态栏 不需要时返回0 需要时返回颜色
     *
     * @return StatusBarTintModle(boolean isTranslucentStatus, int color);
     */
    @Override
    protected int isTranslucentStatus() {
        return R.color.trans;
    }

    /**
     * 设置布局ID
     *
     * @return 资源文件ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化View
     *
     * @param savedInstanceState aty销毁时保存的临时参数
     */
    @Override
    protected void initView(Bundle savedInstanceState) {
        Log.d(json);
        Log.e(json);
        Log.w(json);

        Log.d(text);
        Log.e(text);
        Log.w(text);
    }

    /**
     * 初始化数据源
     */
    @Override
    protected void initData() {
    }

    /**
     * Bundle  传递数据
     *
     * @param extras
     */
    @Override
    protected void getBundleExtras(Bundle extras) {

    }
}
