package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText_Purchase;
    private EditText editText_DownPayment;
    private EditText editText_InterestRate;
    private SeekBar YearsBar;
    private TextView ViewYears;
    private TextView TotalDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_Purchase = findViewById(R.id.editText_Purchase);
        editText_DownPayment = findViewById(R.id.editText_DownPayment);
        editText_InterestRate = findViewById(R.id.editText_InterestRate);
        YearsBar = findViewById(R.id.seekBar);
        ViewYears = findViewById(R.id.textViewYears);
        TotalDisplay = findViewById(R.id.TotalDisplay);

        Mortgage_Calculator();
    }

    public void Mortgage_Calculator() {

        YearsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String PurchasePrice = editText_Purchase.getText().toString();
                String DownPayment = editText_DownPayment.getText().toString();
                String InterestRate = editText_InterestRate.getText().toString();
                seekBar.setMax(3);

                ViewYears.setText(String.valueOf(progress * 10));

                double loan = Integer.valueOf(PurchasePrice) - Integer.valueOf(DownPayment);
                double Number_Of_Months = ((progress*10) * 12);
                double Mortgage = (((loan * Double.valueOf(InterestRate)) + (loan))/(Number_Of_Months));

                TotalDisplay.setText("$ " + Mortgage);

                if (progress == 0) {
                    TotalDisplay.setText("$ " + 0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
