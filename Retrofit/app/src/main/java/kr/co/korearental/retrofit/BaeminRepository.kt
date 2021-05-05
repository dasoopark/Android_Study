package kr.co.korearental.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class BaeminRepository {
    fun loadBaeminNotice(page: Int, mCallback: MainActivity) {
        val call = BaeminClient.service.loadNotice(page.toString()) //싱글톤으로 제작한거 불러옴

        call.enqueue(object : Callback<Baemin> {    //enqueue 비동기 방식, execute:동기 방식
            override fun onResponse( // 통신에 성공한 경우
                call: Call<Baemin>,
                response: Response<Baemin>
            ) {
                if(response.isSuccessful()){ // 응답을 잘 받은 경우
                    mCallback.loadComplete(response.body()!!.data) //통신과 응답이 정상이면, response.body에 요청한 데이터가 있음
                    // 비동기실행이므로, Baemin안의 data를 LiveData나 콜백 함수 기능 등을 이용해 처리해야함
                } else {
                    // 통신은 성공했지만 응답에 문제가 있는 경우
                }
            }

            override fun onFailure(call: Call<Baemin>, t: Throwable) {
                // 통신에 실패한 경우
            }
        })
    }
}