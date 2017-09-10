package com.dishu.inshorts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * Created by Dishu on 9/11/2017.
 */

public class DetailsActivity extends AppCompatActivity {

//    private String postUrl = "https://api.androidhive.info/webview/index.html";
    private String postUrl = "https://api.androidhive.info/webview/index.html";
    private WebView webView;
    private ProgressBar progressBar;
//    private ImageView imgHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);

        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        postUrl = getIntent().getStringExtra("url");
        webView.loadUrl(postUrl);
        webView.setHorizontalScrollBarEnabled(false);
    }


}