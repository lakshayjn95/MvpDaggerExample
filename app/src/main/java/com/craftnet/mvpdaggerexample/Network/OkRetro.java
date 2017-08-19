package com.craftnet.mvpdaggerexample.Network;

import com.craftnet.mvpdaggerexample.Network.Pojo.AllCakesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shaan on 8/19/2017.
 */

public interface OkRetro {

    @GET("cake/{CityId}/get")
    Call<AllCakesResponse> getCakes(@Path("CityId")String CityId);
}
