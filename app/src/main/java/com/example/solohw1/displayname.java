package com.example.solohw1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class displayname extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayname);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
//
//        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
//        call.enqueue(new Callback<List<Userpost>>() {
//         @Override
//         public void onResponse(Call<List<Userpost>> call, Response<List<Userpost>> response) {
//             if(!response.isSuccessful()){
//                 //Toast.makeText(MainActivity.this, "Passed", Toast.LENGTH_SHORT).show();
//                 return;
//             }
//             List<Userpost> posts = response.body();
//             for(int x = 0; x < posts.size(); i++){
//                 String content = "";
//                 if(posts.get(x).getId() == id){
//                     content += "Body: " + posts.get(x).getBody() + "\n";
//                 }
//             }
//         }
//
//         }
        }


}

