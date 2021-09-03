package com.example.solohw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    List<Post> data;
    List<Userpost> userpostData;
    private TextView textViewResult;
    private int mainId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Passed", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post> posts = response.body();
                for(Post post: posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "Username: " + post.getUsername() + "\n";
                    content += "Password: " + "Password" + "\n";
                }
                data = posts;
                System.out.println(data.get(0).getUsername());
                //Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });

        final Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userName = (EditText) findViewById(R.id.userNameInput);
                String checkName = userName.getText().toString();
                password = (EditText)findViewById(R.id.userPassword);
                String checkPass = password.getText().toString();
                if(checkName(checkName)){

                    if(checkPass.equals("Password")){
                        userName.setVisibility(View.GONE);
                        password.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        //check passwords match

                        textViewResult = findViewById(R.id.text_view_result);

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("https://jsonplaceholder.typicode.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
                        Call<List<Userpost>> call = jsonPlaceHolderApi.getUserPost();
                        call.enqueue(new Callback<List<Userpost>>() {
                            @Override
                            public void onResponse(Call<List<Userpost>> call, Response<List<Userpost>> response) {
                                if (!response.isSuccessful()) {
                                    textViewResult.setText("Code: " + response.code());
                                    return;
                                }
                                List<Userpost> posts = response.body();
                                for(int i = 0; i < posts.size(); i++ ){
                                    if(posts.get(i).getId() == mainId){
                                        String content = "";;
                                        content += "User Post: " + posts.get(i).getBody() + "\n";
                                        textViewResult.append(content);
                                    }
                                }
                            }
                            @Override
                            public void onFailure(Call<List<Userpost>> call, Throwable t) {
                                textViewResult.setText(t.getMessage());
                            }
                            });
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        password.setBackgroundColor(Color.parseColor("#FFFF00"));
                        userName.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    }

                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect Username", Toast.LENGTH_SHORT).show();
                    userName.setBackgroundColor(Color.parseColor("#FFFF00"));
                    password.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }


            }
        });
    }

    boolean checkName(String userName){
        //System.out.println("UserName" + userName);
        for(int i = 0; i < data.size(); i++){
            if(userName.equals( data.get(i).getUsername()) ){
                mainId =  data.get(i).getId();
                return true;
            }
        }
        return false;
    }


}