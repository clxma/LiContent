package com.ytx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ytx.util.NetWorkUtil;
import com.ytx.widget.CommonShowLayout;

public class MainActivity extends AppCompatActivity {
    private CommonShowLayout commonShowLayout;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commonShowLayout = (CommonShowLayout) this.findViewById(R.id.commonShowLayout);
        webView = (WebView) this.findViewById(R.id.webview);
        commonShowLayout.showLoadingView();
        commonShowLayout.setLoadingStart();
        initWebView();

    }

    private void initWebView() {
        //声明WebSettings子类
        WebSettings webSettings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.baidu.com/");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100 && NetWorkUtil.isNetworkConnected(MainActivity.this)) {
                    commonShowLayout.setLoadingCancle();
                    commonShowLayout.showContent();

                }
            }
        });


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                commonShowLayout.showErrorView();
            }
        });
    }
}
