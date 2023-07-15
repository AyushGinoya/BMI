package com.example.bmi;
    
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt_wt;
    private EditText edt_htf;
    private EditText edt_hti;
    private Button btnRes;
    private Button btnReset;
    private TextView res;
    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_wt = findViewById(R.id.etWeight);
        edt_htf = findViewById(R.id.etHeightFt);
        edt_hti = findViewById(R.id.etHeightIh);
        btnRes = findViewById(R.id.btnRes);
        btnReset = findViewById(R.id.btnReset);
        res = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnRes.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        calculateBmi();

                    }
                }
        );

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetField();
            }
        });
    }
    private void calculateBmi(){
        int wt = Integer.parseInt(edt_wt.getText().toString());
        int htf = Integer.parseInt(edt_htf.getText().toString());
        int hti = Integer.parseInt(edt_hti.getText().toString());

        int total_In = htf*12 + hti;

        double total_Cm = total_In*2.53;

        double total_Mt= total_Cm/100;

        double bmi = wt/(total_Mt*total_Mt);

        if(bmi > 25){
            res.setText("You are Over Weight");
            llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.wt_ow));
        } else if( bmi < 18){
            res.setText("You are Under Weight");
            llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.wt_uw));
        } else {
            res.setText("You are Healthy");
            llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.wt_hty));
        }
    }

    private void resetField() {
        edt_htf.setText("");
        edt_hti.setText("");
        edt_wt.setText("");
        llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
    }
}