package devdreamers.dev.moviesboard.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import devdreamers.dev.moviesboard.Activities.MovieDetailsActivity;
import devdreamers.dev.moviesboard.Model.Movie;
import devdreamers.dev.moviesboard.R;
import devdreamers.dev.moviesboard.Utils.PortalFragment;

/**
 * Created by jlcs on 5/8/16.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> mList = new ArrayList<Movie>();
    private String LOG_TAG =FeedAdapter.class.getSimpleName();
    private PortalFragment portal;

    public FeedAdapter(List<Movie> results,Context context) {
        this.mList = results;
        this.mContext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {

        Movie mMovie = mList.get(position);
        holder.setItem(mMovie);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.movieImage);

        }

        public void setItem(final Movie mMovie) {
            /**
             * The base URL will look like: http://image.tmdb.org/t/p/.
             Then you will need a ‘size’, which will be one of the following: "w92", "w154", "w185", "w342", "w500", "w780", or "original".
             For most phones we recommend using “w185”.
             And finally the poster path returned by the query, in this case “/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg”
             Combining these three parts gives us a final url of http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg

             This is also explained explicitly in the API documentation for /configuration.

             */

            //sizes Images
            String [] sizes = {"w92","w154","w185","w342","w500","w780","original"};

            //creating a URI
            Uri url = Uri.parse("http://image.tmdb.org/t/p/").buildUpon()
                    .appendEncodedPath(sizes[2])
                    .appendEncodedPath(mMovie.getPoster_path())
                    .build();
            //Log.d(LOG_TAG, url.toString());
            //setting up the view
            Picasso.with(mContext).load(url.toString()).placeholder(R.mipmap.default_placeholder)
                    .error(R.mipmap.default_placeholder).into(mImage);

            mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //first we have to verify if there is a tablet or phone
                    if(mContext.getResources().getBoolean(R.bool.portrait_only)) {
                        Intent intent = new Intent(mContext, MovieDetailsActivity.class);
                        intent.putExtra("movie",mMovie);
                        mContext.startActivity(intent);
                    }
                    else{
                        //fragments communication
                        portal = (PortalFragment) mContext;
                        portal.sendData(mMovie);

                    }
                }
            });
        }

    }
}
