package kr.co.korearental.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.korearental.viewbinding.databinding.ActivityMainBinding

/*
gradle 추가해주어야 합니다.
android {
    ...
    viewBinding {
        enabled true
    }
}
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.viewText.text = "바꼈다!"
    }
}