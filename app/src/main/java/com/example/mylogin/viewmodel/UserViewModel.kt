package com.example.mylogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylogin.models.RegisterRequest
import com.example.mylogin.models.RegisterResponse
import com.example.mylogin.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    val userRepository = UserRepository()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            regLiveData.postValue(response.body())
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}