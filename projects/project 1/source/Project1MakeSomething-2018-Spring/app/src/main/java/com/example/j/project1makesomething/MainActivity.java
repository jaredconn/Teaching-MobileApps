package com.example.j.project1makesomething;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

   private EditText capturedText;
   private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capturedText = (EditText)findViewById(R.id.calculator);
        outputText = (TextView)findViewById(R.id.result);

    }

    public void onClick(View view) {
//after the button click, i grabbed the input box text and output it to the result box
      ((Button) view).setText("clicked");
      outputText.setText(capturedText.getText());
    }
}


