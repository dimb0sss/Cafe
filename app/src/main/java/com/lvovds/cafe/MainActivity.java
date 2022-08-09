package com.lvovds.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextName.getText().toString().trim().isEmpty() || editTextPassword.getText().toString().trim().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.error_string_empty, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    launchNextScreen(editTextName.getText().toString());
                }
            }
        });
    }

    private void launchNextScreen(String name) {
        Intent intent = OrderActivity.newIntent(this,name);
        startActivity(intent);
    }

    private void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSign = findViewById(R.id.buttonSign);
    }
}