package com.example.jwc374.photofilter2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    int REQUEST_CODE = 1;
    ImageView IMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        IMG = (ImageView) findViewById(R.id.img);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(cameraIntent.resolveActivity(getPackageManager())!= null) //check if camera application is available on device
                {
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle bundle = new Bundle();
                bundle = data.getExtras();
                Bitmap BMP;
                BMP = (Bitmap) bundle.get("data");
                IMG.setImageBitmap(BMP);
            }
        }
    }
}