package com.example.unlarroom.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.unlarroom.R;
import com.example.unlarroom.impl.FakeAuthenticator;
import com.example.unlarroom.interfaces.AuthenticationResource;
import com.example.unlarroom.interfaces.BasicFragmentBehavior;

public class BackCardFragment extends Fragment implements BasicFragmentBehavior {

    private Button btnSignIn;

    private AuthenticationResource authenticationResource = new FakeAuthenticator();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_back, container, false);

        setViewsReferences(view);

        setViewListeners();
        return view;
    }

    @Override
    public void setViewsReferences(View view) {
        btnSignIn = view.findViewById(R.id.btnSignIn);
    }

    @Override
    public void setViewsReferences() {
        //Not required in Fragments
    }

    @Override
    public void setViewListeners() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO init new Activity
                signIn();
            }
        });
    }

    private void signIn(){
        authenticationResource.signIn(getActivity());
    }
}