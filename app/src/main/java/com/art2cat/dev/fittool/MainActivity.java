package com.art2cat.dev.fittool;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.fragment_container) == null) {
            fm.beginTransaction().add(R.id.fragment_container, new BMIFragment()).commit();
        }
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener((MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().replace(R.id.fragment_container, new BMIFragment()).commit();
                    mTextMessage.setText(R.string.title_bmi);
//                    mTextMessage.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().replace(R.id.fragment_container, new CalFragment()).commit();
//                    mTextMessage.setVisibility(View.GONE);
                    mTextMessage.setText(R.string.calorie_introduce);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            return false;
        });
    }

}
