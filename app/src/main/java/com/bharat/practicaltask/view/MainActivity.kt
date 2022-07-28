package com.bharat.practicaltask.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bharat.practicaltask.MyApp
import com.bharat.practicaltask.R
import com.bharat.practicaltask.databinding.ActivityMainBinding
import com.bharat.practicaltask.view.fragments.HomeFragment
import com.bharat.practicaltask.viewModel.AppViewModelFactory
import com.bharat.practicaltask.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.app_blue)
        val colorDrawable = ColorDrawable(getColor(R.color.app_blue))

        supportActionBar?.title = getString(R.string.my_dashboard)
        supportActionBar?.setBackgroundDrawable(colorDrawable)
        MyApp.getComponent().inject(this)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.fragmentContainerViewMainPage,
                            HomeFragment.newInstance()
                        )
                        commit()
                    }
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.bottomNavigation.selectedItemId = R.id.home
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}