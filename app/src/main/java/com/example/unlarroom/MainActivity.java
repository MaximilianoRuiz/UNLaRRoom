package com.example.unlarroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.unlarroom.fragment.BackCardFragment;
import com.example.unlarroom.fragment.FrontCardFragment;
import com.example.unlarroom.impl.FakeAuthenticator;
import com.example.unlarroom.interfaces.AuthenticationResource;
import com.example.unlarroom.interfaces.BasicActivityBehavior;

public class MainActivity extends AppCompatActivity implements BasicActivityBehavior {

    private boolean isBackCardDisplayed;

    private FrameLayout fragmentContainerCard;

    private AuthenticationResource authenticationResource = new FakeAuthenticator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Set main Layout for this Activity

        checkIfIsLogged();

        setViewsReferences();

        setViewListeners();

        if (savedInstanceState == null) { //Ask if there is an instanceState saved. If is not, we create one.
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_card, new FrontCardFragment()) //Set by default, the front card in the fragment container
                    .commit();
        }
    }

    public void setViewsReferences() { //Identify the view displayed in the activity using their ids
        fragmentContainerCard = findViewById(R.id.fragment_container_card);
    }

    public void setViewListeners() { //Set the behavior for some views or elements
        fragmentContainerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
    }

    private void checkIfIsLogged() {
        if(authenticationResource.isLogged()) { //If is logged, directly call the main activity
            authenticationResource.signIn(this);
        }
    }

    private void flipCard() { //Define the logic for switch the card displayed
        if (isBackCardDisplayed) { //If the back card is displayed, return to the front card and set false this property
            getFragmentManager().popBackStack();
            isBackCardDisplayed = false;
            return;
        }
        isBackCardDisplayed = true; //If is not, set the property true, set the animation and display the back card

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(R.id.fragment_container_card, new BackCardFragment())
                .addToBackStack(null)
                .commit();
    }
}
