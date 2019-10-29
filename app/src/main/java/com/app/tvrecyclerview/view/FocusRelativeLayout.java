package com.app.tvrecyclerview.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.tvrecyclerview.NiceImageView;
import com.app.tvrecyclerview.R;

public class FocusRelativeLayout extends RelativeLayout {

    private static final String TAG = "FocusRelativeLayout";

    NiceImageView niv;
    private Animation scaleBigAnimation;
    private Animation scaleSmallAnimation;

    public FocusRelativeLayout(Context context) {
        super(context);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (scaleSmallAnimation == null || scaleBigAnimation == null) {
            scaleSmallAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_small);
            scaleBigAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_big);
        }
        if (gainFocus) {
            if (getChildAt(1) instanceof NiceImageView) {
                niv = (NiceImageView) getChildAt(1);
                niv.setCornerRadius(12);
                niv.setBorderWidth(2);
                niv.setBorderColor(Color.WHITE);
                startAnimation(scaleBigAnimation);
                Log.e(TAG, "onFocusChanged: " );
            }
        } else {
            if (getChildAt(1) instanceof NiceImageView) {
                niv = (NiceImageView) getChildAt(1);
                niv.setCornerRadius(12);
                niv.setBorderWidth(2);
                niv.setBorderColor(Color.TRANSPARENT);
                startAnimation(scaleSmallAnimation);
                Log.e(TAG, "onFocusChanged: --2--" );
            }
        }
    }
}
