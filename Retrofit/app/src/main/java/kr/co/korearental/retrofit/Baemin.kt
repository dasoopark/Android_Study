package kr.co.korearental.retrofit

import com.google.gson.annotations.SerializedName


/*
data class Baemin(val timestamp: Long, val statusCode: String, val statusMessage: String, val data: Data)

data class Data(val content: ArrayList<Content>)

data class Content(val contentId: Long, val contentSeq: Long, val title: String, val created: String)

JSON에 정해져 있는 대로
 */

// title과 created만 필요할 때는 이렇게 사용
data class Baemin(val data: Data)
data class Data(val content: ArrayList<Content>)
data class Content(
    /*
    @SerializedName은 Gson 라이브러리에서 제공하는 어노테이션인데
    여기서 Serialize는 data class 객체를 JSON 형태로 변환하는 것을 말한다.
    한국말로는 직렬화인데 영어나 한국말이나 드럽게 어렵네 😑
    아무튼 그래서 @SerializedName을 이용하면 'date'의 직렬화된 이름은 'created'입니다.라는 뜻이 되는 것이다.
    이렇게 표시해두면 GSON converter가 JSON을 받아와서 어노테이션을 보고 'created'값을 'date'에 매핑해준다.
     */
    @SerializedName("title")
    val title: String,
    @SerializedName("created")
    val date: String
)