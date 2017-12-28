package com.art2cat.dev.fittool


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

open class MainActivity : AppCompatActivity() {

    open var mTextMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager
        if (fm.findFragmentById(R.id.fragment_container) == null) {
            fm.beginTransaction().add(R.id.fragment_container, BMIFragment()).commit()
        }
        mTextMessage = findViewById<View>(R.id.message) as TextView?
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {

            }
        }
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    fm.beginTransaction().replace(R.id.fragment_container, BMIFragment()).commit()
                    mTextMessage?.setText(R.string.title_home)
                }
                R.id.navigation_dashboard -> {
                    fm.beginTransaction().replace(R.id.fragment_container, CalFragment()).commit()
                    mTextMessage?.setText(R.string.calorie_introduce)
                }
                R.id.navigation_notifications -> {
                    mTextMessage?.setText(R.string.title_notifications)
                }
            }
            false
        }
    }

}
