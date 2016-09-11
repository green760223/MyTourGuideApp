package com.example.android.mytourguideapp;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionFragment extends Fragment {


    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootview = inflater.inflate(R.layout.display_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        attractions.add(new Attraction(
                getString(R.string.taipei101),
                getString(R.string.taipei101_description),
                R.drawable.taipei_101,
                getString(R.string.mall),
                R.drawable.location_101));
        attractions.add(new Attraction(
                getString(R.string.taipei_beer_factory),
                getString(R.string.taipei_beer_factory_description),
                R.drawable.taipei_beer_factory,
                getString(R.string.factory),
                R.drawable.location_beer));
        attractions.add(new Attraction(
                getString(R.string.raohe_night_market),
                getString(R.string.raohe_night_market_description),
                R.drawable.night_market,
                getString(R.string.night_market),
                R.drawable.location_night_market));
        attractions.add(new Attraction(
                getString(R.string.taipei_zoo),
                getString(R.string.taipei_zoo_description),
                R.drawable.taipei_zoo,
                getString(R.string.public_place),
                R.drawable.location_zoo));
        attractions.add(new Attraction(
                getString(R.string.xinbeitou_hot_spring),
                getString(R.string.xinbeitou_hot_spring_description),
                R.drawable.hot_spring,
                getString(R.string.hot_spring),
                R.drawable.location_spring));
        attractions.add(new Attraction(
                getString(R.string.longshan_temple),
                getString(R.string.longshan_temple_description),
                R.drawable.longshan_temple,
                getString(R.string.temple),
                R.drawable.location_temple));
        attractions.add(new Attraction(
                getString(R.string.national_palace_museum),
                getString(R.string.national_palace_museum_description),
                R.drawable.national_palace_museum,
                getString(R.string.museum),
                R.drawable.location_museum));
        attractions.add(new Attraction(
                getString(R.string.dadaocheng_wharf),
                getString(R.string.dadaocheng_wharf_description),
                R.drawable.dadaocheng,
                getString(R.string.public_place),
                R.drawable.locaiton_whraf));

        final AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), attractions);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // custom dialog
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.activity_custom_dialog);
                dialog.setTitle(R.string.location_dialog_title);

                // set the custom dialog components - text, image and button
                ImageView image = (ImageView) dialog.findViewById(R.id.dialog_image);
                TextView confirm = (TextView) dialog.findViewById(R.id.textview_confirm);
                confirm.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                image.setImageResource(attractions.get(i).getAttractionLocation());
                dialog.show();
            }
        });

        return rootview;
    }
}
