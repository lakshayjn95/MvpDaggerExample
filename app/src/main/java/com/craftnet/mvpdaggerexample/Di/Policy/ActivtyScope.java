package com.craftnet.mvpdaggerexample.Di.Policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by shaan on 7/25/2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivtyScope {
}
