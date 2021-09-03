package com.example.solohw1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("users")
    Call<List<Post>> getPosts();

    @GET("posts")
    Call<List<Userpost>> getUserPost();
}


