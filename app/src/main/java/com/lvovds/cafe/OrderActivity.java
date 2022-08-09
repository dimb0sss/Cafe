package com.lvovds.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private static final String EXTRA_USERNAME = "name";

    private TextView textViewGreetings;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;
    private RadioGroup radioGroupDrinks;


    private CheckBox checkBoxLemon;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSugar;
    private TextView textViewAdditives;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;
    private Button buttonDoOrder;

    private String name;
    private String drink;
    private String additives;
    private String drinkType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initViews();

        setupUserName();



        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id==radioButtonTea.getId()) {
                    onUserChoseTea();
                }  else {
                    onUserChoseCoffee();
                }
            }
        });

        radioButtonTea.setChecked(true);



//        textViewAdditives.setText(String.format(getString(R.string.additives),));


        buttonDoOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> additivesArray = new ArrayList<>();
                if (checkBoxSugar.isChecked()) {
                  additivesArray.add(checkBoxSugar.getText().toString());
                }
                if (checkBoxMilk.isChecked()) {
                    additivesArray.add(checkBoxMilk.getText().toString());
                }
                if (radioButtonTea.isChecked() &&  checkBoxLemon.isChecked()) {
                    additivesArray.add(checkBoxLemon.getText().toString());
                }

                if (radioButtonTea.isChecked()) {
                    drinkType = spinnerTea.getSelectedItem().toString();
                } else if (radioButtonCoffee.isChecked()) {
                    drinkType = spinnerCoffee.getSelectedItem().toString();
                }

                additives=additivesArray.toString();

                Intent intent = OrderDetailActivity.newIntent(OrderActivity.this, name, drink, additives, drinkType);
                startActivity(intent);
            }
        });


    }

    private void onUserChoseCoffee() {
        drink = getString(R.string.Coffee);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        textViewAdditives.setText(getString(R.string.additives, drink));
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);

    }

    private void onUserChoseTea() {
        drink = getString(R.string.tea);
        checkBoxLemon.setVisibility(View.VISIBLE);
        textViewAdditives.setText(getString(R.string.additives,drink));
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);

    }

    private void setupUserName() {
        name = getIntent().getStringExtra(EXTRA_USERNAME);
        textViewGreetings.setText(getString(R.string.greetings, name));
    }

    private void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        buttonDoOrder = findViewById(R.id.buttonDoOrder);
    }


    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, OrderActivity.class);
        intent.putExtra(EXTRA_USERNAME, name);
        return (intent);
    }
}