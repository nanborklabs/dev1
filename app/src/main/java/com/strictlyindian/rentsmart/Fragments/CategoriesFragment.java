package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Adapters.CategoriesAdapter;
import com.strictlyindian.rentsmart.Model.BooksCategory;
import com.strictlyindian.rentsmart.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by nandhu on 21/4/17.
 * Show Animation Inside Here
 * The Categories should never Paginate
 */

public class CategoriesFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.search_text_view)
    SearchView mSearch;
    @BindView(R.id.cateogires_explores_text)
    TextView mExploresText;
    @BindView(R.id.general)
    ImageView mGeneral;
    @BindView(R.id.startups)
    ImageView mtechBooks;
    @BindView(R.id.exams)
    ImageView mExams;
    @BindView(R.id.top_categories)
    LinearLayout topCategories;
    @BindView(R.id.categories_list)
    RecyclerView mListView;
    @BindView(R.id.categories_reveal_view)
    FrameLayout mRevealView;
    private Context mContext;
    CategoriesAdapter mAdapter = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.categories_frag, container, false);
        ButterKnife.bind(this, v);

        Picasso.with(mContext).load(R.mipmap.fifa).transform(new CropCircleTransformation()).into(mGeneral);
        Picasso.with(mContext).load(R.mipmap.godofwar).transform(new CropCircleTransformation()).into(mtechBooks);
        Picasso.with(mContext).load(R.mipmap.master).transform(new CropCircleTransformation()).into(mExams);
        mGeneral.setOnClickListener(this);
        mExams.setOnClickListener(this);
        mtechBooks.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.exams:
                showExamView();
                break;
            case R.id.startups:
                showTechCategory();
                break;
            case R.id.general:
                showGeneralBooks();
                break;
            default:
                break;

        }
    }

    private void showGeneralBooks() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,"Thriller"));
        mGenList.add(new BooksCategory(1,"Life"));
        mGenList.add(new BooksCategory(1,"Biography"));
        mGenList.add(new BooksCategory(1,"History"));
        mGenList.add(new BooksCategory(1,"Science"));
        mGenList.add(new BooksCategory(1,"Maths"));
        mGenList.add(new BooksCategory(1,"Business"));
        mGenList.add(new BooksCategory(1,"Management"));

        setAdapterandReveal(mGenList);
    }

    private void setAdapterandReveal(List<BooksCategory> mList) {

        mAdapter = new CategoriesAdapter(mContext,mList);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        mListView.setLayoutManager(layoutManager);
        mListView.setAdapter(mAdapter);

    }

    private void showTechCategory() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,"Thriller"));
        mGenList.add(new BooksCategory(1,"Life"));
        mGenList.add(new BooksCategory(1,"Biography"));
        mGenList.add(new BooksCategory(1,"History"));
        mGenList.add(new BooksCategory(1,"Science"));
        mGenList.add(new BooksCategory(1,"Maths"));
        mGenList.add(new BooksCategory(1,"Business"));
        mGenList.add(new BooksCategory(1,"Management"));
        setAdapterandReveal(mGenList);
    }

    private void showExamView() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,"GRE"));
        mGenList.add(new BooksCategory(1,"GMAT"));
        mGenList.add(new BooksCategory(1,"ISCS"));
        mGenList.add(new BooksCategory(1,"KSC"));
        mGenList.add(new BooksCategory(1,"TNPSC"));
        setAdapterandReveal(mGenList);
    }
}
