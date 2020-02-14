package com.carson.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.carson.survey.ResultsActivity.EXTRA_PIZZA_COUNT;
import static com.carson.survey.ResultsActivity.EXTRA_TACO_COUNT;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_RESULTS = 0;


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
                String pizzaString = String.valueOf(pizza);
                String tacoString = String.valueOf(taco);
                Intent resultsIntent = new Intent (MainActivity.this, ResultsActivity.class);
                resultsIntent.putExtra(EXTRA_PIZZA_COUNT, pizzaString);
                resultsIntent.putExtra(EXTRA_TACO_COUNT, tacoString);
                startActivityForResult(resultsIntent, REQUEST_CODE_RESULTS);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outBundle) {
        super.onSaveInstanceState(outBundle);
        outBundle.putInt(SURVEY_KEY_PIZZA, pizza);
        outBundle.putInt(SURVEY_KEY_TACO, taco);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Boolean reset = data.getBooleanExtra(EXTRA_RESET_COUNT);
        if (requestCode == REQUEST_CODE_RESULTS && resultCode == RESULT_OK){
            String countOfPizza = data.getStringExtra(EXTRA_PIZZA_COUNT);
            String countOfTaco = data.getStringExtra(EXTRA_TACO_COUNT);



            mTacoCount.setText(countOfTaco);
            mPizzaCount.setText(countOfPizza);

        }

        if(requestCode == REQUEST_CODE_RESULTS && resultCode == RESULT_CANCELED){
            //put a result
        }
    }


}
