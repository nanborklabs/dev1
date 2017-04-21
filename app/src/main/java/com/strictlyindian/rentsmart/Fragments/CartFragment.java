package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.strictlyindian.rentsmart.R;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 21/4/17.
 * The Fragment Which Holds Cart Info's
 */

public class CartFragment extends Fragment {


    private static final String TAG = "CART_FRAG";
    private Context mContext = null;
    View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v = LayoutInflater.from(mContext).inflate(R.layout.cart_layout,container,false);
        ButterKnife.bind(this,v);



        return v;
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

        //If Products Present in Cart Show , it
        //// TODO: 21/4/17  Hit Analytics here

        if (isProductsPresent()){
           // Products are Present
            //Inflate View
        }
        else{
            //No Products Present
            if (v.isShown() && v.isAttachedToWindow() && v != null){
                try {
                    FrameLayout v1 = (FrameLayout) v.findViewById(R.id.cart_root_frame);
                    v1.removeAllViews();
                    View NoData = View.inflate(mContext,R.layout.no_product_in_cart,v1);

                }
                catch (Exception e){
                    Log.d(TAG, "onStart: exception in Infalting View");
                }
            }

        }
    }

    private boolean isProductsPresent() {
        return false;
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
}
