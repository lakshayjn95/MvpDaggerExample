package com.craftnet.mvpdaggerexample.Di;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.craftnet.mvpdaggerexample.Interface.Click;
import com.craftnet.mvpdaggerexample.R;


/**
 * Created by shaan on 7/7/2017.
 */

public class MyToast {


    Context context;
    String message;
    CoordinatorLayout coordinatorLayout;
    public Snackbar snackbar=null;

    public static MyToast with(Context context) {
        MyToast toast = new MyToast();
        toast.context = context;
        return toast;
    }

    public MyToast message(String message) {
        this.message = message;
        return this;
    }

    public MyToast on(CoordinatorLayout cd) {
        coordinatorLayout = cd;
        return this;
    }

    public Snackbar show(){
        snackbar.show();
        return snackbar;
    }

    public Snackbar show(String name, final Click click) {
        snackbar.setAction(name, v -> click.onclick());
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.show();
        return snackbar;
    }


    public void toast() {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) ((Activity) context).findViewById(R.id.root));
        TextView text = (TextView) layout.findViewById(R.id.message);
        text.setText(message);
        text.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/ssr.ttf"));
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public MyToast snackbar() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, R.color.toast));
        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/sssb.ttf"));
        this.snackbar = snackbar;
        return this;
    }

}
