package samples.richardlee.topdownloadedapps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by admin on 02/12/2016.
 */

public class FeedAdapter extends ArrayAdapter<FeedEntry> {
    private static final String TAG = "FeedAdapter";
    private final int resource;
    private final LayoutInflater inflater;
    private List<FeedEntry> items;


    public FeedAdapter(Context context, int resource, List<FeedEntry> objects) {
        super(context, resource, objects);

        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
        this.items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder(convertView);

            //Storing a reference to viewHolder instance on convertView object
            convertView.setTag(viewHolder);
        } else {
            //Retrieving the object (by reference) by tag (with 'findViewById' actions already done)
            viewHolder = (ViewHolder) convertView.getTag();
        }

        FeedEntry feedEntry = items.get(position);

        viewHolder.tvName.setText(feedEntry.getName());
        viewHolder.tvArtist.setText(feedEntry.getArtist());
        viewHolder.tvSummary.setText(feedEntry.getArtist());

        return convertView;
    }

    //ViewHolder inner class to hold the references for field on that view
    private class ViewHolder {
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        ViewHolder(View v) {
            this.tvName = (TextView) v.findViewById(R.id.tvName);
            this.tvArtist = (TextView) v.findViewById(R.id.tvArtist);
            this.tvSummary = (TextView) v.findViewById(R.id.tvSummary);
        }
    }


}
