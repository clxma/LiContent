package com.ytx.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ytx.R;

/**
 * Created by fuzhen.li on 2017/6/20.
 */
public class ErrorLayout extends LinearLayout {
    private ImageView errorImg;
    private TextView errorTv;

    public ErrorLayout(Context context) {
        super(context);
    }

    public ErrorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ErrorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ErrorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addErrorView(int errorId) {
        LayoutInflater.from(getContext()).inflate(errorId, this, true);
        errorImg = (ImageView) findViewById(R.id.error_img);
        errorTv = (TextView) findViewById(R.id.error_tv);
    }

    public void setErrorImageResource(int resourceId) {
        errorImg.setImageResource(resourceId);
    }

    public void setEerrorTextView(String errorText) {
        errorTv.setText(errorText);
    }

}
