package com.example.root.mytry1;

/**
 * Created by root on 19-3-31.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import  java.util.*;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.example.root.mytry1.BlankFragment;
import com.example.root.mytry1.R;
import com.example.root.mytry1.SignActivity;

import static android.util.Log.*;

public class Change_act extends AppCompatActivity {

    private static final String TAG = "Change_act";

    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_button);
        initView();
    }

    private void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, BlankFragment.newInstance("今日"));
        mFragmentSparseArray.append(R.id.record_tab, BlankFragment.newInstance("记录"));
        mFragmentSparseArray.append(R.id.contact_tab, BlankFragment.newInstance("报告"));
        mFragmentSparseArray.append(R.id.settings_tab, BlankFragment.newInstance("设置"));
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        mFragmentSparseArray.get(checkedId)).commit();
            }
        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(new View.OnClickListener() {
            //Log("fdsdg","Change_act");



            @Override
            public void onClick(View v) {
                startActivity(new Intent(Change_act.this, CaptureActivity.class));
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(Change_act.this, FeedbackActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


}