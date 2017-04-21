package com.strictlyindian.rentsmart.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
;
import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 2/8/16.
 * The Grid Adapter Which is used in {@link com.strictlyindian.rentsmart.Fragments.BrosweProductFragments}
 */
public class ProductGridAdapter extends BaseAdapter {

    private Context mContext;
    public int Animated_item_count;
    public int last_pos=-1;
    private List<Product>  mlist;

    public ProductGridAdapter(Context context, List<Product> mList) {
        this.mContext=context;
        this.mlist=mList;
        Animated_item_count=mList.size();
    }
        public View mView;
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return (Object)mView;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView==null){
           convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_item,parent,false);
           mView=convertView;

       }
        int a =R.mipmap.imd;
       if (position % 2 ==0){
           a = R.mipmap.fifa;
       }
        if (position %3 ==0){
            a = R.mipmap.godofwar;
        }
        if (position == 4){
            a= R.mipmap.sapiens;
        }
        if (position == 5){
            a = R.mipmap.afd;
        }

        ImageView im = (ImageView) mView.findViewById(R.id.p_item_image);
        Picasso.with(mContext)
                .load(a)
                .resize(ScreenUtil.getScreenWidth(mContext),ScreenUtil.getScreenHeight(mContext))
                .centerCrop()
                .transform(new RoundedCornersTransformation(10,5))
                .into(im);

//        runEnteranim(convertView,position);
        return convertView;



    }

    private void runEnteranim(View convertView, int position) {
        Log.d("Animation",""+position);

        if (position>=Animated_item_count){
            Log.d("Animation","postion one");
            return;
        }
        if (position>last_pos){

            Log.d("Animation","inside if");
            last_pos=position;
            convertView.setTranslationY(ScreenUtil.getScreenHeight(mContext));
            convertView.animate().translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
        }
}

