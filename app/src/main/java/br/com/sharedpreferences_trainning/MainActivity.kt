package br.com.sharedpreferences_trainning

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    companion object{
        const val USER_PREFS = "USER_PREFS"
        const val USER_NAME = "user_name"
        const val USER_REGISTRATION = "user_registration"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configSharedPrefs()
        sharedViews(configSharedPrefs())
    }

    private fun sharedViews(prefs: SharedPreferences?) {
        val switchName = findViewById<SwitchCompat>(R.id.switch_name)
        val switchRegistration = findViewById<SwitchCompat>(R.id.switch_registration)
        val buttonProfile = findViewById<Button>(R.id.bt_profile)

        switchName.setOnCheckedChangeListener { _, isChecked ->
                prefs?.edit()?.putBoolean(USER_NAME, isChecked)?.apply()
        }

        switchRegistration.setOnCheckedChangeListener { _, isChecked ->
            prefs?.edit()?.putBoolean(USER_REGISTRATION, isChecked)?.apply()
        }

        buttonProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }

    private fun configSharedPrefs() = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)

}