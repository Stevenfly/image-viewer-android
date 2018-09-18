package com.example.y467yang.fotagy467yang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mImageView = findViewById(R.id.display_image);
        mImageView.setImageResource(getIntent().getIntExtra("img", 0));

        mFrameLayout = findViewById(R.id.display_frame);
        mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
