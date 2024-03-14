package com.mrhi2024.ex66retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

// 추상메소드만 가질 수 있는 abstract class
interface RetrofitService {

    //1. 단순하게 GET방식으로 json문자열을 읽어오는 코드를 만들어줘 라고 써놓은 것 [ 작성해준 코드를 가진 객체를 리턴해줌 ]
    @GET("/04Retrofit/board.json")
    fun getBoardJson() : Call<BoardItem>
    
    //2. 위 명세의 경로지정을 파라미터로 받아서 적용해주는 코드 만들어줘
    @GET("/{aaa}/{bbb}")
    fun getBoardJsonByPath(@Path("aaa") folder:String,@Path("bbb") filerName:String) : Call<BoardItem>

    //3. GET방식으로 값을 서버에 전달하는 코드 만들어줘 라는 명세서 만들기
    @GET("/04Retrofit/aaa.php")
    fun getMethodTest(@Query("name") name:String,@Query("msg") message:String) : Call<BoardItem>

    //4. GET방식으로 값을 한방에 Map collection 으로 전달하기
    @GET("/04Retrofit/aaa.php")
    fun getMethodTest2(@QueryMap data:Map<String, String>) : Call<BoardItem>

    //5. POST방식으로 값 전달 - 방법1. 객체를 통으로 전달 하면 자동으로 json문자열로 변환하여 서버로 전송함
    @POST("/04Retrofit/bbb.php")
    fun  postMethodTest(@Body item: BoardItem) : Call<BoardItem>

    //6. POST방식으로 값 전달 - 방법2. 개별 데이터 단위로 전달 마치 GET방식의 @Query 처럼
    // 단, @Field 를 사용하려면 반드시 추가 어노테이션이 필요
    @FormUrlEncoded
    @POST("/04Retrofit/ccc.php")
    fun postMethodTest(@Field("name") name:String,@Field("msg") message:String): Call<BoardItem>

    //7. GET방식으로 json array 값을 받아와서 곧바로 List<BoardItem>으로 응답해주는 코드만들어 줘
    @GET("/04Retrofit/boardArray.json")
    fun getBoardArray() : Call<List<BoardItem>>

    //8. 서버의 응답을 파싱하지 말고 그냥 글씨로 받기
    @GET("/04Retrofit/board.json")
    fun getBoardToString() : Call<String>


}