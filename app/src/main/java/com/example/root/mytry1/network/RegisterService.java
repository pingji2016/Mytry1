package com.example.root.mytry1.network;

import android.content.Context;

import com.example.root.mytry1.network.config.RetrofitBuilder;
import com.example.root.mytry1.network.interfaces.RegisterInterface;

import retrofit2.Callback;

/**
 * Created by Wim on 11/4/16.
 */
public class RegisterService {

    private RegisterInterface registerInterface;

    public RegisterService(Context context) {
        registerInterface = RetrofitBuilder.builder(context)
                .create(RegisterInterface.class);
    }

    public void doRegister(String firstname, String lastname, String email, String password, Callback callback) {
        registerInterface.register(firstname, lastname, email, password).enqueue(callback);
    }

}
