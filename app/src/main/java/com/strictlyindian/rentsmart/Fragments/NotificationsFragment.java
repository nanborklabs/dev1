package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strictlyindian.rentsmart.R;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 22/4/17.
 * The Fragment which Displays Notifications
 *
 * The Ntotifications are come from FCM and  are parsed and displayed here
 *
 */

public class NotificationsFragment extends android.support.v4.app.Fragment {

    private Context mContext;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.notification_fragment,container,false);
        ButterKnife.bind(this,view);



        //get THe Notofications here
        //if Empty , show Empty Vieew
        //else , recycelr view Id;





        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mContext != null){
            mContext = null;
        }
    }
}
