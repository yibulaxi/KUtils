README
===========================
封装android开发中常用的Utils。可直接依赖使用，喜欢的话不妨star一下吧。
****
### Author:赵文贇
### E-mail:dev_zwy@aliyun.com
****
```diff
- V2.1:将增加GreenDao使用代码。
- V2.2:将增加万能recycleView适配器的使用代码。别忘了项目根目录下的依赖库导入
- V2.3:将增加OkGo使用代码。
- V2.4:将增加部分常用自定义View。
```
## 目录
* [日志输出](#日志输出)
* [引导页集成](#引导页集成)
* [对话框进度条封装](#对话框进度条封装)
* [Activity基类封装](#Activity基类封装)
* [集成该库](#集成该库)


## 日志输出
-----------
- [x] 优雅的日志输出
- [x] 突破系统日志打印长度的限制
- [x] 自动校验Json串输出格式
- [x] 打印异常输出位置（精确到行）
- [x] 日志一目了然  

### 使用
#### 1.在application中初始化操作（注意：在使用库之前必须在application中执行如下代码。不初始化直接调用Log输出日志会有空指针异常抛出）

```xml
      @Override
        public void onCreate() {
            super.onCreate();
            KUtilLibs.init(true, TAG, getApplicationContext());
        }
```

#### 2.调用和系统Log调用一样 
```xml
  private String json = "{\"key_a\":999,\"key_b\":\"这是b的值\"}";
  private String text = "这是一条测试日志";
      Log.d(json);
      Log.e(json);
      Log.w(json);  
      Log.d(text);
      Log.e(text);
      Log.w(text);
```
#### 效果图  
 ![log](https://github.com/devzwy/KUtils/raw/master/images/loginfo.png)  
## 引导页集成
-----------
- [x] 引导界面导航效果
- [x] 支持根据服务端返回的数据动态设置广告条的总页数
- [x] 支持大于等于1页时的无限循环自动轮播、手指按下暂停轮播、抬起手指开始轮播
- [x] 支持自定义指示器位置和广告文案位置
- [x] 支持图片指示器和数字指示器
- [x] 支持 ViewPager 各种切换动画
- [x] 支持选中特定页面
- [x] 支持监听 item 点击事件
- [x] 加载网络数据时支持占位图设置，避免出现整个广告条空白的情况
- [x] 多个 ViewPager 跟随滚动

### 使用

#### 1.在布局文件中添加 BGABanner

```xml
<com.zwy.kutils.widget.guide.BGABanner
    android:id="@+id/banner_guide_content"
    style="@style/MatchMatch"
    app:banner_pageChangeDuration="1000"
    app:banner_pointAutoPlayAble="false"
    app:banner_pointContainerBackground="@android:color/transparent"
    app:banner_pointDrawable="@drawable/bga_banner_selector_point_hollow"
    app:banner_pointTopBottomMargin="15dp"
    app:banner_transitionEffect="alpha" />
```

#### 2.在 Activity 或者 Fragment 中配置 BGABanner 的数据源

有多种配置数据源的方式，这里仅列出三种方式。

>配置数据源的方式1：通过传入数据模型并结合 Adapter 的方式配置数据源。这种方式主要用于加载网络图片，以及实现少于3页时的无限轮播

```java
mContentBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
        Glide.with(MainActivity.this)
                .load(model)
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .centerCrop()
                .dontAnimate()
                .into(itemView);
    }
});

mContentBanner.setData(Arrays.asList("网络图片路径1", "网络图片路径2", "网络图片路径3"), Arrays.asList("提示文字1", "提示文字2", "提示文字3"));
```

> 配置数据源的方式2：通过直接传入视图集合的方式配置数据源，主要用于自定义引导页每个页面布局的情况

```java
List<View> views = new ArrayList<>();
views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guide_1));
views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guide_2));
views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guide_3));
mContentBanner.setData(views);
```

> 配置数据源的方式3：通过传入图片资源 id 的方式配置数据源，主要用于引导页每一页都是只显示图片的情况

```
mContentBanner.setData(R.drawable.uoko_guide_foreground_1, R.drawable.uoko_guide_foreground_2, R.drawable.uoko_guide_foreground_3);
```

#### 3.监听广告 item 的单击事件，在 BGABanner 里已经帮开发者处理了防止重复点击事件

```java
mContentBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
        Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
    }
});
```

#### 4.设置「进入按钮」和「跳过按钮」控件资源 id 及其点击事件，如果进入按钮和跳过按钮有一个不存在的话就传 0，在 BGABanner 里已经帮开发者处理了防止重复点击事件，在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏

```java
mContentBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
    @Override
    public void onClickEnterOrSkip() {
        startActivity(new Intent(GuideActivity.this, MainActivity.class));
        finish();
    }
});
```

### 自定义属性说明
```xml
<declare-styleable name="BGABanner">
    <!-- 指示点容器背景 -->
    <attr name="banner_pointContainerBackground" format="reference|color" />
    <!-- 指示点背景 -->
    <attr name="banner_pointDrawable" format="reference" />
    <!-- 指示点容器左右内间距 -->
    <attr name="banner_pointContainerLeftRightPadding" format="dimension" />
    <!-- 指示点上下外间距 -->
    <attr name="banner_pointTopBottomMargin" format="dimension" />
    <!-- 指示点左右外间距 -->
    <attr name="banner_pointLeftRightMargin" format="dimension" />
    <!-- 指示器的位置 -->
    <attr name="banner_indicatorGravity">
        <flag name="top" value="0x30" />
        <flag name="bottom" value="0x50" />
        <flag name="left" value="0x03" />
        <flag name="right" value="0x05" />
        <flag name="center_horizontal" value="0x01" />
    </attr>
    <!-- 是否开启自动轮播 -->
    <attr name="banner_pointAutoPlayAble" format="boolean" />
    <!-- 自动轮播的时间间隔 -->
    <attr name="banner_pointAutoPlayInterval" format="integer" />
    <!-- 页码切换过程的时间长度 -->
    <attr name="banner_pageChangeDuration" format="integer" />
    <!-- 页面切换的动画效果 -->
    <attr name="banner_transitionEffect" format="enum">
        <enum name="defaultEffect" value="0" />
        <enum name="alpha" value="1" />
        <enum name="rotate" value="2" />
        <enum name="cube" value="3" />
        <enum name="flip" value="4" />
        <enum name="accordion" value="5" />
        <enum name="zoomFade" value="6" />
        <enum name="fade" value="7" />
        <enum name="zoomCenter" value="8" />
        <enum name="zoomStack" value="9" />
        <enum name="stack" value="10" />
        <enum name="depth" value="11" />
        <enum name="zoom" value="12" />
    </attr>
    <!-- 提示文案的文字颜色 -->
    <attr name="banner_tipTextColor" format="reference|color" />
    <!-- 提示文案的文字大小 -->
    <attr name="banner_tipTextSize" format="dimension" />
    <!-- 加载网络数据时覆盖在 BGABanner 最上层的占位图 -->
    <attr name="banner_placeholderDrawable" format="reference" />
    <!-- 是否是数字指示器 -->
    <attr name="banner_isNumberIndicator" format="boolean" />
    <!-- 数字指示器文字颜色 -->
    <attr name="banner_numberIndicatorTextColor" format="reference|color" />
    <!-- 数字指示器文字大小 -->
    <attr name="banner_numberIndicatorTextSize" format="dimension" />
    <!-- 数字指示器背景 -->
    <attr name="banner_numberIndicatorBackground" format="reference" />
    <!-- 当只有一页数据时是否显示指示器，默认值为 false -->
    <attr name="banner_isNeedShowIndicatorOnOnlyOnePage" format="boolean" />
    <!-- 自动轮播区域距离 BGABanner 底部的距离，用于使指示器区域与自动轮播区域不重叠 -->
    <attr name="banner_contentBottomMargin" format="dimension"/>
</declare-styleable>
```
#### 效果图  
![log](https://github.com/devzwy/KUtils/raw/master/images/guide.gif)  




## 对话框进度条封装
------------------
### 如下为简单示例 其他效果请自行拓展
#### 1. 展示进度条
```Java
 DialogUIUtils.showLoadingHorizontal(mContext, "请稍后……", true, false, true).show();
```
#### 效果图  
![log](https://github.com/devzwy/KUtils/raw/master/images/dialog_1.png)  
#### 2. 展示仿iOS对话框(中间)
```Java
 DialogUIUtils.showTwoButtonAlertDialog(mContext, "提示", "是否进入主页", "取消", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }, "进入", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    readyGoThenKill(MainActivity.class);
                }
            }, false);
```
#### 效果图  
![log](https://github.com/devzwy/KUtils/raw/master/images/dialog_2.png)  
#### 3. 展示仿iOS对话框(底部)
```Java
new ActionSheetDialog(mContext)
                    .builder()
                    .setCancelable(false)
                    .setCanceledOnTouchOutside(false)
                    .setTitle("提示")
                    .addSheetItem("删除", ActionSheetDialog.SheetItemColor.Red, new ActionSheetDialog.OnSheetItemClickListener() {
                        @Override
                        public void onClick(int which) {

                        }
                    })
                    .addSheetItem("进入", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                        @Override
                        public void onClick(int which) {
                            readyGoThenKill(MainActivity.class);
                        }
                    }).show();
```
#### 效果图  
![log](https://github.com/devzwy/KUtils/raw/master/images/dialog_3.png)  
## Activity基类封装
--------------------
### 使用请参考demo，请继承自BaseActivity自行拓展













## 集成该库
-----------

#### 1.jcenter仓库方式依赖
##### 项目根目录下的build.gradle加入
```Java
allprojects {
    repositories {
        jcenter()
        maven { url "https://dl.bintray.com/devzwy/maven" }
    }
}
```
##### 在APP的build.gradle dependencies节点下加入
```Java
compile 'com.zwy.kutils:kutils:2.0'
```
#### 2.clone项目到本地，将kutils库直接依赖到项目。
```Java
compile project(':kutils')
```
#### 3.aar方式依赖
##### 在项目根目录下新建aars文件夹，将kutils目录build/outputs下的kutils-release.aar文件copy进aars文件夹  在app的build.gradle 最外层节点加入
```xml
repositories { flatDir { dirs '../aars' } }
```
#####   在dependencies节点下加入对aar的依赖
```xml
compile(name: 'kutils-release', ext: 'aar') 
```
    
****
集成过程出现问题可联系本人QQ：3648415(注明来自github)
****
[点我回到顶部](#readme)