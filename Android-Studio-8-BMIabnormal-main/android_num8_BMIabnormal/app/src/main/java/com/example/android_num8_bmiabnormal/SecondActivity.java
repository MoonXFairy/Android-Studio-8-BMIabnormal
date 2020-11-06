package com.example.android_num8_bmiabnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bmi_Answer();
    }
    public void back_pageA(View v)  //返回
    {
        finish();
    }
    private void bmi_Answer()
    {
        Bundle bundle = this.getIntent().getExtras();
        double height;
        double weight;
        double bmi;
        if (bundle != null)
        {
            DecimalFormat nf = new DecimalFormat("0.00");
            height = Double.parseDouble(bundle.getString("Height")) / 100;
            weight = Double.parseDouble(bundle.getString("Weight"));
            bmi = weight / (height * height);
            TextView bmitit = (TextView)findViewById(R.id.BMI_value);
            bmitit.setText(nf.format(bmi));
            TextView abnormal = (TextView)findViewById(R.id.Ans);
            if (bmi < 18)
            {
                abnormal.setText("異常-體重過輕");
            }
            else if (bmi > 24)
            {
                abnormal.setText("異常-體重過重");
            }
            else
                abnormal.setText("正常-體重正常");
        }
    }
}