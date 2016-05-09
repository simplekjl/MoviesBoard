package devdreamers.dev.moviesboard.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import devdreamers.dev.moviesboard.Model.Video;
import devdreamers.dev.moviesboard.R;

/**
 * Created by jlcs on 5/8/16.
 */
public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {

    private List<Video> mList;
    private Context context;

    public TrailerAdapter(List<Video> results, Context context) {
        mList = results;
        this.context = context;
    }

    @Override
    public TrailerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrailerAdapter.ViewHolder holder, int position) {

        Video mVideo = mList.get(position);
        holder.setup(mVideo);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mText;

        public ViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.reviewText);

        }

        public void setup(Video movie) {

            mText.setText(movie.getName());
        }
    }
}
