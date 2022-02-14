package com.example.a06somewidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chk_Iphone, chk_Android, chk_WindowMobile, chk_Tennis, chk_Running, chk_Swimming, chk_Sleeping, chk_Reading;
    RadioButton Male, Female;
    RatingBar rateBar;

    Spinner spinnerCountry, spinnerUniverse;

    Button btnSubmit, btnClear;
    TextView platformKQ, genderKQ, rateKQ, countryKQ, universeKQ, favoriteKQ;

    String resultPlatform;
    String resultFavourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk_Iphone = findViewById(R.id.chk_Iphone);
        chk_Android = findViewById(R.id.chk_Android);
        chk_WindowMobile = findViewById(R.id.chk_WinDowMobile);

        chk_Tennis = findViewById(R.id.chk_tennis);
        chk_Running = findViewById(R.id.chk_running);
        chk_Swimming = findViewById(R.id.chk_swimming);
        chk_Sleeping = findViewById(R.id.chk_sleeping);
        chk_Reading = findViewById(R.id.chk_reading);

        Male = findViewById(R.id.radio_Male);
        Female = findViewById(R.id.radio_Female);

        rateBar = findViewById(R.id.rate_bar);


        spinnerCountry = findViewById(R.id.spn_Country);
        spinnerUniverse = findViewById(R.id.spn_Universe);

        btnSubmit = findViewById(R.id.btn_submit);
        btnClear = findViewById(R.id.btn_clear);

        platformKQ = findViewById(R.id.txt_platformKQ);
        genderKQ = findViewById(R.id.txt_genderKQ);
        rateKQ = findViewById(R.id.txt_rateKQ);
        countryKQ = findViewById(R.id.txt_countryKQ);
        universeKQ = findViewById(R.id.txt_universeKQ);
        favoriteKQ = findViewById(R.id.txt_favouriteKQ);


        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);


        ArrayAdapter<CharSequence> adapterUniverse = ArrayAdapter.createFromResource(this, R.array.universe_array, android.R.layout.simple_spinner_item);
        adapterUniverse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUniverse.setAdapter(adapterUniverse);


        resultFavourite = "";
        resultPlatform = "";

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPlatform();
                checkGender();

                rateKQ.setText("Rate: " + rateBar.getRating());

                countryKQ.setText("Country: " + spinnerCountry.getSelectedItem().toString());
                universeKQ.setText("My university" + spinnerUniverse.getSelectedItem().toString());


                checkFavourite();


                chk_Iphone.setChecked(false);
                chk_Android.setChecked(false);
                chk_WindowMobile.setChecked(false);

                Male.setChecked(false);
                Female.setChecked(false);

                rateBar.setRating(0);

                spinnerUniverse.setSelection(0);
                spinnerCountry.setSelection(0);

                chk_Tennis.setChecked(false);
                chk_Running.setChecked(false);
                chk_Swimming.setChecked(false);
                chk_Sleeping.setChecked(false);
                chk_Reading.setChecked(false);

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultPlatform = "";
                resultFavourite = "";
                chk_Iphone.setChecked(false);
                chk_Android.setChecked(false);
                chk_WindowMobile.setChecked(false);

                Male.setChecked(false);
                Female.setChecked(false);

                rateBar.setRating(0);

                spinnerUniverse.setSelection(0);
                spinnerCountry.setSelection(0);

                chk_Tennis.setChecked(false);
                chk_Running.setChecked(false);
                chk_Swimming.setChecked(false);
                chk_Sleeping.setChecked(false);
                chk_Reading.setChecked(false);


                platformKQ.setText("Platform: ");
                genderKQ.setText("Gender: ");
                rateKQ.setText("Rate: ");
                countryKQ.setText("Country: ");
                universeKQ.setText("My university: ");
                favoriteKQ.setText("My favourite: ");
            }
        });

    }

    private void checkPlatform(){
        if(chk_Iphone.isChecked() ) {
            resultPlatform += "IPhone, ";
        }
        if (chk_Android.isChecked()) {
            resultPlatform += "Android, ";
        }
        if (chk_WindowMobile.isChecked()) {
            resultPlatform += "Window Mobile, ";
        }

        platformKQ.append(resultPlatform);
    }

    private void checkGender(){
        if(Male.isChecked()) {
            genderKQ.setText("Gender: " + Male.getText());
        }
        if(Female.isChecked()) {
            genderKQ.setText("Gender: " + Female.getText());
        }
    }

    private void checkFavourite(){
        if(chk_Tennis.isChecked()){
            resultFavourite += "Tennis, ";
        }
        if(chk_Running.isChecked()){
            resultFavourite += "Running, ";
        }
        if(chk_Swimming.isChecked()){
            resultFavourite += "Swimming, ";
        }
        if(chk_Sleeping.isChecked()){
            resultFavourite += "Sleeping, ";
        }
        if(chk_Reading.isChecked()){
            resultFavourite += "Reading, ";
        }
        favoriteKQ.append(resultFavourite);
    }
}