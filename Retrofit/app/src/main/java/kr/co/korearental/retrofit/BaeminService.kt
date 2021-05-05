package kr.co.korearental.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaeminService {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page: String): Call<Baemin>
}

//@GET, @POST 이런 식으로 어떤 작업을 어노테이션을 붙여주면 된다.
/*
배민 공지사항 사이트에서 size와 같은 파라미터는 항상 고정되어 있는 값이다.
(항상 한 페이지에 10개의 게시물을 보여주니까!) 하지만 page처럼 값을 동적으로 변경해야 하는 파라미터는
@Query 어노테이션을 이용해서 메서드를 호출할 때 값을 넘겨받아 주소에 포함시켜야 한다.
 */

//마지막으로 Call<> 안에 응답받을 Body 타입의 data class를 적어주면 된다.
//만약 JSON이 아니라 HTML로 응답해주는 사이트라면 <ResponseBody> 이렇게 적어주면 된다.