package com.example.sizzlingbites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Introductory extends AppCompatActivity {

    ImageView logo, appName, splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo = findViewById(R.id.splash_img_2);
        appName = findViewById(R.id.splash_name);
        splashImg = findViewById(R.id.splash_img);
        lottieAnimationView = findViewById(R.id.splash_animation);

        splashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }
}
