import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com2027.housinghub.R;

/**
 *
 */
public class HouseViewActivity extends AppCompatActivity {
    private static final String TAG = "HouseViewActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_view_post);

        if(isServicesOk()){
            //init();
            //do somethin
        }
    }


    private void initMap(){
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                //map isa ready
            }
        });
    }
    /**
     *
     * @return
     */
    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(HouseViewActivity.this);
        if(available == ConnectionResult.SUCCESS){
            //everything is working and the user may make requests
            Log.d(TAG, "isServicesOK: Google Play services is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error could be resolved
            Log.d(TAG,"isServicesOK: an error occured, could be resolved");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "There is an error with your map", Toast.LENGTH_SHORT).show();

        }
        return false;
    }


}
