package com.example.y467yang.fotagy467yang;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String RECYCLE_STATE_KEY = "recycler_state";
    public final static String FILTER_STATE_KEY = "filter_state";
    public final static String IMAGE_SET_STATE_KEY = "image_set_state";

    Parcelable recycleState;
    int filterState;

    private RecyclerView mRecyclerView;
    private ImageAdapter mImageAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private MenuItem mMenuItem1;
    private MenuItem mMenuItem2;
    private MenuItem mMenuItem3;
    private MenuItem mMenuItem4;
    private MenuItem mMenuItem5;

    private ArrayList<ImageModel> ImageSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_search);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        ImageSet = new ArrayList<>();

        // Set Layout based on device orientation
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new LinearLayoutManager(this);
        } else {
            mLayoutManager = new GridLayoutManager(this, 2);
        }

        // read from last saved instance (after rotation change)
        if(savedInstanceState != null) {
            recycleState = savedInstanceState.getParcelable(RECYCLE_STATE_KEY);
            mLayoutManager.onRestoreInstanceState(recycleState);

            ImageSet = savedInstanceState.getParcelableArrayList(IMAGE_SET_STATE_KEY);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);

        mImageAdapter = new ImageAdapter(this, ImageSet);
        mRecyclerView.setAdapter(mImageAdapter);

        if(savedInstanceState != null) {
            filterState = savedInstanceState.getInt(FILTER_STATE_KEY);
            mImageAdapter.setFilterRating(filterState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        recycleState = mLayoutManager.onSaveInstanceState();
        outState.putParcelable(RECYCLE_STATE_KEY, recycleState);

        filterState = mImageAdapter.getFilterRating();
        outState.putInt(FILTER_STATE_KEY, filterState);

        outState.putParcelableArrayList(IMAGE_SET_STATE_KEY, ImageSet);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_items, menu);

        mMenuItem1 = menu.findItem(R.id.action_star_1);
        mMenuItem2 = menu.findItem(R.id.action_star_2);
        mMenuItem3 = menu.findItem(R.id.action_star_3);
        mMenuItem4 = menu.findItem(R.id.action_star_4);
        mMenuItem5 = menu.findItem(R.id.action_star_5);

        setFilterView(filterState);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                ImageSet.add(ImageSet.size(), new ImageModel(R.drawable.img_cat));
//                mImageAdapter.notifyItemInserted(ImageSet.size());
                onSearchRequested();
                return true;

            case R.id.action_star_1:
                setFilterView(1);
                mImageAdapter.setFilterRating(1);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_star_2:
                setFilterView(2);
                mImageAdapter.setFilterRating(2);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_star_3:
                setFilterView(3);
                mImageAdapter.setFilterRating(3);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_star_4:
                setFilterView(4);
                mImageAdapter.setFilterRating(4);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_star_5:
                setFilterView(5);
                mImageAdapter.setFilterRating(5);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_clear:
                setFilterView(0);
                mImageAdapter.setFilterRating(0);
                mImageAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_load:
                loadImages();
                return true;

            case R.id.action_delete:
                clearImages();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadImages() {
        ImageSet.add(new ImageModel(R.drawable.img_goose_0));
        ImageSet.add(new ImageModel(R.drawable.img_goose_1));
        ImageSet.add(new ImageModel(R.drawable.img_goose_2));
        ImageSet.add(new ImageModel(R.drawable.img_goose_3));
        ImageSet.add(new ImageModel(R.drawable.img_goose_4));
        ImageSet.add(new ImageModel(R.drawable.img_goose_5));
        ImageSet.add(new ImageModel(R.drawable.img_goose_6));
        ImageSet.add(new ImageModel(R.drawable.img_goose_7));
        ImageSet.add(new ImageModel(R.drawable.img_goose_8));
        ImageSet.add(new ImageModel(R.drawable.img_goose_9));
        mImageAdapter.notifyDataSetChanged();
    }

    private void clearImages() {
        ImageSet.clear();
        mImageAdapter.notifyDataSetChanged();
    }

    private void setFilterView(int filter) {
        mMenuItem1.setIcon(R.drawable.ic_star_border_reduced_padding);
        mMenuItem2.setIcon(R.drawable.ic_star_border_reduced_padding);
        mMenuItem3.setIcon(R.drawable.ic_star_border_reduced_padding);
        mMenuItem4.setIcon(R.drawable.ic_star_border_reduced_padding);
        mMenuItem5.setIcon(R.drawable.ic_star_border_reduced_padding);

        if (filter > 0) {
            mMenuItem1.setIcon(R.drawable.ic_star_reduced_padding);
        }

        if (filter > 1) {
            mMenuItem2.setIcon(R.drawable.ic_star_reduced_padding);
        }

        if (filter > 2) {
            mMenuItem3.setIcon(R.drawable.ic_star_reduced_padding);
        }

        if (filter > 3) {
            mMenuItem4.setIcon(R.drawable.ic_star_reduced_padding);
        }

        if (filter > 4) {
            mMenuItem5.setIcon(R.drawable.ic_star_reduced_padding);
        }
    }
}
