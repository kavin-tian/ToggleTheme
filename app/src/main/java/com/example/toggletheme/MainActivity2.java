package com.example.toggletheme;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * �ο�:https://www.jianshu.com/p/0cd03c878def
 *hahhahahhaha
 */
public class MainActivity2 extends BaseActivity {

    /*newBranch*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //����������������BaseActivity�� , �������������setContentView֮ǰ
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
