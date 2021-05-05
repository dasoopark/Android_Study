package kr.co.korearental.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 보통 LivaData와 같이 쓰임, height=> 화면에 보일 데이터
class UserViewModel : ViewModel(){
    private var _height = MutableLiveData<Int>()

    val height: LiveData<Int>
        get() = _height

    init{
        _height.value = 170
    }

    fun increase(){
        _height.value =_height.value?.plus(1)
    }
}