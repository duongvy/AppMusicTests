package com.example.appmusic;

import static com.example.appmusic.api.ApiClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appmusic.Adapter.SongAdapter;
import com.example.appmusic.Adapter.UserAdapter;
import com.example.appmusic.api.Album.AlbumMethods;
import com.example.appmusic.api.Album.AlbumResponse;
import com.example.appmusic.api.ApiClient;
import com.example.appmusic.api.Favorite.FavoriteResponse;
import com.example.appmusic.api.Model.Album;
import com.example.appmusic.api.Model.User;
import com.example.appmusic.api.User.GetMe;
import com.example.appmusic.api.User.GetMeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountPage extends AppCompatActivity {
    UserAdapter userAdapter;
    TextView txtName, txtGmail;
    ImageView imgAvt;
    Button btnBack;
    LinearLayout accountContentLayout;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_account_page);

        txtName = findViewById(R.id.txtName);
        txtGmail = findViewById(R.id.txtGmail);
        imgAvt = findViewById(R.id.imgAvt);
        btnBack = findViewById(R.id.btnBack);
        accountContentLayout = findViewById(R.id.accountContentLayout);
        userAdapter = new UserAdapter(AccountPage.this, R.layout.activity_account_page);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("_id");

        getUser(userID == null ? "6166e8fd024ac50fb1f4e5d6" : userID);
    }

    private void getUser(String s) {
        Call<GetMeResponse> getMe = ApiClient.getMe().getMe();
        getMe.enqueue(new Callback<GetMeResponse>() {
            @Override
            public void onResponse(Call<GetMeResponse> call, Response<GetMeResponse> response) {

            }

            @Override
            public void onFailure(Call<GetMeResponse> call, Throwable t) {

            }
        });
    }


}

