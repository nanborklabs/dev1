package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Adapters.ProfileAdapter;
import com.strictlyindian.rentsmart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * Created by nandhu on 21/4/17.
 * The Fragment Which Shows Profile Fragment
 */

public class ProfileFragment extends Fragment {





    //The Main Views
    @BindView(R.id.profile_collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.profile_tab)
    TabLayout mTabLayout;
    @BindView(R.id.profile_pager)
    ViewPager mPager;
    @BindView(R.id.profile_pager_holder)
    LinearLayout mPagerHolder;



    //The Views inside Collapsing Toolbar
    @BindView(R.id.profile_bg_image)
    ImageView mBackgroundImage;
    @BindView(R.id.profile_image)
    ImageView mProfileImage;
    @BindView(R.id.profile_name)
    TextView mName;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.profile_location)
    TextView mLocation;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.profile_phone_number)
    TextView mPhoneNumber;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.profile_frag, container, false);
        ButterKnife.bind(this, v);


        Picasso.with(mContext)
                .load(R.mipmap.pop)
                .into(mProfileImage);

        Picasso.with(mContext)
                .load(R.mipmap.fifaa)
                .transform(new BlurTransformation(mContext))
                .into(mBackgroundImage);

        setUpPager();


        return v;
    }

    private void setUpPager() {
        ProfileAdapter mAdapter = new ProfileAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
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
        if (mContext != null) {
            mContext = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
