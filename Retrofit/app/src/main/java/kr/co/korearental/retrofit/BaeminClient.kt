package kr.co.korearental.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaeminClient {
    private const val baseUrl = "https://ceo.baemin.com/cms/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(BaeminService::class.java)!!
    }

/*
만약 서버 호출이 필요할 때마다 인터페이스를 구현해야 한다면 너무 비효율적이기 때문에
Client 파일은 싱글톤(Object)으로 제작하는 것이 바람직하다.
 */

/*
우선 어떤 서버에 요청을 보낼 것인지 baseUrl() 메서드에 넘겨주어야 하는데
이때 주소의 끝은 항상 '/'로 끝나야 함을 유의해야 한다. https://ceo.baemin.com/cms/v1/


addConverterFactory()는 데이터를 파싱 할 converter를 추가하는 메서드이다.
JSON과 같은 데이터는 자바나 코틀린에서 바로 사용할 수 있는 데이터 형식이 아니기 때문에
이를 변환해주기 위해 이러한 converter를 사용해야 한다.
여기서 사용한 Gson은 구글에서 만든 라이브러리이다. 다른 컨버터를 원한다면 그걸 사용해도 되고, 여러 개를 추가할 수도 있다.

이렇게 해서 만들어진 Retrofit 객체를 이용해 Interface를 구현하면 된다.
 */