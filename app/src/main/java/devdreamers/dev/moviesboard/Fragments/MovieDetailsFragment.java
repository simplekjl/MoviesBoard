package devdreamers.dev.moviesboard.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import devdreamers.dev.moviesboard.Adapters.TrailerAdapter;
import devdreamers.dev.moviesboard.Model.Movie;
import devdreamers.dev.moviesboard.Model.ResponseVideosAPI;
import devdreamers.dev.moviesboard.Network.MoviesService;
import devdreamers.dev.moviesboard.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private String LOG_TAG = MovieDetailsFragment.class.getSimpleName();


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
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);
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
        Log.d(LOG_TAG,movie.toString());

        //TODO llenar recyclerView
        //making the call to the api to get the information
        Call<ResponseVideosAPI> mResponse = new MoviesService().getRetrofit()
                .getMovieVideos(movie.getId().toString(),getString(R.string.API_KEY));
        //Log.d(LOG_TAG,movie.toString());
        mResponse.enqueue(new Callback<ResponseVideosAPI>() {
            @Override
            public void onResponse(Call<ResponseVideosAPI> call, Response<ResponseVideosAPI> response) {
                //Log.d(LOG_TAG,response.message().toString());
                adapter = new TrailerAdapter(response.body().getResults(),getContext());
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseVideosAPI> call, Throwable t) {

            }
        });


    }
}
