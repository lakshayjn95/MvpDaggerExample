package com.craftnet.mvpdaggerexample.Presentor.Mvp;

import com.craftnet.mvpdaggerexample.Network.Model.Cake;

import java.util.List;

import retrofit2.Response;

/**
 * Created by shaan on 8/19/2017.
 */

public interface HomeMVP {


    interface View{
        void showmessage(String message);
        void loadproducts(List<Cake>list);
    }

    interface Model{
        void getCakes(Interactor i);
    }

    interface Presentor{
        void setView(View v);
        void initialize();
    }

    interface Interactor{
        void handle(List<Cake> cakes);
        void error(String message);
    }

}
