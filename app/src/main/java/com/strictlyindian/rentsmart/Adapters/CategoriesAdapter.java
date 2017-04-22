package com.strictlyindian.rentsmart.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Model.BooksCategory;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by nandhu on 23/4/17.
 * The Adapter which is used in {@link com.strictlyindian.rentsmart.Fragments.CategoriesFragment}
 *
 *
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {


    private Context mContext;
    private List<BooksCategory> mList;
    private static final int PHOTO_ANIMATION_DELAY = 600;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();



    private final int cellSize;



    private boolean lockedAnimations = false;
    private int lastAnimatedItem = -1;

    public CategoriesAdapter(Context mContext, List<BooksCategory> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.cellSize = ScreenUtil.getScreenWidth(mContext) / 3;
    }

    @Override
    public CategoriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.categories_item,parent,false);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) v.getLayoutParams();
        layoutParams.height = cellSize;
        layoutParams.width = cellSize;
        layoutParams.setFullSpan(false);
        v.setLayoutParams(layoutParams);
        return new CategoriesHolder(v);
    }

    @Override
    public void onBindViewHolder(final CategoriesHolder holder, int position) {
        Picasso.with(mContext)
                .load(R.mipmap.nfs)
                .transform(new CropCircleTransformation())
                .into(holder.mCategoryPhoto, new Callback() {
                    @Override
                    public void onSuccess() {
                        animatePhoto(holder);
                    }

                    @Override
                    public void onError() {

                    }
                });

    }

    private void animatePhoto(CategoriesHolder viewHolder) {
        if (!lockedAnimations) {
            if (lastAnimatedItem == viewHolder.getAdapterPosition()) {
                setLockedAnimations(true);
            }

            long animationDelay = PHOTO_ANIMATION_DELAY + viewHolder.getPosition() * 30;

            viewHolder.mRoot.setScaleY(0);
            viewHolder.mRoot.setScaleX(0);

            viewHolder.mRoot.animate()
                    .scaleY(1)
                    .scaleX(1)
                    .setDuration(200)
                    .setInterpolator(INTERPOLATOR)
                    .setStartDelay(animationDelay)
                    .start();
        }
    }



    public void setLockedAnimations(boolean lockedAnimations) {
        this.lockedAnimations = lockedAnimations;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class CategoriesHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.category_item_root)
        FrameLayout mRoot;
        public @BindView(R.id.cat_item_photo)
        ImageView mCategoryPhoto;

        public CategoriesHolder(View itemView) {
                super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    interface categoriesCallback{
        void categoryClicked(CategoriesHolder mHolder , BooksCategory mCategory);
    }
}
