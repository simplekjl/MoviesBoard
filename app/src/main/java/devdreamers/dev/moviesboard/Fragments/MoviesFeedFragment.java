package devdreamers.dev.moviesboard.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import devdreamers.dev.moviesboard.Model.ResponseAPI;
import devdreamers.dev.moviesboard.Network.MoviesService;
import devdreamers.dev.moviesboard.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragment for the feed of all the movies
 * Created by jlcs on 5/8/16.
 */
public class MoviesFeedFragment extends Fragment{


    private RecyclerView.Adapter mAdapter;
    private RecyclerView         mRecyclerView;
    private List<ResponseAPI>    mList = new ArrayList<ResponseAPI>();
    private GridLayoutManager    mGridLayoutManager;
    private String LOG_TAG       = MoviesFeedFragment.class.getSimpleName();


    public MoviesFeedFragment() {
        //option to overrride the menu
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_feed, container, false);

        //getting all the views
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setHasFixedSize(true);


        //getting the information from the server
        Call<ResponseAPI> mService = new MoviesService().getRetrofit().getPopularMovies(getString(R.string.API_KEY));
        mService.enqueue(new Callback<ResponseAPI>() {
            @Override
            public void onResponse(Call<ResponseAPI> call, Response<ResponseAPI> response) {
                Log.d(LOG_TAG,response.body().getResults().get(0).toString());
            }

            @Override
            public void onFailure(Call<ResponseAPI> call, Throwable t) {

            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            //updateWeather();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
