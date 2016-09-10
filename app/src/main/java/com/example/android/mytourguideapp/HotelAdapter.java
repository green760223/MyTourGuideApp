package com.example.android.mytourguideapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lawrence on 2016/9/8.
 */
public class HotelAdapter extends ArrayAdapter<Hotel> {

    public HotelAdapter(Context context, ArrayList<Hotel> hotelAdapter) {
        super(context, 0, hotelAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView =
                    LayoutInflater.from(getContext()).inflate(R.layout.hotel_item, parent, false);
        }

        Hotel currentHotel = getItem(position);

        ImageView hotelImage = (ImageView) listItemView.findViewById(R.id.hotel_image);
        TextView hotelName = (TextView) listItemView.findViewById(R.id.hotel_name);
        TextView hotelLocation = (TextView) listItemView.findViewById(R.id.hotel_location);
        TextView hotelNumber = (TextView) listItemView.findViewById(R.id.hotel_number);

        if (currentHotel.hasImage()) {
            hotelImage.setImageBitmap(decodeResource(getContext().getResources(), currentHotel.getHotelImage()));
            hotelImage.setVisibility(View.VISIBLE);
        } else {
            hotelImage.setVisibility(View.GONE);
        }

        hotelName.setText(currentHotel.getHotelName());
        hotelLocation.setText(currentHotel.getHotelLocation());
        hotelNumber.setText(currentHotel.getHotelNumber());

        return listItemView;
    }

    /**
     * To prevent OutOfMemoryError issue
     * @param res
     * @param id
     * @return
     */
    private static Bitmap decodeResource(Resources res, int id) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        for (options.inSampleSize = 1; options.inSampleSize <= 32; options.inSampleSize++) {
            try {
                bitmap = BitmapFactory.decodeResource(res, id, options);
                break;
            } catch (OutOfMemoryError outOfMemoryError) {

            }
        }
        return bitmap;
    }
}
