package com.strictlyindian.rentsmart.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.strictlyindian.rentsmart.Fragments.BrosweProductFragments;
import com.strictlyindian.rentsmart.utils.BundleKey;

/**
 * Created by nandhu on 20/4/17.
 * The Adapter Which is used in {@link com.strictlyindian.rentsmart.MainActivity}
 *
 *
 */
public class MainFragmentAdapter extends FragmentStatePagerAdapter{

    private Context mContext;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BrosweProductFragments mFragments = new BrosweProductFragments();
        Bundle  b = new Bundle();
        switch (position){
            case 0:
                b.putInt(BundleKey.ARG_SHOW_PRODUCT,0);
                break;
            case 1:
                b.putInt(BundleKey.ARG_SHOW_PRODUCT,1);
                break;
            case 2:
                b.putInt(BundleKey.ARG_SHOW_PRODUCT,2);
                break;

            default:return null;
        }
        mFragments.setArguments(b);
        return mFragments;
    }

    @Override
    public int getCount() {
        return 3;
    }

/*    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "NEW ARRIVALS";
            case 1:
                return "WHAT'S POPULAR";
            case 2:
                return "OFFERS";
            default: return null;
        }
    }*/
}
