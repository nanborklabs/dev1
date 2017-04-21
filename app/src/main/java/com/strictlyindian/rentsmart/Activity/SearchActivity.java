package com.strictlyindian.rentsmart.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.strictlyindian.rentsmart.R;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 21/4/17.
 * The Search Activity
 */

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);
    }
}
