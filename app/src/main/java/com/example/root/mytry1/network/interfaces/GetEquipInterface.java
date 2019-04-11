package com.example.root.mytry1.network.interfaces;

import com.example.root.mytry1.element.Equipment;
import com.example.root.mytry1.element.User;
import com.example.root.mytry1.network.config.Config;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Wim on 11/3/16.
 */
public interface GetEquipInterface {

    @FormUrlEncoded
    @POST(Config.Get_Equipment)
    Call<ResponseBody> doget(
            @Field("simulation") String simulation,
            @Field("equipment") String equipment);

}
