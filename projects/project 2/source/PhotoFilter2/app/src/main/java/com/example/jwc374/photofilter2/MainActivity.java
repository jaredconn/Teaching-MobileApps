package com.example.jwc374.photofilter2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;


    int REQUEST_CODE = 1;
    ImageView IMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        IMG = (ImageView) findViewById(R.id.img);

//choose existing from gallery
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


//take a new photo
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) //check if camera application is available on device
                {
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE || requestCode == 0) {
            if (resultCode == RESULT_OK) //operation was successful
            {
                if (requestCode == 0) //then we're choosing from gallery
                {
                    Uri targetUri = data.getData();
                    Bitmap bitmap;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                        IMG.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (requestCode == 1) //then we're taking a new photo
                {
                    Bitmap BMP = (Bitmap) data.getExtras().get("data");
                    IMG.setImageBitmap(BMP);
                    /*
                    Bundle bundle = new Bundle();
                    bundle = data.getExtras();
                    Bitmap BMP;
                    BMP = (Bitmap) bundle.get("data");
                    IMG.setImageBitmap(BMP);
                    */
                }
            }
        }
    }
}
/*
                /*float aspectRatio = BMP.getWidth() /
                        (float) BMP.getHeight();
                int width = 480;
                int height = Math.round(width / aspectRatio);

                BMP = Bitmap.createScaledBitmap(
                        BMP, width, height, true);
                /////
                BMP.setDensity(500);
                int maxHeight = 2000;
                int maxWidth = 2000;
                float scale = Math.min(((float)maxHeight / BMP.getWidth()), ((float)maxWidth / BMP.getHeight()));

                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);

                BMP = Bitmap.createBitmap(BMP, 0, 0, BMP.getWidth(), BMP.getHeight(), matrix, true);

                     IMG.setImageBitmap(BMP);
                }
            }
        }
    }
}
*/


