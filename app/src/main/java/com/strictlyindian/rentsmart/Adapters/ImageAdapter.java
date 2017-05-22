package com.strictlyindian.rentsmart.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.Model.ProductImage;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import java.util.List;

import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 22/5/17.
 *
 */

public class ImageAdapter  extends PagerAdapter {




    private List<ProductImage> mList;
    private Context mContext;
    private ImageAdapter.ImageInterface mCallback ;
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        (container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.product_swipe_top_container, container, false);
        ButterKnife.bind(this, layout);
        final ProductImage p = mList.get(position);
        ImageView image = (ImageView) layout.findViewById(R.id.p_top_image);
        Picasso.with(mContext).load(p.getResId())
                .resize(ScreenUtil.getScreenWidth(mContext),ScreenUtil.getScreenHeight(mContext))
                .centerInside()
                .transform(new RoundedCornersTransformation(15,5))
                .into(image);
        container.addView(layout);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCallback != null){
                    mCallback.imageClicked(p);
                }
            }
        });
        return layout;
    }

    public ImageAdapter(Context mContext, List<ProductImage> mList, ImageInterface mCallback) {
        this.mList = mList;
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public interface ImageInterface {
        void imageClicked(ProductImage p);
    }
}

