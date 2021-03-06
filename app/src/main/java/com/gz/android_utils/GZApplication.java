package com.gz.android_utils;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.gz.android_utils.concurrency.loop.GZUILoop;

import java.lang.ref.WeakReference;

/**
 * created by Zhao Yue, at 19/9/16 - 10:39 AM
 * for further issue, please contact: zhaoy.samuel@gmail.com
 */
public class GZApplication extends Application {

    private Tracker mTracker;
    private static WeakReference<GZApplication> application;

    /*Provide const updates, customize this const further */
    public static String ApplicationName = "GZ-Android-Common";
    public static String ApplicationUserIdentifier = "GZ-Android-Default-ID";


    /*Shared singleton instance */
    public static GZApplication sharedInstance() {
        return GZApplication.application.get();
    }

    /*Provide default tracker */
    synchronized public Tracker getDefaultTracker() {

        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
            GoogleAnalytics.getInstance(this).setLocalDispatchPeriod(20);
        }

        return mTracker;
    }

    /*Provide configuration during initialization of application */
    @Override
    public void onCreate() {
        super.onCreate();
        GZUILoop.getInstance().init();
        GZApplication.application = new WeakReference<>(this);
    }
}

