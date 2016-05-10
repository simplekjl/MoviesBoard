package devdreamers.dev.moviesboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import devdreamers.dev.moviesboard.Model.Video;
import devdreamers.dev.moviesboard.R;

/**
 * Created by jlcs on 5/8/16.
 */
public class TrailerAdapter extends ArrayAdapter<Video> {

    private List<Video> mList;
    private Context context;
    private TextView mText;


    public TrailerAdapter(Context context, int resource) {
        super(context,resource);

        this.context = context;
    }

    public TrailerAdapter(Context context, int resource, List<Video> results) {
        super(context, resource, results);
        mList = results;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_video,parent,false);
        }
        Video mVideo = mList.get(position);
        if(mVideo != null){
            mText = (TextView) view.findViewById(R.id.reviewText);
            mText.setText(mVideo.getName());

        }
        return view;
    }
    /**
     * Sets ListView height dynamically based on the height of the items.
     *
     * @param listView to be resized
     * @return true if the listView is successfully resized, false otherwise
     */
    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

    }
}
