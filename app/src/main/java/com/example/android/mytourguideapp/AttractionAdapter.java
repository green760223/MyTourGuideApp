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
 * Created by Lawrence on 2016/9/7.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Context context, ArrayList<Attraction> attractionAdapter) {
        super(context, 0, attractionAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView =
                    LayoutInflater.from(getContext()).inflate(R.layout.attraction_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.attraction_image);
        TextView attractionName = (TextView) listItemView.findViewById(R.id.attraction_name);
        TextView attractionType = (TextView) listItemView.findViewById(R.id.attraction_type);
        TextView attractionDescription = (TextView) listItemView.findViewById(R.id.attraction_description);

        if (currentAttraction.hasAttractionImage()) {
            imageView.setImageBitmap(decodeResource(getContext().getResources(),currentAttraction.getAttractionImage()));
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        attractionName.setText(currentAttraction.getAttractionName());
        attractionType.setText(currentAttraction.getAttractionType());
        attractionDescription.setText(currentAttraction.getAttractionDescription());

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
