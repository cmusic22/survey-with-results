package com.carson.survey;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
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



    int taco, pizza;
    Boolean reset = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        taco = intent.getIntExtra(EXTRA_TACO_COUNT, 0);
        pizza = intent.getIntExtra(EXTRA_PIZZA_COUNT, 0);

        //Target visual elements
        mResetButton = findViewById(R.id.reset_button);
        mContinueButton = findViewById(R.id.continue_button);
        mPizzaCount = findViewById(R.id.pizza_count);
        mTacoCount = findViewById(R.id.taco_count);

        //set results for pizza and tacos
        String pizzaString = String.valueOf(pizza);
        mPizzaCount.setText(pizzaString);
        String tacoString = String.valueOf(taco);
        mTacoCount.setText(tacoString);

        //reset button function
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pizza = 0;
                taco = 0;
                String pizzaString = String.valueOf(pizza);
                mPizzaCount.setText(pizzaString);
                String tacoString = String.valueOf(taco);
                mTacoCount.setText(tacoString);
                reset = Boolean.TRUE;


            }

        });

        //continue button function
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bring back to MainActivity.java
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_PIZZA_COUNT, pizza);
                returnIntent.putExtra(EXTRA_TACO_COUNT, taco);
                returnIntent.putExtra(EXTRA_RESET_COUNT, reset);
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });
    }


}
