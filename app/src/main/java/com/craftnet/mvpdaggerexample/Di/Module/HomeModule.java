package com.craftnet.mvpdaggerexample.Di.Module;

import com.craftnet.mvpdaggerexample.Di.Policy.ActivtyScope;
import com.craftnet.mvpdaggerexample.Di.SessionManager;
import com.craftnet.mvpdaggerexample.Network.OkRetro;
import com.craftnet.mvpdaggerexample.Presentor.HomeMvpImple;
import com.craftnet.mvpdaggerexample.Presentor.Model.HomeController;
import com.craftnet.mvpdaggerexample.Presentor.Mvp.HomeMVP;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shaan on 8/19/2017.
 */

@Module
public class HomeModule {


    @ActivtyScope
    @Provides
    public HomeMVP.Model model(SessionManager sessionManager, OkRetro retro) {
        return new HomeController(retro, sessionManager);
    }

    @ActivtyScope
    @Provides
    public HomeMVP.Presentor presentor(HomeMVP.Model model) {
        return new HomeMvpImple(model);
    }

}
