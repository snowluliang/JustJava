package com.snow.justjava;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button minus_Btn,create_Btn,pay_Btn;
    private TextView showNum_Tv,showPrice_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just);
        initView();
    }

    private void initView() {
        create_Btn = (Button) findViewById(R.id.btn_create);
        minus_Btn = (Button) findViewById(R.id.btn_minus);
        pay_Btn = (Button) findViewById(R.id.btn_pay);

        showNum_Tv = (TextView) findViewById(R.id.tv_getNum);
        showPrice_tv = (TextView) findViewById(R.id.tv_getPrice);

        create_Btn.setOnClickListener(this);
        minus_Btn.setOnClickListener(this);
        pay_Btn.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_create:
                createNum();
                break;
            case R.id.btn_minus:
                minusNum();
                break;
            case R.id.btn_pay:
                pay();
                break;
        }
    }

    private void pay() {
        Intent intent = new Intent(this,PayActivity.class);
        startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createNum() {
        String num = showNum_Tv.getText().toString();
        int i = Integer.parseInt(num);
        i = i + 1;
        showNum_Tv.setText(String.valueOf(i));
        showPrice_tv.setText(NumberFormat.getCurrencyInstance().format(i*8));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void minusNum() {
        String curNum = showNum_Tv.getText().toString();
        int i = Integer.parseInt(curNum);
        i = i - 1;
        if (i <= -1) {
            return;
        }
        showNum_Tv.setText(String.valueOf(i));
        showPrice_tv.setText(NumberFormat.getCurrencyInstance().format(i*8));

    }
}
