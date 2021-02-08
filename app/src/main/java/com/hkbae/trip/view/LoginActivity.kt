package com.hkbae.trip.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hkbae.trip.R
import com.hkbae.trip.databinding.ActivityLoginBinding
import com.hkbae.trip.model.User
import com.hkbae.trip.viewModel.UserViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        val view =binding.root
        setContentView(view)

        initView()
        setObserver()

    }


    fun initView(){

        setSupportActionBar(binding.loginToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false) //기존 타이틀 제거
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun setObserver(){
        userViewModel.liveData.observe(this, Observer<User> {

            if(it.idx!=-1) {

                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, TripActivity::class.java)
                startActivity(intent)
                //유저 아이디,비밀번호를 sharedPreference에 저장

                val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                editor.apply {
                    putString("userid", it.userid)
                    putString("userpw", it.userpw)
                    putString("username", it.username)
                    putInt("idx", it.idx)
                }
                finish()
            }else{
                Toast.makeText(this@LoginActivity,"ID 또는 Password가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickConfirm(view: View) {

        val inputId :String = binding.inputId.text.toString().trim()
        val inputPw :String = binding.inputPw.text.toString().trim()

        if(inputId.isNotEmpty() && inputPw.isNotEmpty()){
            userViewModel.login(inputId,inputPw)
        }else{
            Toast.makeText(this@LoginActivity,"ID 또는 Password 입력을 확인해 주세요.",Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickFindPw(view: View) {
        val intent = Intent(this@LoginActivity, FindPwActivity::class.java)
        startActivity(intent)
    }
}