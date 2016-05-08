package devdreamers.dev.moviesboard.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devdreamers.dev.moviesboard.R;

/**
 * Fragment for the feed of all the movies
 * Created by jlcs on 5/8/16.
 */
public class MoviesFeedFragment extends Fragment{

    public MoviesFeedFragment() {
        //option to overrride the menu
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_feed, container, false);



        return rootView;
    }
}
