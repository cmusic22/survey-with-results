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
    private static final String EXTRA_PIZZA_TACO_COUNT = "com.carson.android.survey.pizza__taco_count";
    private static final String EXTRA_TACO_COUNT = "com.carson.android.survey.taco_count";



    Button mResetButton;
    Button mContinueButton;
    TextView mPizzaCount;
    TextView mTacoCount;

    public static Intent newIntent(Context packageContext, int pizza, int taco){
        Intent intent = new Intent(packageContext, ResultsActivity.class);
        intent.putExtra(EXTRA_PIZZA_TACO_COUNT, pizza, taco);
        return intent;
    }

    int pizzaCount = getIntent().getIntExtra(EXTRA_PIZZA_TACO_COUNT, pizza);
    int tacoCount = getIntent().getIntExtra(EXTRA_PIZZA_TACO_COUNT, taco);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //set results for pizza and tacos
        String pizzaString = String.valueOf(pizzaCount);
        mPizzaCount.setText(pizzaString);

        String tacoString = String.valueOf(tacoCount);
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
                int pizza = 0;
                String pizzaString = String.valueOf(pizza);
                mPizzaCount.setText(pizzaString);
                int taco = 0;
                String tacoString = String.valueOf(taco);
                mTacoCount.setText(tacoString);
            }

            //function to send strings to results_activity

        });

        //continue button function
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bring back to MainActivity.java
            }
        });
    }
}
