package com.example.root.mytry1.element;

import android.util.Log;

/**
 * Created by root on 19-4-9.
 */

public class Parameter {
    private String parameter_name;
    private String parameter_create_time;
    private String parameter_update_time;

    private String parameter_create_user_id;
    private String parameter_update_user_id;


    public  Parameter(org.json.JSONObject myjObject){
        try {
            parameter_name=myjObject.getString("parameter_name");
            parameter_create_time=myjObject.getString("parameter_create_time");
            parameter_update_time=myjObject.getString("parameter_update_time");

            parameter_create_user_id=myjObject.getString("parameter_create_user_id");
            parameter_update_user_id=myjObject.getString("parameter_update_user_id");

        }
        catch (Exception e) {
            Log.d("lihui", "114e---" + e.getMessage());
        }
    }
    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public void setParameter_create_time(String parameter_create_time) {
        this.parameter_create_time = parameter_create_time;
    }

    public void setGetParameter_update_time(String getParameter_update_time) {
        this.parameter_update_time = getParameter_update_time;
    }

    public void setParameter_create_user_id(String parameter_create_user_id) {
        this.parameter_create_user_id = parameter_create_user_id;
    }

    public void setParameter_update_user_id(String parameter_update_user_id) {
        this.parameter_update_user_id = parameter_update_user_id;
    }

    public String getParameter_create_time() {
        return parameter_create_time;
    }

    public String getGetParameter_update_time() {
        return parameter_update_time;
    }

    public String getParameter_create_user_id() {
        return parameter_create_user_id;
    }

    public String getParameter_update_user_id() {
        return parameter_update_user_id;
    }
}
