package com.app.tvrecyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app.tvrecyclerview.MaulCarouselAdapter.OnItemStateListener;

public class maulVerticalCarouselActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    private static final String TAG = "maulVerticalCarouselAct";
    private TvRe mTvRecyclerView;

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b){

            Log.e(TAG, "onFocusChange: " + mTvRecyclerView.indexOfChild(view) );
//            mTvRecyclerView.indexOfChild(view);
        }
    }

    private class SpaceItemDecoration extends ItemDecoration {
        private int mBottom;
        private int mLeft;

        SpaceItemDecoration(int bottom, int left) {
            mBottom = bottom;
            mLeft = left;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
            outRect.bottom = mBottom;
            outRect.left = mLeft;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_vertical_carousel);
        mTvRecyclerView = (TvRe) findViewById(R.id.tv_recycler_view);
        init();
    }

    private void init() {
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        manager.setOrientation(1);
        manager.supportsPredictiveItemAnimations();
        mTvRecyclerView.setLayoutManager(manager);
        mTvRecyclerView.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.recyclerView_item_space1), getResources().getDimensionPixelSize(R.dimen.recyclerView_item_space1)));
        mTvRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MaulCarouselAdapter mAdapter = new MaulCarouselAdapter(this);
        mTvRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemStateListener(new OnItemStateListener() {
            public void onItemClick(View view, int position) {
                Toast.makeText(maulVerticalCarouselActivity.this, ContantUtil.TEST_DATAS[position], 1000).show();
            }
        });
        mTvRecyclerView.setOnFocusChangeListener(this);
    }
}
