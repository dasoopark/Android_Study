package kr.co.korearental.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.korearental.retrofit.databinding.ActivityMainBinding


// 출처 1 기본 사용법 : https://todaycode.tistory.com/38?category=979455
// 출처 2 본격적인 서버 연동 : https://todaycode.tistory.com/41

/*
    // Retrofit
implementation 'com.squareup.retrofit2:retrofit:2.6.2'
implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
gradle 추가해줘야 합니다.

    // manifest
    <uses-permission android:name="android.permission.INTERNET"/>  - 서버 통신 인터넷 권한
    android:usesCleartextTraffic="true"> - https로 시작하는 사이트 접근
    추가해줘야 합니다.
 */

class MainActivity : AppCompatActivity(), CompletionListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noticeAdapter: NoticeAdapter
    private val baeminRepository = BaeminRepository()
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 리사이클러뷰 설정 가능 하게함 XML
        setContentView(binding.root)

        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }

        baeminRepository.loadBaeminNotice(page, this) // 첫 페이지

        binding.btnLoadNextPage.setOnClickListener {// 버튼을 누를 때 마다
            baeminRepository.loadBaeminNotice(++page, this) // 다음 페이지를 로드한다.
        }
    }

    // 성공적으로 로드한 경우
    override fun loadComplete(data: Data) {
        noticeAdapter.setList(data.content)
        noticeAdapter.notifyDataSetChanged()
    }

    // 응답에 문제가 있는 경우
    override fun responseIsNotSuccesful(code: Int) {
        Toast.makeText(this, "사이트가 응답하지 않습니다", Toast.LENGTH_SHORT).show()
        Log.v("로그", code.toString())
    }

    // 로드에 실패한 경우
    override fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT).show()
    }
}