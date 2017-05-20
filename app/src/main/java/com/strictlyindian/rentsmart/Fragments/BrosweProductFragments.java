package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.strictlyindian.rentsmart.Adapters.ComboAdapter;
import com.strictlyindian.rentsmart.Adapters.MainFragmentAdapter;
import com.strictlyindian.rentsmart.Adapters.ProductGridAdapter;
import com.strictlyindian.rentsmart.CustomUI.CustomGridView;
import com.strictlyindian.rentsmart.CustomUI.InkPageIndicator;
import com.strictlyindian.rentsmart.MainActivity;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.StorageHelpers.CartHandler;
import com.strictlyindian.rentsmart.utils.BundleKey;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 20/4/17.
 * The Fragment Which is Shown in {@link MainActivity}
 * It is provided by {@link MainFragmentAdapter }
 */

public class BrosweProductFragments extends Fragment implements ComboAdapter.ComboInterface, ViewPager.OnPageChangeListener, ProductGridAdapter.GridCallback {


    private static final String TAG = "BPFRAGMENT";
    @BindView(R.id.home_top_pager)
    ViewPager mComboPager;
    @BindView(R.id.indicator)
    InkPageIndicator mIndicator;
    @BindView(R.id.explore_text)
    TextView mExploreText;
    @BindView(R.id.home_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.home_grid)
    CustomGridView mGridView;
    private Context mContext;
    private int view_type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.browse_product_frag, container, false);

        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }

    @Override
    public void onResume() {
        super.onResume();
        ComboAdapter mAdapter = new ComboAdapter(CartHandler.getInstance(mContext).getMockProducts(), mContext, this);
        if (mComboPager != null) {

            mComboPager.setAdapter(mAdapter);
        }
        if (mIndicator != null && mComboPager != null && mComboPager.isShown()) {

            mIndicator.setViewPager(mComboPager);
        }

        if (mGridView != null && mGridView.isShown()){
            ProductGridAdapter mGAdapter = new ProductGridAdapter(mContext,CartHandler.getInstance(mContext).getMockProducts(),this);
            mGridView.setAdapter(mGAdapter);
            mGridView.setExpanded(true);



        }
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
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
        if (mComboPager != null) {
            mComboPager.removeOnPageChangeListener(this);
        }
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


        // Get What View Type This fragment must show?
       /* // View Types are
       *  0 - new Arrivals
       *  1 - popular
       *  2 - offers
       * */
        if (getArguments() != null) {
            view_type = getArguments().getInt(BundleKey.ARG_SHOW_PRODUCT);
        }
        pullData(view_type);
    }


    /*
    *This method is inserts the Json Key
    * and Downloads the Product Detail
    *
    *
    * */
    private void pullData(int view_type) {

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
    public void ComboproductClicked(Product p) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*Show Swipable View Pager here*/

    @Override
    public void productClicked(View holder, int pid, int pos) {
        SwipableProductFragment mFragment = new Swipa
        Log.d(TAG, "productClicked: ");
        getChildFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.findViewById(R.id.p_item_image), "pos")
                .replace(R.id.container, newFragment)
                .addToBackStack(null)
                .commit();
    }


    /*Show Mini View lie Whatsapp*/
    @Override
    public void miniShow(View hold, int pid, int pos) {
        Log.d(TAG, "miniShow: ");
    }


    /*SHow Dribble hEre using Elastic Layout*/
    @Override
    public void dribbleShow(View holder, int pid, int post) {
        Log.d(TAG, "dribbleShow: ");
    }
}
