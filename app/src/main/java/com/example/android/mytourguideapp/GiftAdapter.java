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
 * Created by Lawrence on 2016/9/9.
 */
public class GiftAdapter extends ArrayAdapter<Gift> {

    public GiftAdapter(Context context, ArrayList<Gift> giftsAdapter) {
        super(context, 0, giftsAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null ) {
            listItemView =
                    LayoutInflater.from(getContext()).inflate(R.layout.gift_item, parent, false);
        }

        Gift currentGift = getItem(position);

        ImageView giftImage = (ImageView) listItemView.findViewById(R.id.gift_image);
        TextView giftName = (TextView) listItemView.findViewById(R.id.gift_name);
        TextView giftLocation = (TextView) listItemView.findViewById(R.id.gift_location);
        TextView giftNumber = (TextView) listItemView.findViewById(R.id.gift_number);

        if (currentGift.hasImage()) {
            giftImage.setImageBitmap(decodeResource(getContext().getResources(), currentGift.getGiftImage()));
            giftImage.setVisibility(View.VISIBLE);
        } else {
            giftImage.setVisibility(View.GONE);
        }

        giftName.setText(currentGift.getGiftName());
        giftLocation.setText(currentGift.getGiftLocation());
        giftNumber.setText(currentGift.getGiftNumber());

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
