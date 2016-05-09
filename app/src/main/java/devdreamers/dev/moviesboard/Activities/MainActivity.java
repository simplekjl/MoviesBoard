package devdreamers.dev.moviesboard.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import devdreamers.dev.moviesboard.Fragments.MovieDetailsFragment;
import devdreamers.dev.moviesboard.Model.Movie;
import devdreamers.dev.moviesboard.R;
import devdreamers.dev.moviesboard.Utils.PortalFragment;

/**
 * http://stackoverflow.com/questions/9627774/android-allow-portrait-and-landscape-for-tablets-but-force-portrait-on-phone
 * @author JLCS
 */
public class MainActivity extends AppCompatActivity implements PortalFragment{

    private String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //validar la rotacion del device
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    }

    @Override
    public void sendData(Movie movie) {
        Log.d(LOG_TAG,movie.toString());
        MovieDetailsFragment mDetails = (MovieDetailsFragment) getSupportFragmentManager().
                findFragmentById(R.id.movieDetails);
        //sending the information to the fragment
        mDetails.setup(movie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //inflating the menu
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
        case R.id.action_settings:
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;


        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
