package com.craftnet.mvpdaggerexample.Presentor.Model;

import com.craftnet.mvpdaggerexample.Di.SessionManager;
import com.craftnet.mvpdaggerexample.Network.OkRetro;
import com.craftnet.mvpdaggerexample.Network.Pojo.AllCakesResponse;
import com.craftnet.mvpdaggerexample.Presentor.Mvp.HomeMVP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shaan on 8/19/2017.
 */

public class HomeController implements HomeMVP.Model {


    OkRetro retro;
    SessionManager sessionManager;

    public HomeController(OkRetro retro, SessionManager sessionManager) {
        this.retro = retro;
        this.sessionManager = sessionManager;
    }

    @Override
    public void getCakes(HomeMVP.Interactor interactor) {

        retro.getCakes(String.valueOf(sessionManager.city())).enqueue(new Callback<AllCakesResponse>() {
            @Override
            public void onResponse(Call<AllCakesResponse> call, Response<AllCakesResponse> response) {
                if(response.isSuccessful()){
                    interactor.handle(response.body().getCakes());
                }else{
                    interactor.error("Custom Error Message");
                }
            }

            @Override
            public void onFailure(Call<AllCakesResponse> call, Throwable t) {

            }
        });

    }
}
