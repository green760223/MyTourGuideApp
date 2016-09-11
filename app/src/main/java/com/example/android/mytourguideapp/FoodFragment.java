package com.example.android.mytourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.display_list, container, false);

        final ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(new Food(
                getString(R.string.chia_te_bakery),
                getString(R.string.chia_te_bakery_location),
                getString(R.string.chia_te_bakery_time),
                R.drawable.honey_cake));
        foods.add(new Food(
                getString(R.string.din_tai_fung),
                getString(R.string.din_tai_fung_location),
                getString(R.string.din_tai_fung_time),
                R.drawable.din_tai_fung));
        foods.add(new Food(
                getString(R.string.rice_noodle),
                getString(R.string.rice_noodle_location),
                getString(R.string.rice_noodle_time),
                R.drawable.rice_noodle));
        foods.add(new Food(
                getString(R.string.formosa_chang),
                getString(R.string.formosa_chang_location),
                getString(R.string.formosa_chang_time),
                R.drawable.formosa_chang));
        foods.add(new Food(
                getString(R.string.iced_store),
                getString(R.string.iced_store_location),
                getString(R.string.iced_store_time),
                R.drawable.ice_store));
        foods.add(new Food(
                getString(R.string.beef_ramen),
                getString(R.string.beef_ramen_location),
                getString(R.string.beef_ramen_time),
                R.drawable.beef_ramen));
        foods.add(new Food(
                getString(R.string.simon_templar),
                getString(R.string.simon_templar_location),
                getString(R.string.simon_templar_time),
                R.drawable.simon_templar));
        foods.add(new Food(
                getString(R.string.juice),
                getString(R.string.juice_location),
                getString(R.string.juice_time),
                R.drawable.juice_store));
        foods.add(new Food(
                getString(R.string.lamb_restaurant),
                getString(R.string.lamb_restaurant_location),
                getString(R.string.lamb_restaurant_time),
                R.drawable.mo_zai_yang));

        FoodAdapter foodAdapter = new FoodAdapter(getActivity(), foods);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(foodAdapter);

        return rootview;
    }

}
