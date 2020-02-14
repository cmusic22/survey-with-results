package com.carson.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultsActivity extends AppCompatActivity {

    //Need Keys to pass information
    public static final String EXTRA_PIZZA_COUNT = "com.carson.android.survey.pizza_count";
    public static final String EXTRA_TACO_COUNT = "com.carson.android.survey.taco_count";

    public static final String EXTRA_RESET_COUNT = "com.carson.android.survey.reset_survey";




    Button mResetButton;
    Button mContinueButton;
    TextView mPizzaCount;
    TextView mTacoCount;

    String tacoString = getIntent().getStringExtra(EXTRA_TACO_COUNT);
    String pizzaString = getIntent().getStringExtra(EXTRA_PIZZA_COUNT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_results);

        //set results for pizza and tacos

        mPizzaCount.setText(pizzaString);


        mTacoCount.setText(tacoString);

        //Target visual elements
        mResetButton = findViewById(R.id.reset_button);
        mContinueButton = findViewById(R.id.continue_button);
        mPizzaCount = findViewById(R.id.pizza_count);
        mTacoCount = findViewById(R.id.taco_count);




        //reset button function
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResetButton(true);
            }

        });

        //continue button function
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bring back to MainActivity.java
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_PIZZA_COUNT, pizzaString);
                returnIntent.putExtra(EXTRA_TACO_COUNT, tacoString);
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });
    }

    private void setResetButton(boolean reset) {
        Intent data = new Intent();
        data.putExtra(EXTRA_RESET_COUNT, reset);
        setResult(RESULT_OK, data);
    }
}
