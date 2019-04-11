package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.negi);
    }

    int size = 30;

    public void response(View v){
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.textView);

        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI1 = calculateBMI(height, weight);
        String BMI2 = String.valueOf(BMI1);

        txv.setTextSize(size);
        txv.setText("user: " + ed1.getText().toString() + ",hello" + ".\n" + "your BMI is : " + BMI2);
        Toast.makeText(this,standardBMI(BMI1), Toast.LENGTH_LONG).show();

    }

    public float calculateBMI(float height, float weight){
        float BMI = (float) (weight / Math.pow((height / 100), 2));
        return BMI;
    }

    private String standardBMI(double st){
        String alert = "";

        if (st > 25){
            alert = String.valueOf("你重的跟石頭一樣");
            getWindow().setBackgroundDrawableResource(R.drawable.fat);
        }
        else if (st < 18){
            alert = String.valueOf("你輕的快被風吹走了");
            getWindow().setBackgroundDrawableResource(R.drawable.thin);
        }
        else{
            alert = String.valueOf("你好棒，好棒好棒好棒");
            getWindow().setBackgroundDrawableResource(R.drawable.negi);
        }
        return alert;

    }








}
