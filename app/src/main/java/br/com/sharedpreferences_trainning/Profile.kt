package br.com.sharedpreferences_trainning

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initProfile(configSharedPrefs())
    }

    private fun initProfile(prefs: SharedPreferences) {
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_registration = findViewById<TextView>(R.id.tv_registration)

        val user_name = prefs.getBoolean(MainActivity.USER_NAME, true)
        val user_registration = prefs.getBoolean(MainActivity.USER_REGISTRATION, true)

        tv_name.text = "Victor Ávila"
        tv_registration.text = "123456"

        tv_name.visibility = if (user_name) View.VISIBLE else View.GONE
        tv_registration.visibility = if (user_registration) View.VISIBLE else View.GONE
    }

    private fun configSharedPrefs() = getSharedPreferences(MainActivity.USER_PREFS, Context.MODE_PRIVATE)
}