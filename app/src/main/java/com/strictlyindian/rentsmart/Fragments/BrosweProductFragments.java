package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.strictlyindian.rentsmart.Activity.PlaidViewActivity;
import com.strictlyindian.rentsmart.Adapters.ComboAdapter;
import com.strictlyindian.rentsmart.Adapters.MainFragmentAdapter;
import com.strictlyindian.rentsmart.Adapters.ProductGridAdapter;
import com.strictlyindian.rentsmart.CustomUI.CustomGridView;
import com.strictlyindian.rentsmart.CustomUI.ElasticDragDismissFrameLayout;
import com.strictlyindian.rentsmart.CustomUI.InkPageIndicator;
import com.strictlyindian.rentsmart.CustomUI.ViewProductActivity;
import com.strictlyindian.rentsmart.MainActivity;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.StorageHelpers.CartHandler;
import com.strictlyindian.rentsmart.Transitions.DetailsTransition;
import com.strictlyindian.rentsmart.utils.BundleKey;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;
import static com.strictlyindian.rentsmart.R.id.shot;

/**
 * Created by nandhu on 20/4/17.
 * The Fragment Which is Shown in {@link MainActivity}
 * It is provided by {@link MainFragmentAdapter }
 */

public class BrosweProductFragments extends Fragment implements ComboAdapter.ComboInterface, ViewPager.OnPageChangeListener, ProductGridAdapter.GridCallback {


    private static final String TAG = "BOOKAHOLIC";
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
    private ElasticDragDismissFrameLayout.SystemChromeFader chromeFader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "BPFRAG Oncreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.browse_product_frag, container, false);

        ButterKnife.bind(this, view);





        return view;
    }

    void setResultAndFinish() {
        final Intent resultData = new Intent();

        getActivity().finishAfterTransition();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "BPFRAG onDestroy View");


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

            Log.d(TAG, "BPFRAG onResume: ");

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, " BPFRAG onActivityCreated: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        Log.d(TAG, " BPFRAG onAttach: ");
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

        Log.d(TAG, "BPFRAG onDestroy: ");
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
        Log.d(TAG, "onStart: ");


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
        Log.d(TAG, "BPFRAG onStop: ");
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

        //get Product Product p = // TODO: 20/5/17 Add Product String
//        b.putString(BundleKey.ARG_PRODUCT,);
        ImageView img = (ImageView) holder.findViewById(R.id.p_item_image);
        String trnasName = "pos"+pos;
        Log.d(TAG, "Transition Name in "+trnasName);
        Intent i = new Intent(getActivity(),ViewProductActivity.class);
        i.putExtra(BundleKey.TRANS_NAME,trnasName);
        Pair<View, String> p1 = Pair.create((View)img, trnasName);
        ActivityOptionsCompat options = makeSceneTransitionAnimation(getActivity(), p1);
        getParentFragment().getActivity().startActivity(i, options.toBundle());

    }


    /*Show Mini View lie Whatsapp*/
    @Override
    public void miniShow(View hold, int pid, int pos) {
        Log.d(TAG, "miniShow: ");
        ImageView img = (ImageView) hold.findViewById(R.id.p_item_image);
        String trnasName ="pos"+pos;
        Log.d(TAG, "Transition Name in " + trnasName);
        SwipableProductFragment mFragment = new SwipableProductFragment();
        Bundle b = new Bundle();
        b.putString(BundleKey.TRANS_NAME, trnasName);
        mFragment.setArguments(b);
        mFragment.setEnterTransition(new DetailsTransition());
        mFragment.setExitTransition(new DetailsTransition());
        mFragment.setSharedElementEnterTransition(new DetailsTransition());
        mFragment.setReenterTransition(new DetailsTransition());

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("mini")
                .addSharedElement(hold,trnasName)
                .replace(R.id.frag_holder_main,mFragment)
                .commit();

    }


    /*SHow Dribble hEre using Elastic Layout*/
    @Override
    public void dribbleShow(View holder, int pid, int post) {
        Log.d(TAG, "dribbleShow: ");
        ImageView img = (ImageView) holder.findViewById(R.id.p_item_image);
        String trnasName = "pos"+post;
        Log.d(TAG, "Transition Name in "+trnasName);
        Intent i = new Intent(getActivity(),PlaidViewActivity.class);
        i.putExtra(BundleKey.TRANS_NAME,trnasName);
        Pair<View, String> p1 = Pair.create((View)img, trnasName);
        ActivityOptionsCompat options = makeSceneTransitionAnimation(getActivity(), p1);
        getActivity().startActivity(i, options.toBundle());
    }
}
