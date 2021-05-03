package kr.co.korearental.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.co.korearental.data_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //binding 변수 생성
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = UserProfile("박","다수")
    }
}