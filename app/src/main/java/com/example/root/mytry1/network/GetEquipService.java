package com.example.root.mytry1.network;

/**
 * Created by root on 19-4-9.
 */
import android.content.Context;

import com.example.root.mytry1.network.config.RetrofitBuilder;
import com.example.root.mytry1.network.interfaces.GetEquipInterface;

import okhttp3.ResponseBody;
import retrofit2.Callback;

public class GetEquipService {
    private GetEquipInterface getequipinterface;

    public GetEquipService(Context context) {
        getequipinterface = RetrofitBuilder.builder(context)
                .create(GetEquipInterface.class);
    }

    public void doget(String simulation, String equipment, Callback<ResponseBody> callback) {
        getequipinterface.doget(simulation,equipment).enqueue(callback);
    }

}
