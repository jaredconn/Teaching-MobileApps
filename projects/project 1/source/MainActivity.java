package com.example.j.project1makesomething;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    private EditText capturedText;
    private TextView outputText;
    private int testResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capturedText = (EditText) findViewById(R.id.calculator);
        outputText = (TextView) findViewById(R.id.result);
    }

    @SuppressLint("SetTextI18n")
        public void onClick (View view){

        Stack stack = new Stack();

        String input = capturedText.getText().toString();

        Scanner scan = new Scanner(input);

        int[] theInput = new int[capturedText.length()];
        int[] results = new int[capturedText.length()];
        String[] operators = new String[capturedText.length()];

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


      /*
                Toast.makeText(
                        MainActivity.this,
                        "made it here",
                        Toast.LENGTH_SHORT
                ).show();
                */