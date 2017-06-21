package com.ytx.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ytx.R;

/**
 * Created by fuzhen.li on 2017/6/20.
 */
public class EmptyLayout extends LinearLayout {
    private ImageView emptyImg;
    private TextView emptyTv;

    public EmptyLayout(Context context) {
        super(context);
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EmptyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addEmptyView(int emptyId) {
        LayoutInflater.from(getContext()).inflate(emptyId, this, true);
        emptyImg = (ImageView) findViewById(R.id.empty_img);
        emptyTv = (TextView) findViewById(R.id.empty_tv);
    }

    public void setEmptyImageResource(int resourceId) {
        emptyImg.setImageResource(resourceId);
    }

    public void setEmptyTextView(String emptyText) {
        emptyTv.setText(emptyText);
    }

}
