package devdreamers.dev.moviesboard.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import devdreamers.dev.moviesboard.Model.Movie;
import devdreamers.dev.moviesboard.R;

/**
 * Fragment for the details of the movies
 * Created by jlcs on 5/8/16.
 */
public class MovieDetailsFragment extends Fragment {

    private ImageView mImage;
    private TextView  mYear;
    private TextView  mDuration;
    private TextView  mRate;
    private Button mFavoriteBtn;
    private TextView mDescription;
    private Toolbar  mToolbar;
    private RecyclerView.Adapter adapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager llm;


    public MovieDetailsFragment() {
        //option to overrride the menu
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_details, container, false);
        mImage       = (ImageView) rootView.findViewById(R.id.image);
        mYear        = (TextView) rootView.findViewById(R.id.year);
        mDuration    = (TextView) rootView.findViewById(R.id.rate);
        mFavoriteBtn = (Button) rootView.findViewById(R.id.favoriteBtn);
        mDescription = (TextView) rootView.findViewById(R.id.description);
        //mToolbar     = (Toolbar) rootView.findViewById(R.id.toolbar);


        return rootView;
    }

    public void setup(Movie movie){
        //sizes Images
        String [] sizes = {"w92","w154","w185","w342","w500","w780","original"};

        //creating a URI
        Uri url = Uri.parse("http://image.tmdb.org/t/p/").buildUpon()
                .appendEncodedPath(sizes[2])
                .appendEncodedPath(movie.getPoster_path())
                .build();

        Picasso.with(getContext()).load(url.toString()).placeholder(R.mipmap.default_placeholder)
                .into(mImage);

        mYear.setText(movie.getTitle());
        mDuration.setText(movie.getRelease_date());
        mDescription.setText(movie.getOverview());

        //TODO llenar recyclerView

    }
}
