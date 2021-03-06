package com.gz.android_utils.ui.popup;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * created by Zhao Yue, at 25/9/16 - 10:01 PM
 * for further issue, please contact: zhaoy.samuel@gmail.com
 */
public class GZPopup extends DialogFragment {

    public static GZPopup show(int layoutRes, Activity activity, String tag) {
        GZPopup popup = new GZPopup();
        popup.layoutRes =layoutRes;
        popup.show(activity.getFragmentManager(),"tag");
        /**show the activity*/

        return popup;
    }

    public static GZPopup show(View view, Activity activity, String tag) {
        GZPopup popup = new GZPopup();
        popup.view = view;
        popup.show(activity.getFragmentManager(),"tag");
        /**show the activity*/

        return popup;
    }

    protected int layoutRes;
    protected View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView( view==null?inflater.inflate(layoutRes, null):view)
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}