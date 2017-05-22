package com.strictlyindian.rentsmart.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.CustomUI.ElasticDragDismissFrameLayout;
import com.strictlyindian.rentsmart.CustomUI.FABToggle;
import com.strictlyindian.rentsmart.CustomUI.ParallaxScrimageView;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.BundleKey;
import com.strictlyindian.rentsmart.utils.ScreenUtil;

import org.w3c.dom.Comment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 20/5/17.
 *
 */

public class PlaidViewActivity extends AppCompatActivity {


    private static final String TAG = "BOOKAHOLIC";
    @BindView(R.id.draggable_frame)
    ElasticDragDismissFrameLayout draggableFrame;
    @BindView(R.id.back)
    ImageButton back;
    @BindView(R.id.shot)
    ParallaxScrimageView imageView;
    @BindView(R.id.dribbble_comments)
    FrameLayout commentsList;
    @BindView(R.id.fab_heart)
    FABToggle fab;

    View top;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dribbble_shot);
        ButterKnife.bind(this);
        if(getIntent() != null){
            String trans = getIntent().getStringExtra(BundleKey.TRANS_NAME);
            imageView.setTransitionName(trans);
            Picasso.with(this)
                    .load(R.mipmap.godofwar)
                    .resize(ScreenUtil.getScreenWidth(this),ScreenUtil.getScreenHeight(this))
                    .into(imageView);
        }
        top = getLayoutInflater().inflate(R.layout.dribbble_shot_title,
                commentsList, false);
//        TextView title = (TextView) top.findViewById(R.id.shot_title);
//        TextView desc = (TextView) top.findViewById(R.id.shot_description);


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, " PLV onPostResume: ");
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, " PLV onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, " PLV onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " PLV onDestroy: ");

    }
}
