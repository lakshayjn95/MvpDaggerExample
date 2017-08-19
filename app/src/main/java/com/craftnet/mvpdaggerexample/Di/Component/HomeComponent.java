package com.craftnet.mvpdaggerexample.Di.Component;

import com.craftnet.mvpdaggerexample.Activity.MainActivity;
import com.craftnet.mvpdaggerexample.Di.Module.HomeModule;
import com.craftnet.mvpdaggerexample.Di.Policy.ActivtyScope;

import dagger.Subcomponent;

/**
 * Created by shaan on 8/19/2017.
 */
@ActivtyScope
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {

    void inject(MainActivity activity);

}
