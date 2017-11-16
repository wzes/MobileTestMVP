package com.wzes.vmovie.service;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {


    /**
     *
     * @param q
     * @param key
     * @return
     */
    @GET("bing/v7.0/news")
    Observable<ResponseBody> getResults(@Query("q") String q, @Header("Ocp-Apim-Subscription-Key") String key);
}
