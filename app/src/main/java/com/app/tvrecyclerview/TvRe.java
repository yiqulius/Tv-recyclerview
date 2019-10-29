package com.app.tvrecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class TvRe extends RecyclerView {

    private int mSelectedPosition = 0;

    private Context mContext;

    public TvRe(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TvRe(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TvRe(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setChildrenDrawingOrderEnabled(true);
    }

    @Override
    public void onDraw(Canvas c) {
        mSelectedPosition = indexOfChild(getFocusedChild());
        super.onDraw(c);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        int position = mSelectedPosition;
        if (position < 0) {
            return i;
        } else {
            if (i == childCount - 1) {
                if (position > i) {
                    position = i;
                }
                return position;
            }
            if (i == position) {
                return childCount - 1;
            }
        }
        return i;
    }


//    public void setLayoutView(List<Map<String, Object>> list) {
//        if (this.getChildCount() > 0)
//            this.removeAllViews();
//        int i = 100;
//        for (int j = 0; j < list.size(); j++) {
//
//            ViewGroup view;
//            view = (ViewGroup) View.inflate(mContext, R.layout.layout_grid_item, null);
//            ImageView img_bg = (ImageView) view.getChildAt(0);
//            TextView textView = (TextView) view.getChildAt(1);
//            if (list.get(j).get("item_type") instanceof Drawable) {
//                Object number = list.get(j).get("item_name");
//                Boolean isApp = false;
//                if (number instanceof Integer){
//                    int num = Integer.parseInt(number.toString());
////                    textView.setText(getResources().getString(Launcher.appName[num]));
//                    for (int m = 0; m < Launcher.appName.length; m++) {
//                        if (num == m) {
//                            isApp = true;
//                            break;
//                        }
//                    }
//                } else if (number instanceof String){
//                    textView.setText((String)list.get(j).get("item_name"));
//                }
//
//                if (isApp) {
//                    img_bg.setPadding(2, 4, 2, 4);
//                    img_bg.setImageDrawable((Drawable) list.get(j).get("item_type"));
//                } else {
//                    img_bg.setPadding(20, 20, 20, 50);
//                    img_bg.setImageDrawable((Drawable) (list.get(j).get("item_type")));
//                    img_bg.setBackgroundResource(highSelector[colors]);
//
//                    ViewCompat.animate(img_bg)
//                            .setDuration(0)
//                            .scaleX(1.01f)
//                            .scaleY(1.01f)
//                            .start();
//
////                    colors++;
////                    if (colors == 5) {
////                        colors = 0;
////                    }
//                }
//            } else {
//                img_bg.setPadding(2, 4, 2, 4);
//                img_bg.setImageResource(R.drawable.img_add);
//            }
//            view.setOnKeyListener(new MyOnKeyListener(mContext, list.get(j).get("file_path")));
//            view.setOnTouchListener(new MyOnTouchListener(mContext, list.get(j).get("file_path")));
//            view.setFocusable(true);
//            view.setFocusableInTouchMode(true);
//            view.setId(i++);
//            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
//                    .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            GridLayout.LayoutParams gl = new GridLayout.LayoutParams(ll);
//            gl.rightMargin = 6;
//            int m = (list.size() / 5 - 1) * 5 - 1;
//            if (j < m) {
////                gl.bottomMargin = 15;
//            }
//
//            view.setLayoutParams(gl);
//            this.addView(view);
//        }
//        colors = 0;
//    }
}
