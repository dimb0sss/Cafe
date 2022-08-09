package com.lvovds.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "name";
    public static final String EXTRA_DRINK = "drink";
    public static final String EXTRA_ADDITIVES = "additives";
    public static final String EXTRA_DRINK_TYPE = "drinkType";
    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewAdditives;
    private TextView textViewDrinkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initViews();
        showOrderDetail();
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
    }

    private void showOrderDetail() {
        textViewName.setText(getIntent().getStringExtra(EXTRA_USER_NAME));
        textViewDrink.setText(getIntent().getStringExtra(EXTRA_DRINK));
        textViewAdditives.setText(getIntent().getStringExtra(EXTRA_ADDITIVES));
        textViewDrinkType.setText(getIntent().getStringExtra(EXTRA_DRINK_TYPE));
    }

    public static Intent newIntent(Context context, String name, String drink, String additives, String drinkType) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("drink", drink);
        intent.putExtra("additives", additives);
        intent.putExtra("drinkType", drinkType);
        return (intent);
    }
}