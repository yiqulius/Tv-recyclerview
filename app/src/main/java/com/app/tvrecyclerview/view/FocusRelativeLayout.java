package com.app.tvrecyclerview.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.tvrecyclerview.NiceImageView;
import com.app.tvrecyclerview.R;

public class FocusRelativeLayout extends RelativeLayout {
    NiceImageView niv;
    FrameLayout rl;
    private Animation scaleBigAnimation;
    private Animation scaleSmallAnimation;
    TextView tv;

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
        if (gainFocus) {
            zoomOut();
            if (getChildAt(0) != null && ((FrameLayout) getChildAt(1)).getChildAt(0) != null) {
                niv = (NiceImageView) getChildAt(0);
                niv.setCornerRadius(12);
                niv.setBorderWidth(2);
                niv.setBorderColor(Color.WHITE);
                rl = (FrameLayout) getChildAt(1);
                rl.setVisibility(VISIBLE);
                return;
            }
            return;
        }
        zoomIn();
        if (getChildAt(0) != null && ((FrameLayout) getChildAt(1)).getChildAt(0) != null) {
            niv = (NiceImageView) getChildAt(0);
            niv.setCornerRadius(12);
            niv.setBorderWidth(0);
            niv.setBorderColor(Color.TRANSPARENT);
            rl = (FrameLayout) getChildAt(1);
            rl.setVisibility(INVISIBLE);
        }
    }

    private void zoomIn() {
        if (scaleSmallAnimation == null) {
            scaleSmallAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_small);
        }
        startAnimation(scaleSmallAnimation);
    }

    private void zoomOut() {
        if (scaleBigAnimation == null) {
            scaleBigAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_big);
        }
        startAnimation(scaleBigAnimation);
    }
}
