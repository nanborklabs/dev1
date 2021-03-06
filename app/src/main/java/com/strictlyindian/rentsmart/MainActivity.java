package com.strictlyindian.rentsmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.strictlyindian.rentsmart.Activity.ExamBooksActivity;
import com.strictlyindian.rentsmart.Activity.GenrealBooksActivity;
import com.strictlyindian.rentsmart.Activity.OrganisationBooksActivity;
import com.strictlyindian.rentsmart.Fragments.CartFragment;
import com.strictlyindian.rentsmart.Fragments.CategoriesFragment;
import com.strictlyindian.rentsmart.Fragments.MainFragment;
import com.strictlyindian.rentsmart.Fragments.NotificationsFragment;
import com.strictlyindian.rentsmart.Fragments.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnTabSelectListener, OnTabReselectListener {

    private static final String TAG = "BOOKAHOLIC";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.search_card)
//    CardView searchCard;


    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    //The Fragment Layot PlaceHolder
    @BindView(R.id.frag_holder_main)
    FrameLayout mFragHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        setUpBottomar();
        showMainFrag();


    }

    private void setUpBottomar() {
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        bottomBar.setOnTabReselectListener(this);
        bottomBar.setLongPressHintsEnabled(true);


    }



    private void showMainFrag() {
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frag_holder_main,new MainFragment())
                .commit();
    }


    @Override
    public void onBackPressed() {

        getSupportFragmentManager().popBackStack();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent i = null;
        int id = item.getItemId();

        if (id == R.id.e_books) {
            // Handle the camera action
            i = new Intent(this, ExamBooksActivity.class);

        } else if (id == R.id.o_menu) {

            i = new Intent(this, OrganisationBooksActivity.class);
        }
        else{

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        startActivity(i);
        return true;
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {

        Fragment mFragment = null;
        switch (tabId){
            case R.id.tab_home:
                mFragment = new MainFragment();
                break;
            case R.id.tab_categories:
                mFragment  = new CategoriesFragment();
                break;
            case R.id.tab_notifications:
                mFragment = new NotificationsFragment();
                break;
            case R.id.tab_profile:
                mFragment = new ProfileFragment();
                break;
            case R.id.tab_cart:
                mFragment = new CartFragment();
                break;
            default:
                return;

        }

        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frag_holder_main,mFragment)
                .commit();
    }

    @Override
    public void onTabReSelected(@IdRes int tabId) {

    }
}
