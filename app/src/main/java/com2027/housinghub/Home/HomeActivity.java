package com2027.housinghub.Home;
/**
 * The Main Activity which holds the fragments and sidebar navigation
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar ;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com2027.housinghub.Account.AccountFragment;
import com2027.housinghub.Favourites.FavouriteFragment;
import com2027.housinghub.Group.GroupFragment;
import com2027.housinghub.Manifest;
import com2027.housinghub.R;
import com2027.housinghub.Settings.SettingsFragment;

//Imports NavigationView
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "HomeActivity";
    private Context mContext = HomeActivity.this;

    //The side layout
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);
        Log.d(TAG,"onCreate: starting");


        //calls the method that sets up the navigation side view
        setUpNavigationView(savedInstanceState);


    }

    /**
     *This sets up the navigation view
     * @param savedInstanceState
     */
    private void setUpNavigationView(Bundle savedInstanceState) {
        Log.d(TAG, "setupNavigationView: setting up NavigationView");

        Toolbar toolbar = findViewById(R.id.widget_toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer, toolbar, R.string.navigationn_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //if there are saved instance states the app doesnt reset on rotation.
        if(savedInstanceState == null)
        { getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    private void getLocationPermission(){
        //ASKS THE USER FOR PERMISION TO USE LOCATION
    }

    /**
     * When a navigation item is selected, this method chooses the appropriate
     * Fragment to opennbggs
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_group:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GroupFragment()).commit();
                break;

            case R.id.nav_favourite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavouriteFragment()).commit();
                break;

            //This will have to change for user and landlord,  (so make two account fragments) if user is student
            //show this, if not, show this.
            case R.id.nav_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AccountFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;

            case R.id.nav_signout_:
                Toast.makeText(this,"Sign out", Toast.LENGTH_SHORT).show();
                break;

            case R.id.help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     *is called to close the app when back is pressed
     */
    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    /**
     *
     */
    @Override
    public void onStart() {
        super.onStart();
        //...
    }

    /**
     *
     */
    @Override
    public void onStop() {
        super.onStop();
        //...
    }


}
