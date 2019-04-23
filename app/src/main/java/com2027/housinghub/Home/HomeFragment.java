package com2027.housinghub.Home;
/**
 * Home fragment that holds the home layout
 */

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import com2027.housinghub.Models.House;
import com2027.housinghub.R;
import com2027.housinghub.Utils.MainFeedListAdapter;

public class HomeFragment extends Fragment {

    private static final String TAG = "Home Fragment";

    //variables
    private ArrayList<House> mHouse;
    //we need this cause the houses that are shown are based on the users location .
    private Location location;
    private ListView mListView;
    private MainFeedListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mListView = (ListView) mListView.findViewById(R.id.listView);
        //location = new Location();
        mHouse = new ArrayList<>();

        return inflater.inflate(R.layout.fragment_home, container,  false);
    }

    private void getLocation(){
        Log.d(TAG, "fetching users location");
        //QUERY TO GET USERS LOCATION
    }

    private void getHouses(){
        Log.d(TAG, "fetching users house");
        //DATABASE QUERY TO GET PHOTOS
        //set title here
        //set tags here
        //set timeframe date here

    }

    private void displayHouses(){
        if(mHouse != null){
            //code to display houses
        }else{
            if(mHouse.isEmpty()){
                //code to display "no houses available"
            }
        }
    }

}
