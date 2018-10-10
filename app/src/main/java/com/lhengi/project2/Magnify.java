package com.lhengi.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;

public class Magnify extends AppCompatActivity
{
    private String url;
    private int imgResource;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        imgResource = intent.getIntExtra("imgResource",0);

        ImageView imageView = new ImageView(getApplicationContext());

        imageView.setImageResource(imgResource);

        imageView.setOnClickListener(listener);

        setContentView(imageView);


    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent browersInt = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browersInt);
        }
    };

}
