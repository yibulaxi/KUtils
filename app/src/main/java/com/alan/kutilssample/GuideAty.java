package com.alan.kutilssample;

import android.content.Intent;
import android.os.Bundle;

import com.zwy.kutils.widget.baseview.BaseActivity;
import com.zwy.kutils.widget.guide.BGABanner;

import butterknife.Bind;

/**
 * ================================================================
 * 创建时间：2017/7/27 下午2:49
 * 创建人：Alan
 * 文件描述：引导页面
 * 至尊宝：长夜漫漫无心睡眠，我以为只有我睡不着，原来晶晶姑娘你也睡不着 ！
 * ================================================================
 */
public class GuideAty extends MyBaseActivity {
    @Bind(R.id.banner_guide_background)
    BGABanner mBannerGuideBackground;
    @Bind(R.id.banner_guide_foreground)
    BGABanner mBannerGuideForeground;

    /**
     * 是否需要沉浸式状态栏 不需要时返回null即可
     *
     * @return StatusBarTintModle(boolean isTranslucentStatus, int color);
     */
    @Override
    protected StatusBarTintModle isTranslucentStatus() {
//        return new StatusBarTintModle(true,R.color.trans );
        return null;
    }

    /**
     * 设置布局ID
     *
     * @return 资源文件ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.guideaty;
    }

    /**
     * 初始化View
     *
     * @param savedInstanceState aty销毁时保存的临时参数
     */
    @Override
    protected void initView(Bundle savedInstanceState) {
        initListener();
    }

    /**
     * 初始化数据源
     */
    @Override
    protected void initData() {
        setData();
    }

    /**
     * Bundle  传递数据
     *
     * @param extras
     */
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    private void initListener() {
        //将跳过按钮与进入按钮加入控制器设置点击事件
        mBannerGuideForeground.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                showToast("你好");
                startActivity(new Intent(GuideAty.this, MainActivity.class));
                finish();
            }
        });
    }

    private void setData() {
        //开启自动播放
//        mBannerGuideBackground.setAutoPlayAble(true);
//        mBannerGuideForeground.setAutoPlayAble(true);

        //设置背景图
        mBannerGuideBackground.setData(R.mipmap.uoko_guide_background_1, R.mipmap.uoko_guide_background_2, R.mipmap.uoko_guide_background_3);
        //设置背景图对应的文案
        mBannerGuideForeground.setData(R.mipmap.uoko_guide_foreground_1, R.mipmap.uoko_guide_foreground_2, R.mipmap.uoko_guide_foreground_3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBannerGuideBackground.setBackgroundResource(android.R.color.white);
    }

    /**
     * 自己进行相关逻辑拓展
     */
    @Override
    protected void test() {

    }
}
