package com.tandong.kotlin.net

import com.tandong.kotlin.entity.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by office on 2018/1/17.
 */
interface ApiService {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<User>>

    @GET("users/{user}/repos")
    fun getUserList(@Path("user") user: String): Observable<List<User>>
}