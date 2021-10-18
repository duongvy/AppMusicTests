package com.example.appmusic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmusic.api.ApiClient;
import com.example.appmusic.api.Login.UserRequest;
import com.example.appmusic.api.Login.UserResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    ImageView  imgSignUp, forgotPassword;
    EditText email, password;
    Button btnLogin;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);

        forgotPassword = findViewById(R.id.imageViewForgotPassword);

        // Chuyển sang màn hình Forget Password
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doForgotPassword();
            }

            private void doForgotPassword() {
                Intent intent = new Intent(Login.this, RecoverPassword.class);
                startActivity(intent);
            }
        });

        imgSignUp = findViewById(R.id.imageViewDontAccount);

        // Chuyển sang màn hình Đăng ký
        imgSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSignUp();
            }

            private void doSignUp() {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        // Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(Login.this, "Email or Password required!", Toast.LENGTH_LONG).show();
                }else{
                    login();
                }
            }
        });
    }

    private void login() {

        UserRequest userRequest = new UserRequest();
        userRequest.setAccount(email.getText().toString());
        userRequest.setPassword(password.getText().toString());

        Call<UserResponse> userResponseCall = ApiClient.getUser().userLogin(userRequest);

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    UserResponse userResponse = response.body();
                    String token = userResponse.getData().getAccess_token();

                    // Tạo session cho user khi login thành công
                    SessionManager sessionManager = new SessionManager(Login.this);
                    sessionManager.createSession(token);

                    Toast.makeText(Login.this, "Login Successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Home.class).putExtra("data", token));
                }else{
                    try {
                        // Chuyển error thành đối tượng để lấy message lỗi
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Toast.makeText(Login.this, jsonObject.getJSONObject("error").getString("message"), Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Login Failed! "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}