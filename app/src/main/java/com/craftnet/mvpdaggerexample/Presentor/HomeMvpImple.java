package com.craftnet.mvpdaggerexample.Presentor;

import com.craftnet.mvpdaggerexample.Network.Model.Cake;
import com.craftnet.mvpdaggerexample.Network.Pojo.AllCakesResponse;
import com.craftnet.mvpdaggerexample.Presentor.Mvp.HomeMVP;

import java.util.List;

import retrofit2.Response;

/**
 * Created by shaan on 8/19/2017.
 */

public class HomeMvpImple implements HomeMVP.Presentor,HomeMVP.Interactor {


    HomeMVP.Model model;
    HomeMVP.View view;

    public HomeMvpImple(HomeMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(HomeMVP.View v) {
        this.view=v;
    }

    @Override
    public void handle(List<Cake> response) {
        view.loadproducts(response);
    }

    @Override
    public void error(String message) {
        view.showmessage(message);
    }

    @Override
    public void initialize() {
        model.getCakes(this);
    }
}
