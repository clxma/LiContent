package com.ytx.api;

/**
 * Created by fuzhen.li on 2017/6/15.
 */
public interface Switcher {

    void showEmptyVeiw();

    void showErrorView();

    void showLoadingView();

    void showContent();

    void setEmptyImgResource(int resourceId);

    void setEmptyTextView(String value);

    void setErrorImgResource(int resourceId);

    void setErrorTextView(String value);

    void setLoadingStart();

    void setLoadingCancle();
}
