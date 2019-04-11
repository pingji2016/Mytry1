package com.example.root.mytry1.element;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by root on 19-4-9.
 */

public class Equipment extends BaseResponse {

    private EquipmentData data;
    private List<Dparameter> dp_data;
    private List<Parameter> p_data;//=new ArrayList<Parameter>()

    public List<Dparameter> getDp_data() {
        return dp_data;
    }

    public void setDp_data(List<Dparameter> dp_data) {
        this.dp_data = dp_data;
    }

    public List<Parameter> getP_data() {
        return p_data;
    }

    public void setP_data(List<Parameter> p_data) {
        this.p_data = p_data;
    }

    public Equipment() {
    }

    public EquipmentData getData() {
        return data;
    }

    public void setData(EquipmentData data) {
        this.data = data;
    }
}
