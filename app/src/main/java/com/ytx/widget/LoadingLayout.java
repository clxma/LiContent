package com.ytx.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ytx.R;

/**
 * Created by fuzhen.li on 2017/6/20.
 */
public class LoadingLayout extends LinearLayout {
    private ImageView loadingImg;
    private RotateAnimation rotateAnimation;

    public LoadingLayout(Context context) {
        super(context);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addLoadingView(int loadingId) {
        LayoutInflater.from(getContext()).inflate(loadingId, this, true);
        loadingImg = (ImageView) findViewById(R.id.loading_img);
    }

    public void setErrorImageResource(int resourceId) {
        loadingImg.setImageResource(resourceId);
    }

    public void startAnim() {
        if (rotateAnimation == null) {
            return;
        }

        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        loadingImg.startAnimation(rotateAnimation);
    }

    public void stopAnim() {
        if (rotateAnimation == null) {
            return;
        }
        rotateAnimation.cancel();
    }

}
