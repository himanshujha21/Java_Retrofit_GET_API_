package com.example.getretrofitapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

// The SerializedName annotation should always display the exact name of an object in the JSON file.

//serialization is converting object into json string and deserialization is converting json string into object.
//@Expose is used to allow or disallow serialization and deserialization.
public class AccountData implements Serializable {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List <AData> data;

    public AccountData(Integer status, String message, List <AData> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List <AData> getData() {
        return data;
    }

    public void setData(List <AData> data) {
        this.data = data;
    }
}
