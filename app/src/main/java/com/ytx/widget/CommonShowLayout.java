package com.ytx.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.ytx.R;
import com.ytx.api.Switcher;

/**
 * Created by fuzhen.li on 2017/6/15.
 */
public class CommonShowLayout extends FrameLayout implements Switcher {

    private static final String TAG = "CommonShowLayout";

    private static final int EMPTY_VIEW_LAYOUT = R.layout.empty_view;
    private static final int ERROR_VIEW_LAYOUT = R.layout.error_view;
    private static final int LOADING_VIEW_LAYOUT = R.layout.loading_view;

    private EmptyLayout emptyLayout;
    private ErrorLayout errorLayout;
    private LoadingLayout loadingLayout;


    private int mEmptyId;
    private int mErrorId;
    private int mLoadingtId;

    private View mView;

    public CommonShowLayout(Context context) {
        this(context, null);
    }

    public CommonShowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonShowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonShowLayout);
            mEmptyId = typedArray.getResourceId(R.styleable.CommonShowLayout_emptyId, EMPTY_VIEW_LAYOUT);
            mErrorId = typedArray.getResourceId(R.styleable.CommonShowLayout_errorid, ERROR_VIEW_LAYOUT);
            mLoadingtId = typedArray.getResourceId(R.styleable.CommonShowLayout_loadingid, LOADING_VIEW_LAYOUT);

            emptyLayout = new EmptyLayout(context, attrs);
            emptyLayout.addEmptyView(mEmptyId);

            errorLayout = new ErrorLayout(context, attrs);
            errorLayout.addErrorView(mErrorId);

            loadingLayout = new LoadingLayout(context, attrs);
            loadingLayout.addLoadingView(mLoadingtId);


            addView(emptyLayout);
            addView(errorLayout);
            addView(loadingLayout);

        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    @Override
    public void showEmptyVeiw() {
        setVisible(emptyLayout, mView, errorLayout, loadingLayout);
    }

    @Override
    public void showErrorView() {
        setVisible(errorLayout, emptyLayout, mView, loadingLayout);
    }

    @Override
    public void showLoadingView() {
        setVisible(loadingLayout, emptyLayout, mView, errorLayout);
    }

    @Override
    public void showContent() {
        setVisible(mView, emptyLayout, errorLayout, loadingLayout);
    }

    @Override
    public void setEmptyImgResource(int resourceId) {
        emptyLayout.setEmptyImageResource(resourceId);
    }

    @Override
    public void setEmptyTextView(String value) {
        emptyLayout.setEmptyTextView(value);
    }

    @Override
    public void setErrorImgResource(int resourceId) {
        errorLayout.setErrorImageResource(resourceId);
    }

    @Override
    public void setErrorTextView(String value) {
        errorLayout.setEerrorTextView(value);
    }

    @Override
    public void setLoadingStart() {
        loadingLayout.startAnim();
    }

    @Override
    public void setLoadingCancle() {
        loadingLayout.stopAnim();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        Log.e(TAG, "childCount " + childCount);
        if (childCount < 4) {
            throw new IllegalStateException("CommonShowLayout must have at least one child");
        }
        if (childCount > 4) {
            throw new IllegalStateException("CommonShowLayout must have only one child");
        }
        mView = getChildAt(3);
    }

    private void setVisible(View visibleView, View... view) {
        visibleView.setVisibility(View.VISIBLE);
        for (View v : view) {
            v.setVisibility(View.GONE);
        }
    }
}
