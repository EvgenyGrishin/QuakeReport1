package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EqAdapter extends ArrayAdapter<eartquakes> {

    public EqAdapter(Context context, ArrayList<eartquakes> eartquakes){
        super(context, 0, eartquakes);
    }

    public String locSeparator = "of ";
    public String locOffset;
    public String locName;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        eartquakes currentWord = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.eq_mag);

        magTextView.setText(Double.toString(currentWord.getMagnitude()));

        if(currentWord.getLocation().contains(locSeparator)){

            String [] splitLoc = currentWord.getLocation().split(locSeparator);
            locOffset = splitLoc [0] + locSeparator;
            locName = splitLoc [1];
            TextView locDistTextView = (TextView) listItemView.findViewById(R.id.eq_loc_distance);

            locDistTextView.setText(locOffset);

            TextView locCityTextView = (TextView) listItemView.findViewById(R.id.eq_loc_city);

            locCityTextView.setText(locName);
        }

        else {

            locOffset = "Near the";
            locName = currentWord.getLocation();
            TextView locDistTextView = (TextView) listItemView.findViewById(R.id.eq_loc_distance);

            locDistTextView.setText(locOffset);

            TextView locCityTextView = (TextView) listItemView.findViewById(R.id.eq_loc_city);

            locCityTextView.setText(locName);
        }

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.eq_date);

        dateTextView.setText(currentWord.getDate());


        TextView timeTextView = (TextView) listItemView.findViewById(R.id.eq_time);

        timeTextView.setText(currentWord.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
