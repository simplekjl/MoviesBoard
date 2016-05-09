package devdreamers.dev.moviesboard.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import devdreamers.dev.moviesboard.Fragments.MovieDetailsFragment;
import devdreamers.dev.moviesboard.Model.Movie;
import devdreamers.dev.moviesboard.R;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getting the information from the putextras

        MovieDetailsFragment mDetails = (MovieDetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        //sending the information of the movie storaged into the extras of the intent from the
        //fragment Feed
        Movie mMovie = getIntent().getExtras().getParcelable("movie");
        mDetails.setup(mMovie);
    }

}
