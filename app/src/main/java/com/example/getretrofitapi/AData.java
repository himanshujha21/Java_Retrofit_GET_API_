package com.example.getretrofitapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//The SerializedName annotation should always display the exact name of an object in the JSON file.
//serialization is converting object into json string and deserialization is converting json string into object.
//@Expose is used to allow or disallow serialization and deserialization.

public class AData implements Serializable {
    @SerializedName("accountname")
    @Expose
    private String accountname;
    @SerializedName("accountNameTH")
    @Expose
    private String accountNameTH;

    @SerializedName("divisionValue")
    @Expose
    private String divisionValue;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("accountImage")
    @Expose
    private String accountImage;

    @SerializedName("address")
    @Expose
    private String address;

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountNameTH() {
        return accountNameTH;
    }

    public void setAccountNameTH(String accountNameTH) {
        this.accountNameTH = accountNameTH;
    }

    public String getDivisionValue() {
        return divisionValue;
    }

    public void setDivisionValue(String divisionValue) {
        this.divisionValue = divisionValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountImage() {
        return accountImage;
    }

    public void setAccountImage(String accountImage) {
        this.accountImage = accountImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
