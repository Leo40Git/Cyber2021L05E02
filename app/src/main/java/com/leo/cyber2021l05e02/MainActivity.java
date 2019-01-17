package com.leo.cyber2021l05e02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNumA, etNumB, etNumC;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumA = findViewById(R.id.etNumA);
        etNumB = findViewById(R.id.etNumB);
        etNumC = findViewById(R.id.etNumC);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new NativeWebViewClient());
        //webView.loadUrl("about:blank");
    }

    private class NativeWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void onClick_getSolution(View view) {
    }

    public void onClick_clear(View view) {
        etNumA.setText("");
        etNumB.setText("");
        etNumC.setText("");
        webView.loadUrl("about:blank");
    }
}
