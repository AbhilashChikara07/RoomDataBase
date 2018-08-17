package com.example.chikara.downloadandsaveimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        ((Button) findViewById(R.id.downloadImage)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bitmap = BitmapFactory.decodeResource(getResources(),
                                R.drawable.ic_launcher_round);
                        saveImage();
                    }
                });

    }


    private void saveImage() {
        File file;
        String path = Environment.getExternalStorageDirectory().toString();
        file = new File(path, "UniqueFileName" + ".jpg");

        try {
            OutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Parse the saved image path to uri
//        Uri savedImageURI = Uri.parse(folderPath.getAbsolutePath());
//        Glide.with(MainActivity.this)
//                .load(savedImageURI).into(imageView);

    }

}
