package com.example.jwc374.photofilter2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class EditChosenPhoto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chosen_photo);

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ImageView IMG;
        IMG = (ImageView) findViewById(R.id.img);
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        File imageFile = new File(path);
        Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file


        Button green;
        green = (Button) findViewById(R.id.green);
        Button rotate;
        rotate = (Button) findViewById(R.id.rotate);
        Button save;
        save = (Button) findViewById(R.id.save);
        Button blue;
        blue = (Button) findViewById(R.id.blue);
        Button red;
        red = (Button) findViewById(R.id.red);
        Button cyan;
        cyan = (Button) findViewById(R.id.cyan);
        Button yellow;
        yellow = (Button) findViewById(R.id.yellow);
        Button magenta;
        magenta = (Button) findViewById(R.id.magenta);

        Button white;
        white = (Button) findViewById(R.id.white);
        Button gray;
        gray = (Button) findViewById(R.id.gray);





        final Context context = getApplicationContext();
        CharSequence text = "Edit your photo!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        if (imageFile.exists()) {
            IMG.setImageBitmap(myBitmap);
        }

        rotate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                IMG.setRotation(IMG.getRotation() + 90);
            }
        });
        blue.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeBlue(myBitmap));

            }
        });
        green.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeGreen(myBitmap));

            }
        });
        red.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeRed(myBitmap));

            }
        });
        cyan.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeCyan(myBitmap));
            }
        });
        yellow.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeYellow(myBitmap));
            }
        });
        magenta.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeMagenta(myBitmap));
            }
        });
        white.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeWhite(myBitmap));
            }
        });
        gray.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);
                Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
                IMG.setImageBitmap(ImageFix.makeGray(myBitmap));
            }
        });


        rotate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                IMG.setRotation(IMG.getRotation() + 90);
            }
        });

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                ImageView IMG;
                IMG = (ImageView) findViewById(R.id.img);
                Intent intent = getIntent();
               //get the path of the image
                String path = intent.getStringExtra("path");
                File imageFile = new File(path);

                //the current image
                IMG.buildDrawingCache();
                Bitmap myBitmap =  IMG.getDrawingCache();

                //save the image there
                File newFile = new File(path);
                try {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.close();
                    scanFile(context, Uri.fromFile(newFile));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void scanFile(Context context, Uri uri) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(uri);
        context.sendBroadcast(scanIntent);

    }
}












