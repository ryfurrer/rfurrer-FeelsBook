/*
Each class must contain comments describing its purpose, design rationale, and any outstanding issues.
This is a class designed to update the list view of feelings.

Adapted from https://github.com/nklapste/lonelyTwitter/blob/feature/lab4/app/src/main/java/ca/ualberta/cs/lonelytwitter/TweetAdapter.java
(Nathan klapstein - lonelyTwitter)
 */

package com.assign1.rfurrer.feelsbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.assign1.rfurrer.feelsbook.R;
import com.assign1.rfurrer.feelsbook.feeling.FeelingsList;
import com.assign1.rfurrer.feelsbook.feeling.Mood;



public class FeelingListAdapter extends ArrayAdapter<Mood> {

    FeelingsList fl;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     * @param moods  The objects to represent in the ListView.
     */
    public FeelingListAdapter(@NonNull Context context, int resource, FeelingsList moods) {
        super(context, resource, moods);
        this.fl = moods;
    }


    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return {@code View}
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Mood mood = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // set the message of the Tweet
        TextView tweetMessage = (TextView) convertView.findViewById(R.id.list_item_text);
        tweetMessage.setText(mood.toString());

        return convertView;
    }

    @Override
    public int getCount() {
        return fl.getCount();
    }
}
