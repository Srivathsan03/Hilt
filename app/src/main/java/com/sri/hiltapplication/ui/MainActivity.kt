package com.sri.hiltapplication.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sri.hiltapplication.R
import com.sri.hiltapplication.data.User
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
    val viewModel by viewModels<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLisitner()
        initData()
        initObservers()

    }

    private fun initLisitner() {

        addData.setOnClickListener {

            viewModel.insertData(User(
                userName="2",
                email = "AS@gmsil.com",
                location ="tt"

            ))

        }
        showData.setOnClickListener {

            viewModel.getAllUsers()
        }

    }

    private fun initData() {

    }

    private fun initObservers() {
        viewModel.userList.observe(this) {

            listData.text =""
            listData.text ="$it"



        }
    }
}