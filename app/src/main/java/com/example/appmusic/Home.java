package com.example.appmusic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    TextView username;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.textView);


        // Lấy dữ liệu đã lưu vào session ra
        sessionManager = new SessionManager(this);

        HashMap<String, String> userData = sessionManager.getUserData();

        String token = userData.get(SessionManager.KEY_TOKEN);

        username.setText("Welcome " + token);
    }
}