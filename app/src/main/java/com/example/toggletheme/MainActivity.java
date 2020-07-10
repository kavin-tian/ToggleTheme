package com.example.toggletheme;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * 参考:https://www.jianshu.com/p/0cd03c878def
 *
 * 注意事项: 必须引用需要的主题才能使用该主题的属性, 在该主题下赋值的自定义属性才能使用
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //建议把设置主题放在BaseActivity里 , 设置主题必须在setContentView之前
        setContentView(R.layout.activity_main);

        Switch toggle = findViewById(R.id.toggle);
        toggle.setChecked(getLocalTheme() == NIGTH_THEME);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    updateTheme(NIGTH_THEME);
                } else {
                    updateTheme(DAY_THEME);
                }
            }
        });
    }

}
