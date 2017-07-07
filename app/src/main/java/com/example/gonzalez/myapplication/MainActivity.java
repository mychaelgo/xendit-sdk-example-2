package com.example.gonzalez.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onradar.sdk.Radar;
import com.xendit.Models.Card;
import com.xendit.Models.Token;
import com.xendit.Models.XenditError;
import com.xendit.TokenCallback;
import com.xendit.Xendit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Radar.initialize(this);

        Xendit xendit = new Xendit(getApplicationContext(), "xnd_public_development_O4iFfuQhgLOsl8M9eeEYGzeWYNH3otV5w3Dh/BFj/mHW+72nCQR/");
        System.out.println("Xendit Class: " + xendit.getClass().toString());
        System.out.println("Xendit isCvnValid: " + xendit.isCvnValid("123"));

        Card card = new Card("4000000000000002", "12", "2017", "123");
        boolean isMultipleUse = true;

        xendit.createToken(card, "75000", isMultipleUse, new TokenCallback() {
            @Override
            public void onSuccess(Token token) {
                System.out.println("Successfully obtained token");
            }

            @Override
            public void onError(XenditError xenditError) {
                System.out.println("An error occurred");
            }
        });
    }
}
