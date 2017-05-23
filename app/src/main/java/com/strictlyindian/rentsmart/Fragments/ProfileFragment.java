package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Adapters.ProfileAdapter;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.StorageHelpers.DataStore;
import com.strictlyindian.rentsmart.utils.BlurBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.BlurTransformation;

import static android.app.Activity.RESULT_OK;


/**
 * Created by nandhu on 21/4/17.
 * The Fragment Which Shows Profile Fragment
 */

public class ProfileFragment extends Fragment {



public static String TAG = "BOOKAHOLIC PROFILE FRAG";

    //The Main Views
    @BindView(R.id.profile_collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.profile_tab)
    TabLayout mTabLayout;
    @BindView(R.id.profile_pager)
    ViewPager mPager;
    @BindView(R.id.profile_pager_holder)
    LinearLayout mPagerHolder;



    //The Views inside Collapsing Toolbar
    @BindView(R.id.profile_bg_image)
    ImageView mBackgroundImage;
    @BindView(R.id.profile_image)
    ImageView mProfileImage;
    @BindView(R.id.profile_name)
    TextView mName;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.profile_location)
    TextView mLocation;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.profile_phone_number)
    TextView mPhoneNumber;
    private Context mContext;

    DataStore mStore;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.profile_frag, container, false);
        ButterKnife.bind(this, v);


        Picasso.with(mContext)
                .load(R.mipmap.pop)
                .into(mProfileImage);



        mProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });

        Picasso.with(mContext)
                .load(R.mipmap.fifaa)
                .transform(new BlurTransformation(mContext))
                .into(mBackgroundImage);

        setUpPager();


        return v;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && null != data) {

            try {


                Uri selectedImage = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), selectedImage);

                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = mContext.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                Log.d(TAG, "onActivityResult: Picture path " + picturePath);

                if (mStore != null) {
                    mStore.setProPicturePath(selectedImage.toString());
                } else {
                    Snackbar.make(getView(), "Problem Importing Picture", Toast.LENGTH_LONG).show();
                }
                cursor.close();
                //Load the Image
                Picasso.with(mContext).load(selectedImage).resize(150, 150).centerCrop().into(mProfileImage);
                //set The Back Ground Image Too
                Bitmap b = BlurBuilder.blur(mContext,bitmap);
                mBackgroundImage.setImageBitmap(b);

            } catch (Exception e) {
                Log.d(TAG, "onActivityResult: Exception in Setting Picture : "+e.getLocalizedMessage());
            }
        }
    }

    //The Picks image and Result is Obtained in OnActivity Result
    private void pickImage() {
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        getActivity().startActivityForResult(i, 101);
    }

    private void setUpPager() {
        ProfileAdapter mAdapter = new ProfileAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
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
        if (mStore == null){
            mStore = DataStore.getStorageInstance(mContext);
        }
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
}
