package com.craftnet.mvpdaggerexample.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.craftnet.mvpdaggerexample.Adapter.AllCakesAdapter;
import com.craftnet.mvpdaggerexample.Di.Component.DaggerActivityComponent;
import com.craftnet.mvpdaggerexample.Di.Module.ActivityModule;
import com.craftnet.mvpdaggerexample.Di.Module.HomeModule;
import com.craftnet.mvpdaggerexample.Di.MyToast;
import com.craftnet.mvpdaggerexample.Network.Model.Cake;
import com.craftnet.mvpdaggerexample.Presentor.Mvp.HomeMVP;
import com.craftnet.mvpdaggerexample.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements HomeMVP.View {


    @Inject
    HomeMVP.Presentor presentor;
    @Inject
    MyToast toast;
    @Inject
    Context context;

    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.recycler)
    ShimmerRecyclerView recyclerView;

    @Override
    public void loadproducts(List<Cake> list) {
        AllCakesAdapter adapter = new AllCakesAdapter(list, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    public void initialize() {
        presentor.setView(this);
        recyclerView.showShimmerAdapter();
        presentor.initialize();
    }

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void dependency() {
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build().plus(new HomeModule()).inject(this);
    }

    @Override
    public void ondisconnected() {
        if (coordinatorLayout != null) {
            toast.message("No Internet Connection Available.").on(coordinatorLayout).snackbar().show("Settings", () -> {
                Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            });
        } else {
            toast.message("No Internet Connection").toast();
        }
    }

    @Override
    public void onconnected() {
        if (toast.snackbar != null && toast.snackbar.isShownOrQueued()) {
            toast.snackbar.dismiss();
        }
    }

    @Override
    public void showmessage(String message) {
        if (toast.snackbar != null && toast.snackbar.isShownOrQueued()) {
            toast.snackbar.dismiss();
        }
        toast.message(message).on(coordinatorLayout).snackbar().show();
    }
}
