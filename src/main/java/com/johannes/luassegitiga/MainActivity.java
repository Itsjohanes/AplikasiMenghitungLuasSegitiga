package com.johannes.luassegitiga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAlas, edtTinggi;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result"; //menampung untuk state result nya

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAlas =findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this); //berada diactivity ini
        if(savedInstanceState != null)
        {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_calculate)
        {
            String inputAlas = edtAlas.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyFields = false;

            if(TextUtils.isEmpty(inputAlas)) //mengecek
            {
                isEmptyFields = true;
                edtAlas.setError("Field alas ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputTinggi))
            {
                isEmptyFields = true;
                edtTinggi.setError("Field Tinggi ini tidak boleh kosong");
            }


            if(!isEmptyFields)
            {
                double volume = Double.valueOf(inputAlas) * Double.valueOf(inputTinggi) * 0.5;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}