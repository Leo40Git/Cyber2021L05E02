package com.leo.cyber2021l05e02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    private class NativeWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void onClick_getSolution(View view) {
        String a = etNumA.getText().toString();
        String b = ensureSign(etNumB.getText().toString());
        String c = ensureSign(etNumC.getText().toString());
        String url = "https://www.google.com/search?hl=en&gl=en&q="; // "?hl=en&gl=en" attempts to force English
        url += a;
        url += "x%5E2"; // %5E = ^
        url += b;
        url += "x";
        url += c;
        webView.loadUrl(url);
    }

    private String ensureSign(String n) {
        if (!n.startsWith("-"))
            return "%2B" + n; // %2B = +
        return n;
    }

    public void onClick_clear(View view) {
        etNumA.setText("");
        etNumB.setText("");
        etNumC.setText("");
        webView.loadUrl("about:blank");
    }
}
