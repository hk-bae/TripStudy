package com.hkbae.trip.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hkbae.trip.model.User
import com.hkbae.trip.repository.UserRepository
import kotlinx.coroutines.*
import java.lang.Exception

class UserViewModel : ViewModel() {

    var liveData :MutableLiveData<User> = MutableLiveData()
    var userRepository : UserRepository = UserRepository()

    fun login(id:String, pw:String){

        viewModelScope.launch {

            try {
                val response = CoroutineScope(Dispatchers.IO).async {
                    userRepository.getAllUsers()
                }.await()

                if(response.isSuccessful){
                    val userList : ArrayList<User> = response.body() as ArrayList<User>

                    userList.forEach { it ->
                        if (it.userid == id && it.userpw == pw) { //아이디 비밀번호가 일치하면 return
                            liveData.value = it
                            Log.d("login_retrofit", "if : ${it.userid} + ${it.userpw}")
                            return@forEach
                        }
                    }

                    liveData.value=User(idx=-1,userid = "",userpw = "",username = "")

                }else{
                    Log.d("login_retrofit","else :${response.code().toString()} ")
                }
            } catch (e: Exception) {
                Log.d("login_retrofit", "failiure : ${e.message}")
            }

        }

    }

}
