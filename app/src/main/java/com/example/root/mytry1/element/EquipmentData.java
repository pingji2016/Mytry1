package com.example.root.mytry1.element;

import android.util.Log;

import java.util.LinkedList;

/**
 * Created by root on 19-4-9.
 */

public class EquipmentData {
    //private String equipmentid;
    //private String simulationid;
    //private LinkedList<String> ;

    private String simulation_name;
    private String simulation_create_time;
    private String simulation_update_time;
    private String simulation_create_user_id;
    private String simulation_update_user_id;

    public  EquipmentData(org.json.JSONObject myjObject){
        try {
            simulation_name=myjObject.getString("simulation_name");
            simulation_create_time=myjObject.getString("simulation_create_time");
            simulation_update_time=myjObject.getString("simulation_update_time");

            simulation_update_user_id=myjObject.getString("simulation_update_user_id");
            simulation_create_user_id=myjObject.getString("simulation_create_user_id");

        }
        catch (Exception e) {
            Log.d("lihui", "114e---" + e.getMessage());
        }
    }
    public String getSimulation_name() {
        return simulation_name;
    }

    public void setSimulation_name(String simulation_name) {
        this.simulation_name = simulation_name;
    }

    public String getSimulation_create_time() {
        return simulation_create_time;
    }

    public void setSimulation_create_time(String simulation_create_time) {
        this.simulation_create_time = simulation_create_time;
    }

    public String getSimulation_update_time() {
        return simulation_update_time;
    }

    public void setSimulation_update_time(String simulation_update_time) {
        this.simulation_update_time = simulation_update_time;
    }

    public String getSimulation_create_user_id() {
        return simulation_create_user_id;
    }

    public void setSimulation_create_user_id(String simulation_create_user_id) {
        this.simulation_create_user_id = simulation_create_user_id;
    }

    public String getSimulation_update_user_id() {
        return simulation_update_user_id;
    }

    public void setSimulation_update_user_id(String simulation_update_user_id) {
        this.simulation_update_user_id = simulation_update_user_id;
    }

    public EquipmentData(){
    }

}
