package com.example.appmusic;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    // Khởi tạo các biến thư viện và biến môi trường context
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;

    private static final String IS_LOGIN = "isLogin";
    public static final String KEY_TOKEN = "TOKEN";

    // Khởi tạo và lưu session login vào SessionManager
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Tạo và lưu dữ liệu vào session
    public void createSession(String token){

        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_TOKEN, token);

        editor.apply();
    }

    // Lấy dữ liệu đã lưu trong createSession
    public HashMap<String, String> getUserData(){
        HashMap<String, String> userData = new HashMap<>();

        userData.put(KEY_TOKEN, sharedPreferences.getString(KEY_TOKEN, null));

        return userData;
    }

    // Kiểm tra login
    public boolean checkLogin(){

        if (sharedPreferences.getBoolean(IS_LOGIN, false)){
            return true;
        }else
            return false;
    }

    // Xóa session khi logout
    public void logout(){
        editor.clear();
        editor.commit();
    }


}
