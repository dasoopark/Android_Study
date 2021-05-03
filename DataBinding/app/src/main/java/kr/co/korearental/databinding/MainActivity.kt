package kr.co.korearental.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.co.korearental.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //데이터 매핑용 변수, gradle 해줘야함
    /*
        dataBinding {
        enabled true
    }
     */
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = UserProfile("박","다수") //클래스에 연결
    }
}