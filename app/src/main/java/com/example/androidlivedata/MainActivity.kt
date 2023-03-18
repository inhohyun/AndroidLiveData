package com.example.androidlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

//LiveData? : LifeCycle과 결합해서 데이터를 관찰해줄 수 있는 친구
class MainActivity : AppCompatActivity() {

    private var testMutableLiveData = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //버튼을 클린하면 LiveData의 값이 증가하도록
        findViewById<Button>(R.id.btnArea).setOnClickListener {
            testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
        }

        //LiveData의 값이 어떻게 관찰되는지 보기기
       testMutableLiveData.observe(this, Observer{
            Log.d(" testMutableLiveData", testMutableLiveData.value.toString())
        })



    }
}