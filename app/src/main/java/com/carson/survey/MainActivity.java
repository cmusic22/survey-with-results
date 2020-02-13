package com.carson.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_RESULTS = 0;

    Button mPizzaButton;
    Button mTacoButton;
    TextView mPizzaCount;
    TextView mTacoCount;
    Button mResetButton;
    Button mResultsButton;


    int pizza = 0;
    int taco = 0;

    private static final String SURVEY_KEY_PIZZA = "survey-bundle-key-pizza";
    private static final String SURVEY_KEY_TACO = "survey-bundle-key-toco";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPizzaButton = findViewById(R.id.pizza_button);
        mTacoButton = findViewById(R.id.taco_button);
        mPizzaCount = findViewById(R.id.pizza_count);
        mTacoCount = findViewById(R.id.taco_count);
        mResetButton = findViewById(R.id.reset_button);
        mResetButton = findViewById(R.id.results_button);
        //save instance state --- need to finish
        if (savedInstanceState != null){
            pizza = savedInstanceState.getInt(SURVEY_KEY_PIZZA, 0);
            taco = savedInstanceState.getInt(SURVEY_KEY_TACO, 0);
        }

        if (pizza == 0 & taco == 0){
            taco = 0;
            pizza = 0;
            String pizzaString = String.valueOf(pizza);
            mPizzaCount.setText(pizzaString);
            String tacoString = String.valueOf(taco);
            mTacoCount.setText(tacoString);
        }

        //pizza button click listener includes pizza count
        mPizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pizza++;
                String pizzaString = String.valueOf(pizza);
                mPizzaCount.setText(pizzaString);

            }
        });
        //taco button click listener includes taco count
        mTacoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                taco++;
                String tacoString = String.valueOf(taco);
                mTacoCount.setText(tacoString);
            }
        });
        //clear button
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pizza = 0;
                String pizzaString = String.valueOf(pizza);
                mPizzaCount.setText(pizzaString);
                int taco = 0;
                String tacoString = String.valueOf(taco);
                mTacoCount.setText(tacoString);
            }

            //function to send strings to results_activity

        });

        mResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ResultsActivity.newIntent(MainActivity.this, pizza, taco);
                startActivityForResult(intent, REQUEST_CODE_RESULTS);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outBundle) {
        super.onSaveInstanceState(outBundle);
        outBundle.putInt(SURVEY_KEY_PIZZA, pizza);
        outBundle.putInt(SURVEY_KEY_TACO, taco);
    }
}
