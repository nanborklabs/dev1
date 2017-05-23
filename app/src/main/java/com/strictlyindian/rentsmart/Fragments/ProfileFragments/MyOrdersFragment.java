package com.strictlyindian.rentsmart.Fragments.ProfileFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.strictlyindian.rentsmart.Adapters.ProfileAdapter;
import com.strictlyindian.rentsmart.Fragments.ProfileFragment;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 23/5/17.
 * The Fragment used in {@link ProfileFragment}
 * <p>
 * provided by {@link ProfileAdapter}
 */

public class MyOrdersFragment extends Fragment {
    private static final String TAG = "BOOKAHOLIC";



    //The Root Layouts & Indicator Views

    @BindView(R.id.orders_loading_indicator)
    ProgressBar mProgressIndicator;
    @BindView(R.id.indicator_text)
    TextView mIndicatorText;
    @BindView(R.id.order_frame)
    FrameLayout mIndicatorFrame;
    @BindView(R.id.order_root_frame)
    FrameLayout mRootFrame;




    /*These View are used Only if No Order Layout is Inflated*/
    //No order Pager
    @Nullable @BindView(R.id.no_order_image)
    ImageView mNoOrderImage;
    @Nullable  @BindView(R.id.no_order_text)
    TextView mNoOrderText;
    @Nullable @BindView(R.id.no_orders_loading_indicator)
    ProgressBar mNoOrdersLoadingIndicator;
    @Nullable @BindView(R.id.no_orderindicator_text)
    TextView mNoOrderindicatorText;
    @Nullable @BindView(R.id.no_order_loading_frame)
    RelativeLayout mNoOrderLoadingFrame;
    @Nullable @BindView(R.id.no_orders_root_frame)
    FrameLayout mNoOrdersRootFrame;
    private Context mContext;


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

        //Infalting Views
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_orders, container, false);
        ButterKnife.bind(this, view);


        //FIrst Hit the Webservices get Any orders
        // Before that check that oRders are presnet in Local;
        //If No ORders Present call No Previos orders

        return view;
    }


    public void showNoOrders() {
        try {
            mRootFrame.removeAllViews();
            View noOrders = View.inflate(mContext, R.layout.no_ordrers, mRootFrame);
            ButterKnife.bind(this, noOrders);
//            ImageView cart = (ImageView) noOrders.findViewById(R.id.no_order_image);
//            TextView mNoOrderText = noOrders.findViewById(R.id.);
//            FrameLayout mLoadingIndicatorFrame;
//            ProgressBar mNoOrderindicator ;
//            TextView noOrderIndicatorText;
//            RelativeLayout mIndicatorHOlder;

             AnimateNoOrderPager();
//

        }
        catch (Exception e ){
            Log.d(TAG, "Exception in showNoOrders: ");
        }
    }

    private void AnimateNoOrderPager() {
        mNoOrderImage.setTranslationY(ScreenUtil.getScreenHeight(mContext));
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
