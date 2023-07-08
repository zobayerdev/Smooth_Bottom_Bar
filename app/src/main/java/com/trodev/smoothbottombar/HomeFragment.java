package com.trodev.smoothbottombar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trodev.smoothbottombar.R;


public class HomeFragment extends Fragment {

    ImageView home;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        home = view.findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 goTo();
            }
        });

        return view;
    }

    private void goTo() {

        Intent intent = new Intent(getActivity(), FullOfActivity.class);
        startActivity(intent);

    }
}