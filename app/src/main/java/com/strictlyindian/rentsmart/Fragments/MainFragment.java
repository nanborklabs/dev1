package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strictlyindian.rentsmart.Adapters.MainFragmentAdapter;
import com.strictlyindian.rentsmart.CustomUI.NavigationTabStrip;
import com.strictlyindian.rentsmart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 21/4/17.
 * The Main Fragment Which is Displayed
 * in {@link com.strictlyindian.rentsmart.MainActivity} with Home Tab Selected
 *
 *
 * This Fragment Contains NAvTabStrip and ViewPager
 *
 *
 */

public class MainFragment extends Fragment {


    private Context mContext;
    @BindView(R.id.nav_strip)
    NavigationTabStrip mTab;
    @BindView(R.id.main_pager)
    ViewPager mPager;


    MainFragmentAdapter mAdapter;


    String[] pageTitles = {"New Arrival's","What's Popular","Offers"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.main_frag,container,false);
        ButterKnife.bind(this,v);



        setUpPager();




        return v;
    }




    private void setUpPager() {
        mAdapter = new MainFragmentAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mTab.setTitles(pageTitles);

        mTab.setViewPager(mPager);



    }
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
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
            mContext = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
