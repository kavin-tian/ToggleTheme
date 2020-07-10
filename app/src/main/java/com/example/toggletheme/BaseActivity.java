package com.example.toggletheme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 更新主题皮肤基类
 */
public class BaseActivity extends AppCompatActivity {

    public static final int DAY_THEME = 0; //白天模式
    public static final int NIGTH_THEME = 1;  //夜间模式
    private static final String THEME_KEY = "theme_key";
    private static final String THEME_FILE_NAME = "theme_file_name";
    public static int theme = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setMyTheme();
        super.onCreate(savedInstanceState);
    }

    public void setMyTheme() {
        if (theme == -1) { //刚启动时
            theme = getLocalTheme();
        }
        if (theme == DAY_THEME) {
            setTheme(R.style.MarioTheme_Day);
            setLocalTheme(DAY_THEME);
        } else if (theme == NIGTH_THEME) {
            setTheme(R.style.MarioTheme_Night);
            setLocalTheme(NIGTH_THEME);
        }
    }

    /* 该方法可能重复开启多个Actvity实例,
     *  使用launchMode="singleTop"启动,防止重复启动Actvity
     */
    public void updateTheme(int theme) {
        if (getLocalTheme() != theme) {
            BaseActivity.theme = theme;
            restartActivity();
        }
    }

    public int getLocalTheme() {
        SharedPreferences sp = getSharedPreferences(THEME_FILE_NAME, Context.MODE_PRIVATE);
        int currentTheme = sp.getInt(THEME_KEY, 0);
        return currentTheme;
    }

    public void setLocalTheme(int theme) {
        SharedPreferences sp = getSharedPreferences(THEME_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(THEME_KEY, theme).apply();
    }

    public void restartActivity() {
        finish();
        Intent intent = new Intent(this, this.getClass());
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
