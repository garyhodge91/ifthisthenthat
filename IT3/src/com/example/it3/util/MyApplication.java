package com.example.it3.util;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application
{
    private static MyApplication instance = null;

    public MyApplication()
    {
        instance = this;
    }

    /**
     * Instanciates the class and initializes the variables
     *
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
    }

    /**
     * Creates a singleton of the current class
     *
     * @return Returns the app's context
     */
    public static Context getInstance()
    {
        if (instance == null) instance = new MyApplication();

        return instance;
    }
}
