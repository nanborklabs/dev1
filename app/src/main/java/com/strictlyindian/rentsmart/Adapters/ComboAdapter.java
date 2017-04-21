package com.strictlyindian.rentsmart.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.utils.ScreenUtil;
import com.strictlyindian.rentsmart.CustomUI.FourThreeImageView;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import java.util.List;

import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 16/3/17.
 *
 */

public class ComboAdapter extends PagerAdapter {




    private List<Product> mList;
    private Context mContext;
    private ComboInterface mCallback ;
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
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.top_image, container, false);
        ButterKnife.bind(this, layout);
        ImageView image = (ImageView) layout.findViewById(R.id.top_image);
        Picasso.with(mContext).load(R.mipmap.fifaa)
                .resize(ScreenUtil.getScreenWidth(mContext),ScreenUtil.getScreenHeight(mContext))
                .centerInside()
                .transform(new RoundedCornersTransformation(15,5))
                .into(image);
        container.addView(layout);
       final Product p = mList.get(position);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCallback != null){
                    mCallback.ComboproductClicked(p);
                }
            }
        });
         return layout;
    }

    public ComboAdapter(List<Product> mList, Context mContext, ComboInterface mCallback) {
        this.mList = mList;
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public interface ComboInterface {
        void ComboproductClicked(Product p);
        }
    }

