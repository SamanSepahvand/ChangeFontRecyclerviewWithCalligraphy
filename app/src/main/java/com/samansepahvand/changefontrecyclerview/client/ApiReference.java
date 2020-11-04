package com.samansepahvand.changefontrecyclerview.client;

import android.graphics.Movie;

import com.samansepahvand.changefontrecyclerview.model.DataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiReference {

    @GET("posts")
    Call<ArrayList<DataModel>> getPosts();

}
