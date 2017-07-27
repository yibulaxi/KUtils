README
===========================
封装android开发中常用的Utils。可直接依赖使用，喜欢的话不妨star一下吧。
****
### Author:赵文贇
### E-mail:dev_zwy@aliyun.com
****
## 目录
 - [优雅的日志输出(突破系统日志打印长度的限制,自动校验Json串输出格式)](#Log打印)
























### Log打印
 ------
 在application中初始化操作（注意：不初始化直接调用Log输出日志会有空指针异常抛出）：
 ```
 Log.init(TAG, true);//开启日志打印
 ```
 调用和系统Log调用一样
 ```Java
  private String json = "{\"key_a\":999,\"key_b\":\"这是b的值\"}";
  private String text = "这是一条测试日志";
    Log.d(json);
    Log.e(json);
    Log.w(json);  
    Log.d(text);
    Log.e(text);
    Log.w(text);
 ```
 输出效果图  
 ![baidu](https://github.com/devzwy/KUtils/raw/master/images/loginfo.png)