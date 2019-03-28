package com.example.unlarroom.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unlarroom.R;
import com.example.unlarroom.interfaces.BasicFragmentBehavior;

public class FrontCardFragment extends Fragment implements BasicFragmentBehavior {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_front, container, false);
        return view;
    }

    @Override
    public void setViewsReferences() {
    }

    @Override
    public void setViewListeners() {
        //Not required in Fragments
    }

    @Override
    public void setViewsReferences(View view) {
    }
}