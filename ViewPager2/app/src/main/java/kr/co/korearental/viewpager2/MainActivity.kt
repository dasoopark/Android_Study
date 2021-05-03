package kr.co.korearental.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewPager를 사용하기 위해선 dependencies 추가해줘야합니다.

        viewPager_idol.adapter = ViewPagerAdapter(getIdolList()) // 어댑터 생성
        viewPager_idol.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
    }

    // 뷰 페이저에 들어갈 아이템
    private fun getIdolList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.idol1, R.drawable.idol2, R.drawable.idol3)
         }
    }
}