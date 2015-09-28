package com.ronnie.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by Administrator on 2015/9/28.
 * 基类
 */
public class BaseActivity extends Activity{

    private long lastEventTime;
    private static int TIME_TO_WAIT= 3 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void toHideKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    // Object 替换成需要替换的页面
    @Override
    public void onBackPressed() {
        if (this instanceof Object) {
            long currentEventTime = System.currentTimeMillis();
            if ((currentEventTime - lastEventTime) > TIME_TO_WAIT) {
                Toast.makeText(this, "在按一次退出程序", Toast.LENGTH_LONG).show();
                lastEventTime = currentEventTime;
                return;
            } else {
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                Runtime.getRuntime().gc();
            }
        } else {
            super.onBackPressed();
            finish();
        }
    }

}
