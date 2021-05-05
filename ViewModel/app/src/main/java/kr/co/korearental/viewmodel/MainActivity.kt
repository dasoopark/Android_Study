package kr.co.korearental.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.co.korearental.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    depedency 추가 해줘야합니다.
    def lifecycle_version = "2.3.0"
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
     */

    /*
    ActivityMainBinding 을 사용하기 위해선 (데이터 바인딩)
    gradle에
     dataBinding {
        enabled = true
    }를 추가해줘야 합니다.
     */
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java) // 이거를
        binding.user = userViewModel

        /*
       val nameObserver = Observer<Int> { it ->
           binding.textViewHeight.text = it.toString()
       }
       userViewModel.height.observe(this, nameObserver)
       */

        // 위에 주석 달은 걸 줄이면 이거임.
        userViewModel.height.observe(this, Observer {
            binding.textViewHeight.text = it.toString()
        })
    }
}