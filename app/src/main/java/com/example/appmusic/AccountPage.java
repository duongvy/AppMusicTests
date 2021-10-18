package com.example.appmusic;

import static com.example.appmusic.api.ApiClient.getRetrofit;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appmusic.Adapter.SongAdapter;
import com.example.appmusic.api.Account.AccountResponse;
import com.example.appmusic.api.Favorite.FavoriteMethod;
import com.example.appmusic.api.Favorite.FavoriteResponse;
import com.example.appmusic.api.Login.User;
import com.example.appmusic.api.Login.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountPage extends AppCompatActivity {
    LinearLayout accountContentLayout;
    TextView txtUserName;
    TextView txtGmail;
    ImageView imgAvt;
    AccountResponse.CurrentUser account;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_account_page);

        accountContentLayout = findViewById(R.id.accountContent);
        imgAvt = findViewById(R.id.imgAvt);
        txtGmail = findViewById(R.id.txtGmail);
        txtUserName = findViewById(R.id.txtUsername);

        getAccount();
    }

    private void getAccount() {
        AccountResponse accountResponse = getRetrofit().create(AccountResponse.class);
        Call<AccountResponse> call = (Call<AccountResponse>) accountResponse.getData();
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if(response.isSuccessful())
                    account = response.body().getData().getCurrentUser();
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void combackToHome(View view) {
        Intent intent = new Intent(AccountPage.this, MainActivity.class);
        startActivity(intent);
    }
}
