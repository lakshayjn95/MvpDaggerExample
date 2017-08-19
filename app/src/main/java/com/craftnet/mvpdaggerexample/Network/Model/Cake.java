
package com.craftnet.mvpdaggerexample.Network.Model;

import com.google.gson.annotations.SerializedName;

public class Cake {

    @SerializedName("BakeryName")
    private String mBakeryName;
    @SerializedName("CakeCode")
    private String mCakeCode;
    @SerializedName("CakeId")
    private int mCakeId;
    @SerializedName("CakeName")
    private String mCakeName;
    @SerializedName("Images")
    private String mImages;
    @SerializedName("MRP")
    private String mMRP;
    @SerializedName("Rate")
    private String mRate;
    @SerializedName("RefBakeryId")
    private String mRefBakeryId;
    @SerializedName("RefCityId")
    private String mRefCityId;
    @SerializedName("URL")
    private String mURL;
    @SerializedName("visMRP")
    private int mVisMRP;
    @SerializedName("visRate")
    private int mVisRate;
    @SerializedName("_Description")
    private String m_Description;

    public String getBakeryName() {
        return mBakeryName;
    }

    public void setBakeryName(String BakeryName) {
        mBakeryName = BakeryName;
    }

    public String getCakeCode() {
        return mCakeCode;
    }

    public void setCakeCode(String CakeCode) {
        mCakeCode = CakeCode;
    }

    public int getCakeId() {
        return mCakeId;
    }

    public void setCakeId(int CakeId) {
        mCakeId = CakeId;
    }

    public String getCakeName() {
        return mCakeName;
    }

    public void setCakeName(String CakeName) {
        mCakeName = CakeName;
    }

    public String getImages() {
        return mImages;
    }

    public void setImages(String Images) {
        mImages = Images;
    }

    public String getMRP() {
        return mMRP;
    }

    public void setMRP(String MRP) {
        mMRP = MRP;
    }


    public String getRate() {
        return mRate;
    }

    public void setRate(String Rate) {
        mRate = Rate;
    }

    public String getRefBakeryId() {
        return mRefBakeryId;
    }

    public void setRefBakeryId(String RefBakeryId) {
        mRefBakeryId = RefBakeryId;
    }

    public String getRefCityId() {
        return mRefCityId;
    }

    public void setRefCityId(String RefCityId) {
        mRefCityId = RefCityId;
    }

    public String getURL() {
        return mURL;
    }

    public void setURL(String URL) {
        mURL = URL;
    }

    public int getVisMRP() {
        return mVisMRP;
    }

    public void setVisMRP(int visMRP) {
        mVisMRP = visMRP;
    }

    public int getVisRate() {
        return mVisRate;
    }

    public void setVisRate(int visRate) {
        mVisRate = visRate;
    }

    public String get_Description() {
        return m_Description;
    }

    public void set_Description(String _Description) {
        m_Description = _Description;
    }

}
