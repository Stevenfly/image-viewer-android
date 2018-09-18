package com.example.y467yang.fotagy467yang;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public FrameLayout mCardFrame;

    public CardView mCardView;
    public ImageView mImageView;

    public ImageButton mImageButton1;
    public ImageButton mImageButton2;
    public ImageButton mImageButton3;
    public ImageButton mImageButton4;
    public ImageButton mImageButton5;

    public ImageButton mClearButton;

    public CardViewHolder(View view) {
        super(view);

        mCardFrame = (FrameLayout) view;
        mCardView = view.findViewById(R.id.card_view);

        // TODO: deal with large image?
        mImageView = mCardView.findViewById(R.id.card_image_view);

        mImageButton1 = mCardView.findViewById(R.id.imageButton1);
        mImageButton2 = mCardView.findViewById(R.id.imageButton2);
        mImageButton3 = mCardView.findViewById(R.id.imageButton3);
        mImageButton4 = mCardView.findViewById(R.id.imageButton4);
        mImageButton5 = mCardView.findViewById(R.id.imageButton5);

        mClearButton = mCardView.findViewById(R.id.card_button_clear);
    }

    public void setStarRating(int rating) {
        mImageButton1.setImageResource(R.drawable.ic_action_star_border);
        mImageButton2.setImageResource(R.drawable.ic_action_star_border);
        mImageButton3.setImageResource(R.drawable.ic_action_star_border);
        mImageButton4.setImageResource(R.drawable.ic_action_star_border);
        mImageButton5.setImageResource(R.drawable.ic_action_star_border);

        if (rating > 0) {
            mImageButton1.setImageResource(R.drawable.ic_action_star);
        }

        if (rating > 1) {
            mImageButton2.setImageResource(R.drawable.ic_action_star);
        }

        if (rating > 2) {
            mImageButton3.setImageResource(R.drawable.ic_action_star);
        }

        if (rating > 3) {
            mImageButton4.setImageResource(R.drawable.ic_action_star);
        }

        if (rating > 4) {
            mImageButton5.setImageResource(R.drawable.ic_action_star);
        }
    }
}
