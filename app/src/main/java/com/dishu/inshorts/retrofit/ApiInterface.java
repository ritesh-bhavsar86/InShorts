package com.dishu.inshorts.retrofit;

import com.dishu.inshorts.models.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dishu on 9/11/2017.
 */

public interface ApiInterface {
    @GET("newsjson")
    Call<List<News>> getAllNews();
}
