package com.example.androidlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

//LiveData? : LifeCycle과 결합해서 데이터를 관찰해줄 수 있는 친구
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //버튼을 클린하면 LiveData의 값이 증가하도록
        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        //LiveData의 값이 어떻게 관찰되는지 보기기
       viewModel.testMutableLiveData.observe(this, Observer{
            findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.toString()
        })



    }
}