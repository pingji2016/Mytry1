package com.example.root.mytry1.element;

/**
 * Created by Wim on 11/4/16.
 */
public class User extends BaseResponse {

    private UserData data;

    public User() {
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
