
package com.craftnet.mvpdaggerexample.Network.Pojo;

import com.craftnet.mvpdaggerexample.Network.Model.Cake;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllCakesResponse {

    @SerializedName("cakes")
    private List<Cake> mCakes;

    public List<Cake> getCakes() {
        return mCakes;
    }

    public void setCakes(List<Cake> cakes) {
        mCakes = cakes;
    }

}
