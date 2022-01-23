package com.example.appcasasoniada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;
    private ImageView imgLogo;
    private TextView slogan;
    private static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Animations
        topAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_animation);

        // Hooks
        imgLogo = findViewById(R.id.imgLogo_white);
        slogan = findViewById(R.id.slogan);

        imgLogo.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}