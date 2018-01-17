package com.tandong.kotlin.net

import com.tandong.kotlin.base.Conf
import com.tandong.kotlin.entity.User
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by office on 2018/1/15.
 */
class ApiClient constructor() {
    private var apiservice: ApiService? = null;
    private var retrofit: Retrofit? = null;

    init {
        retrofit = Retrofit.Builder().baseUrl(Conf.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiservice = retrofit!!.create(ApiService::class.java)
    }

    fun getListRepo(id: String): Call<List<User>> {
        return apiservice!!.listRepos(id);
    }

    private fun <T> subscribeOnobserveOn(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }

    fun getListRepo(id: String, resultObserver: ResultObserver<List<User>>) {
        subscribeOnobserveOn(apiservice!!.getUserList(id), resultObserver)
    }

}