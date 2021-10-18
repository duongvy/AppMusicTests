package com.example.appmusic;

import static com.example.appmusic.api.ApiClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appmusic.Adapter.SongAdapter;
import com.example.appmusic.api.Favorite.FavoriteMethod;
import com.example.appmusic.api.Favorite.FavoriteResponse;
import com.example.appmusic.api.Model.Favorite;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritePage extends AppCompatActivity{

    private ListView lvFavoriteSong;
    LinearLayout FavoriteContentLayout;
    SongAdapter songAdapter;
    Button btnFavorite;
    Favorite favorite;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_favorite_page);

        songAdapter = new SongAdapter(FavoritePage.this, R.layout.activity_song_item);
        FavoriteContentLayout = findViewById(R.id.FavoriteContent);
        lvFavoriteSong = findViewById(R.id.lvFavoriteSong);
        lvFavoriteSong.setAdapter(songAdapter);

        getSongInFavorite();
        lvFavoriteSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(FavoritePage.this, MainActivity.class);
                intent.putExtra("idFavoriteSong", songAdapter.getItem(position).get_id());
                startActivity(intent);
            }
        });
    }

    private void getSongInFavorite() {
        FavoriteMethod method = getRetrofit().create(FavoriteMethod.class);
        Call<FavoriteResponse> call = method.getSongInFavorite();
        call.enqueue(new Callback<FavoriteResponse>() {
            @Override
            public void onResponse(Call<FavoriteResponse> call, Response<FavoriteResponse> response) {
                if(response.isSuccessful()){
                    favorite = response.body().getData().get("favorite");
                    if(favorite.getSongs().size() > 0)
                    songAdapter.addAll(favorite.getSongs());
                }
            }

            @Override
            public void onFailure(Call<FavoriteResponse> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
    public void combackToHome(View view) {
        Intent intent = new Intent(FavoritePage.this, MainActivity.class);
        startActivity(intent);
    }
}
