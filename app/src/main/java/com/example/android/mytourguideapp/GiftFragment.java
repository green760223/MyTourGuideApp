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
public class GiftFragment extends Fragment {


    public GiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.display_list, container, false);

        final ArrayList<Gift> gifts = new ArrayList<Gift>();

        gifts.add(new Gift(
                getString(R.string.sunny_hills),
                getString(R.string.sunny_hills_location),
                getString(R.string.sunny_hills_phone),
                R.drawable.sunny_hills));
        gifts.add(new Gift(
                getString(R.string.chien_hsiang),
                getString(R.string.chien_hsiang_location),
                getString(R.string.chien_hsiang_phone),
                R.drawable.chien_hsiang));
        gifts.add(new Gift(
                getString(R.string.lau_tian_lu),
                getString(R.string.lau_tian_lu_location),
                getString(R.string.lau_tian_lu_phone),
                R.drawable.lau_tain_lu));
        gifts.add(new Gift(
                getString(R.string.e_g_sain),
                getString(R.string.e_g_sain_location),
                getString(R.string.e_g_sain_phone),
                R.drawable.eg_sain));

        GiftAdapter adapter = new GiftAdapter(getActivity(), gifts);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootview;
    }

}
