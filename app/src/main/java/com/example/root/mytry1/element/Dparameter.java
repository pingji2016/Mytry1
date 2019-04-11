package com.example.root.mytry1.element;

import android.util.Log;

/**
 * Created by root on 19-4-9.
 */

public class Dparameter {
    private String Dparameter_name;
    private String Dparameter_unit;
    private String Dparameter_create_time;
    private String Dparameter_update_time;
    private String Dparameter_create_user_id;
    private String Dparameter_update_user_id;
    private String Dparameter_str_name;

    public  Dparameter(org.json.JSONObject myjObject){
        try {
            Dparameter_name=myjObject.getString("Dparameter_name");
            Dparameter_unit=myjObject.getString("Dparameter_unit");
            Dparameter_create_time=myjObject.getString("Dparameter_create_time");
            Dparameter_update_time=myjObject.getString("Dparameter_update_time");

            Dparameter_create_user_id=myjObject.getString("Dparameter_create_user_id");
            Dparameter_update_user_id=myjObject.getString("Dparameter_update_user_id");
            Dparameter_str_name=myjObject.getString("Dparameter_str_name");
        }
        catch (Exception e) {
            Log.d("lihui", "114e---" + e.getMessage());
        }
    }


    public void setDparameter_name(String dparameter_name) {
        Dparameter_name = dparameter_name;
    }

    public void setDparameter_unit(String dparameter_unit) {
        Dparameter_unit = dparameter_unit;
    }

    public void setDparameter_create_time(String dparameter_create_time) {
        Dparameter_create_time = dparameter_create_time;
    }

    public void setParameter_update_time(String parameter_update_time) {
        this.Dparameter_update_time = parameter_update_time;
    }

    public void setDparameter_create_user_id(String dparameter_create_user_id) {
        Dparameter_create_user_id = dparameter_create_user_id;
    }

    public void setDparameter_update_user_id(String dparameter_update_user_id) {
        Dparameter_update_user_id = dparameter_update_user_id;
    }

    public void setDparameter_str_name(String dparameter_str_name) {
        Dparameter_str_name = dparameter_str_name;
    }

    public String getDparameter_name() {
        return Dparameter_name;
    }

    public String getDparameter_unit() {
        return Dparameter_unit;
    }

    public String getDparameter_create_time() {
        return Dparameter_create_time;
    }

    public String getParameter_update_time() {
        return Dparameter_update_time;
    }

    public String getDparameter_create_user_id() {
        return Dparameter_create_user_id;
    }

    public String getDparameter_update_user_id() {
        return Dparameter_update_user_id;
    }

    public String getDparameter_str_name() {
        return Dparameter_str_name;
    }
}
