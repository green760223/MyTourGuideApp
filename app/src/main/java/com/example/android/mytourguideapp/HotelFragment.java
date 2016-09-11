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
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.display_list, container, false);

        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        hotels.add(new Hotel(
                getString(R.string.master_hotel),
                getString(R.string.master_hotel_location),
                getString(R.string.master_hotel_phone),
                R.drawable.master_hotel));
        hotels.add(new Hotel(
                getString(R.string.taipei_discover_hostel),
                getString(R.string.taipei_discover_hostel_location),
                getString(R.string.taipei_discover_hostel_phone),
                R.drawable.taipei_discover_hostel));
        hotels.add(new Hotel(
                getString(R.string.on_my_way),
                getString(R.string.on_my_way_location),
                getString(R.string.on_my_way_phone),
                R.drawable.on_my_way));
        hotels.add(new Hotel(
                getString(R.string.flip_flop_hostel),
                getString(R.string.flip_flop_hostel_location),
                getString(R.string.flip_flop_hostel_phone),
                R.drawable.flip_flop));
        hotels.add(new Hotel(
                getString(R.string.simple_hotel),
                getString(R.string.simple_hotel_location),
                getString(R.string.simple_hotel_phone),
                R.drawable.simple_plus));
        hotels.add(new Hotel(
                getString(R.string.formosa_101),
                getString(R.string.formosa_101_location),
                getString(R.string.formosa_101_phone),
                R.drawable.formosa_101));
        hotels.add(new Hotel(
                getString(R.string.meander_taipei),
                getString(R.string.meander_taipei_location),
                getString(R.string.meander_taipei_phone),
                R.drawable.meander_taipei));
        hotels.add(new Hotel(
                getString(R.string.sleepy_dragon_hostel),
                getString(R.string.sleepy_dragon_hostel_location),
                getString(R.string.sleepy_dragon_hostel_phone),
                R.drawable.sleepy_dragon_hostel));

        HotelAdapter adapter = new HotelAdapter(getActivity(), hotels);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootview;
    }

}
