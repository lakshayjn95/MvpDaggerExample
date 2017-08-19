package com.craftnet.mvpdaggerexample.Di.Component;

import com.craftnet.mvpdaggerexample.Di.Module.ActivityModule;
import com.craftnet.mvpdaggerexample.Di.Module.HomeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shaan on 8/19/2017.
 */


@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    HomeComponent plus(HomeModule module);

}
