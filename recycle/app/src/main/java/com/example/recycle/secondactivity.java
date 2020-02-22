package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class secondactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        TextView text1 = (TextView) findViewById(R.id.wor1);
        TextView text2 = (TextView) findViewById(R.id.wor2);
        TextView text3 = (TextView) findViewById(R.id.wor3);
        ImageView image = (ImageView) findViewById(R.id.imag);


        Drawable drawable = ContextCompat.getDrawable(this, getIntent().getIntExtra("imagekey", 0));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);
        if (drawable != null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        text1.setText(getIntent().getStringExtra("title"));
        text2.setText(getIntent().getStringExtra("category"));
        text3.setText(getIntent().getStringExtra("text"));
        Glide.with(this).load(getIntent().getIntExtra("imagekey", 0)).placeholder(gradientDrawable).into(image);

    }
}
