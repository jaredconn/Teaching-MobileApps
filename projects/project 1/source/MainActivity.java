package com.example.j.postfixcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

import static android.view.Window.FEATURE_NO_TITLE;

public class MainActivity extends AppCompatActivity {


    private EditText capturedText;
    private TextView outputText;
    private int testResult;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPlus;
    private Button btnSubt;
    private Button btnDivd;
    private Button btnSpace;
    private Button btnMult;
    private Button btnDel;
    private Button btnAc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.requestWindowFeature(FEATURE_NO_TITLE); //turn off the title

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //Remove notification bar
        setContentView(R.layout.activity_main);

        capturedText = (EditText) findViewById(R.id.calculator);
        outputText = (TextView) findViewById(R.id.result);

        // only if you completely want to disable keyboard for
        // that particular edit text
        capturedText = (EditText) findViewById(R.id.calculator);
        capturedText.setInputType(InputType.TYPE_NULL);

        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("0");
            }
        });
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("1");
            }
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("2");
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("3");
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("4");
            }
        });
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("5");
            }
        });
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("6");
            }
        });
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("7");
            }
        });
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("8");
            }
        });
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("9");
            }
        });
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("+");
            }
        });
        btnSubt = (Button) findViewById(R.id.btn_);
        btnSubt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("-");
            }
        });
        btnDivd = (Button) findViewById(R.id.btnDivd);
        btnDivd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("/");
            }
        });
        btnMult = (Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                capturedText.append("*");
            }
        });
        btnSpace = (Button) findViewById(R.id.btnSpace);
        btnSpace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String input = capturedText.getText().toString();

                if(input.length() >= 1)
                {
                   // capturedText.append(" "); //only append space if prev space wasn't a space
                    input = input.substring(0, input.length() - 1);
                    if(!input.equals(" ")){
                        capturedText.append(" "); //only append space if prev space wasn't a space
                    }
                }
            }
        });
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = capturedText.getText().toString();
                if(input.length() >=1){
                    input = input.substring(0, input.length() - 1);
                    capturedText.setText(input);
                }
             }
        });
        btnAc = (Button) findViewById(R.id.btnAc);
        btnAc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    capturedText.setText("");
                    outputText.setText("");
                }
            });
    }


    @SuppressLint("SetTextI18n")
    public void onClick (View view){

        String input = capturedText.getText().toString();

        Scanner scan = new Scanner(input);

        int[] theInput = new int[capturedText.length()];

        scan.useDelimiter(" ");

        int i = 0;

        while (scan.hasNext()) {
            //if given 3 5 +, this code should take the a[0] = 3, a[1] = 5
            //and then calculate the result = 8

            String temp = scan.next();

            //regex -?  --> negative sign, could have none or one
            //regex \\d+ --> one or more digits
            if (temp.matches("-?\\d+")) {
                theInput[i] = Integer.parseInt(temp); //if input is a number then place it in the array
                i++;
            }
            //check for operators
            if (temp.equals("+")) {
                theInput[i - 2] = theInput[i - 2] + theInput[i - 1]; //calculate from two spaces previous the operator
                testResult = theInput[i - 2];
                i--;
            }
            if (temp.equals("-")) {
                theInput[i - 2] = theInput[i - 2] - theInput[i - 1];
                testResult = theInput[i - 2];
                i--;
            }
            if (temp.equals("*")) {
                theInput[i - 2] = theInput[i - 2] * theInput[i - 1];
                testResult = theInput[i - 2];
                i--;
            }
            if (temp.equals("/")) {
                theInput[i - 2] = theInput[i - 2] / theInput[i - 1];
                testResult = theInput[i - 2];
                i--;
            }
        }
        outputText.setText(Integer.toString(testResult));
    }
}



