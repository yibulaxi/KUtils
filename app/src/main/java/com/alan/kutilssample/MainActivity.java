package com.alan.kutilssample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zwy.kutils.utils.Log;

public class MainActivity extends AppCompatActivity {
    private String json = "{\"key_a\":999,\"key_b\":\"这是b的值\"}";
    private String text = "这是一条测试日志";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(json);
        Log.e(json);
        Log.w(json);

        Log.d(text);
        Log.e(text);
        Log.w(text);

    }
}
