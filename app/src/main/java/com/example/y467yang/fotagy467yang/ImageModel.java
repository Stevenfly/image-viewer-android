package com.example.y467yang.fotagy467yang;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;

public class ImageModel implements Parcelable {
    private int drawable;
    private int rating;

    ImageModel(int drawable) {
        this.drawable = drawable;
        this.rating = 0;
    }

    public int getDrawable() {
        return drawable;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
    * Parcelable functions
    */
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeIntArray(new int[] {this.drawable, this.rating});
    }

    public static final Parcelable.Creator<ImageModel> CREATOR
            = new Parcelable.Creator<ImageModel>() {
        public ImageModel createFromParcel(Parcel in) {
            return new ImageModel(in);
        }

        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };

    private ImageModel(Parcel in) {
        int[] data = new int[2];
        in.readIntArray(data);

        this.drawable = data[0];
        this.rating = data[1];
    }
}
