package com.example.appmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appmusic.AccountPage;
import com.example.appmusic.api.Model.User;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

public class UserAdapter extends ArrayAdapter<User>{
    Activity context;
    int resource;

    public UserAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }
}
