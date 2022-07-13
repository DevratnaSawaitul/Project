package com.example.project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Translate extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        getSupportActionBar().hide();
        webView = findViewById(R.id.translate_view);
        webView.setWebViewClient(new WebViewClient());
        String url = "https://www.google.com/search?q=translate+english+to+hindi&rlz=1C1CHBF_enIN956IN956&oq=translate+english+to+hindi&aqs=chrome..69i57j0i512l8.8114j0j1&sourceid=chrome&ie=UTF-8";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(url);
        String userAgent = webView.getSettings().getUserAgentString();

        try {
            String androidString = webView.getSettings().getUserAgentString().substring(userAgent.indexOf("("), userAgent.indexOf(")") + 1);

            userAgent = webView.getSettings().getUserAgentString().replace(androidString, "X11; Linux x86_64");

        } catch (Exception e) {
            e.printStackTrace();
        }

        webView.getSettings().setUserAgentString(userAgent);
        webView.reload();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}