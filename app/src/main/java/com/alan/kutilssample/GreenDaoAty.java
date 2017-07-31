package com.alan.kutilssample;

import android.os.Bundle;

import com.zwy.kutils.widget.baseview.BaseActivity;

/**
 * ================================================================
 * 创建时间：2017/7/31 上午10:04
 * 创建人：Alan
 * 文件描述：GreenDao测试页面
 * 至尊宝：长夜漫漫无心睡眠，我以为只有我睡不着，原来晶晶姑娘你也睡不着 ！
 * ================================================================
 */
public class GreenDaoAty extends BaseActivity {
    /**
     * 是否需要沉浸式状态栏 不需要时返回0 需要时返回颜色
     *
     * @return StatusBarTintModle(boolean isTranslucentStatus, int color);
     */
    @Override
    protected int isTranslucentStatus() {
        return 0;
    }

    /**
     * 设置布局ID
     *
     * @return 资源文件ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.greendao;
    }

    /**
     * 初始化View
     *
     * @param savedInstanceState aty销毁时保存的临时参数
     */
    @Override
    protected void initView(Bundle savedInstanceState) {

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
