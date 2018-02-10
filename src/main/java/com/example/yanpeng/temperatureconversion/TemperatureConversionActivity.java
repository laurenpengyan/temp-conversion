package com.example.yanpeng.temperatureconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

/*
* Author: Yan Peng
* Class: CS211D
* Professor: Abbas Moghtanei
* Date: 02/09/2018
* */

public class TemperatureConversionActivity extends AppCompatActivity {
    private static final String TAG = TemperatureConversionActivity.class.getSimpleName();

    private RadioButton fahrenheitButton;
    private RadioButton celsiusButton;
    private EditText temperatureEditText;
    private TextView resultView;
    private Button convertButton;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_conversion);
        fahrenheitButton = findViewById(R.id.radio_fahrenheit);
        celsiusButton = findViewById(R.id.radio_celsius);
        temperatureEditText = findViewById(R.id.temperature_edit_text);
        temperatureEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER) {
                    String temperatureString = temperatureEditText.getText().toString();
                    Double temperature = Double.valueOf(temperatureString);
                    DecimalFormat df = new DecimalFormat("#.0");
                    if (fahrenheitButton.isChecked()){
                        temperature = ((temperature - 32) * 5) / 9;
                        final String resultString = df.format(temperature) + "°\n\nIn fahrenheit to celsius";
                        resultView.setText(resultString);
                    } else {
                        temperature = (temperature * 1.8) + 32;
                        final String resultString = df.format(temperature) + "°\n\nIn celsius to fahrenheit";
                        resultView.setText(resultString);
                    }
                }
                return false;
            }
        });
        resultView = findViewById(R.id.conversation_view);
        convertButton = findViewById(R.id.convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temperatureString = temperatureEditText.getText().toString();
                Double temperature = Double.valueOf(temperatureString);
                DecimalFormat df = new DecimalFormat("#.0");
                if (fahrenheitButton.isChecked()){
                    temperature = ((temperature - 32) * 5) / 9;
                    final String resultString = df.format(temperature) + "°\n\nIn fahrenheit to celsius";;
                    resultView.setText(resultString);
                } else {
                    temperature = (temperature * 1.8) + 32;
                    final String resultString = df.format(temperature) + "°\n\nIn celsius to fahrenheit";
                    resultView.setText(resultString);
                }
            }
        });

    }
}
