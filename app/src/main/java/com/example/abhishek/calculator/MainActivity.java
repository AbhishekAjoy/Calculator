package com.example.abhishek.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button clr;
    private Button back;
    private Button dot;
    private Button open;
    private Button close;
    private Button eq;
    private TextView op;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION= '*';
    private final char DIVISION = '/';
    private final char EQU = '0';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(op.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + '+');
                op.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + '-');
                op.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + '*');
                op.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + '/');
                op.setText(null);
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                op.setText(result.getText().toString() + String.valueOf(val2) + '=');
                result.setText(String.valueOf(val1));

            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.setText(null);
                result.setText(null);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(op.getText().length() > 0){
                   CharSequence name = op.getText().toString();
                   op.setText(name.subSequence(0,name.length()-1));
               }
                else{
                   val1 = Double.NaN;
                   val2 = Double.NaN;
                   op.setText(null);
                   result.setText(null);

               }
            }
        });

    }
    private void setupUIViews(){

        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        div = (Button)findViewById(R.id.btndiv);
        mul = (Button)findViewById(R.id.btnmul);
        clr = (Button)findViewById(R.id.btnC);
        back = (Button)findViewById(R.id.btnback);
        dot = (Button)findViewById(R.id.btndot);
        open = (Button)findViewById(R.id.btnopen);
        close = (Button)findViewById(R.id.btnclose);
        eq = (Button)findViewById(R.id.btneq);
        op = (TextView)findViewById(R.id.tvop);
        result = (TextView)findViewById(R.id.tvresult);

    }

    private void compute(){

        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(op.getText().toString());

            switch (ACTION){
                case ADDITION: val1 = val1 + val2; break;
                case SUBTRACTION: val1 = val1 - val2; break;
                case MULTIPLICATION: val1 = val1 * val2; break;
                case DIVISION: val1 = val1 / val2; break;
                case EQU: val1 = val1 ; break;
            }
        }
        else{
            val1 = Double.parseDouble(op.getText().toString());
        }
    }
}
