package com.sri.hiltapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sri.hiltapplication.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    fun insertData(user: User) {
        CoroutineScope(Dispatchers.Default).launch {
            repository.insert(user)
        }
    }

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList
    fun getAllUsers() {
        CoroutineScope(Dispatchers.Main).launch {
            _userList.value = repository.getAllUser()
        }
    }
}