package ru.romeo558.finalproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<MyListItem> {

    private Context mContext;
    private int mResource;

    public MyListAdapter(Context context, int resource, List<MyListItem> items) {
        super(context, resource, items);
        this.mContext = context;
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the current item from the list
        MyListItem item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        // Get references to the views in the layout
        TextView scoreTextView = convertView.findViewById(R.id.scoreTextView);
        TextView headerTextView = convertView.findViewById(R.id.headerTextView);
        TextView descriptionTextView = convertView.findViewById(R.id.descriptionTextView);

        // Set the text of the views
        scoreTextView.setText(String.valueOf(item.getScore()));
        headerTextView.setText(item.getHeader());
        descriptionTextView.setText(item.getDescription());

        // Return the view
        return convertView;
    }
}