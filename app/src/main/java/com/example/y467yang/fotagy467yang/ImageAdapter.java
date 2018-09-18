package com.example.y467yang.fotagy467yang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private Context context;

    private ArrayList<ImageModel> mDataset;
    private int mFilterRating;

    public ImageAdapter(Context context, ArrayList<ImageModel> ImageSet) {
        this.context = context;
        this.mDataset = ImageSet;
        this.mFilterRating = 0;
    }

    public int getFilterRating() {
        return mFilterRating;
    }

    public void setFilterRating(int filterRating) {
        this.mFilterRating = filterRating;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        FrameLayout view = (FrameLayout) inflater.inflate(R.layout.card_layout, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        int mDrawable = mDataset.get(position).getDrawable();
        int mRating = mDataset.get(position).getRating();

        if (mFilterRating > mRating) {
            holder.mCardFrame.setVisibility(View.GONE);
            holder.mCardView.setVisibility(View.GONE);
        } else {
            holder.mCardFrame.setVisibility(View.VISIBLE);
            holder.mCardView.setVisibility(View.VISIBLE);

            holder.mImageView.setImageResource(mDrawable);
            holder.setStarRating(mRating);

            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("img", mDataset.get(holder.getAdapterPosition()).getDrawable());
                    context.startActivity(intent);
                }
            });

            holder.mImageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(1);
                    holder.setStarRating(1);
                }
            });

            holder.mImageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(2);
                    holder.setStarRating(2);
                }
            });

            holder.mImageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(3);
                    holder.setStarRating(3);
                }
            });

            holder.mImageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(4);
                    holder.setStarRating(4);
                }
            });

            holder.mImageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(5);
                    holder.setStarRating(5);
                }
            });

            holder.mClearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataset.get(holder.getAdapterPosition()).setRating(0);
                    holder.setStarRating(0);
                    if (mFilterRating > 0) {
                        holder.mCardFrame.setVisibility(View.GONE);
                        holder.mCardView.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
