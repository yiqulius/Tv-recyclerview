package com.app.tvrecyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tvrecyclerview.view.FocusRelativeLayout;

public class MaulCarouselAdapter extends Adapter<ViewHolder> {
    private Context mContext;
    private static OnItemStateListener mListener;

    public interface OnItemStateListener {
        void onItemClick(View view, int i);
    }

    private class RecyclerViewHolder extends ViewHolder implements OnClickListener {
        NiceImageView mImageView;
        TextView mName;
        FocusRelativeLayout mRelativeLayout;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_item_tip);
            mRelativeLayout = (FocusRelativeLayout) itemView.findViewById(R.id.fl_main_layout);
            mImageView = (NiceImageView) itemView.findViewById(R.id.iv_item);
            mRelativeLayout.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (MaulCarouselAdapter.mListener != null) {
                MaulCarouselAdapter.mListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    MaulCarouselAdapter(Context context) {
        mContext = context;
    }

    public void setOnItemStateListener(OnItemStateListener listener) {
        mListener = listener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(View.inflate(mContext, R.layout.item_recyclerview_maul, null));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerViewHolder viewHolder = (RecyclerViewHolder) holder;
        viewHolder.mName.setText(ContantUtil.TEST_DATAS[position]);
        viewHolder.mImageView.setImageDrawable(ContextCompat.getDrawable(mContext, ContantUtil.getImgResourceId(position)));
    }

    public int getItemCount() {
        return 8;
    }
}
