package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Result extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();
        webView = findViewById(R.id.result_view);
        webView.setWebViewClient(new WebViewClient());

        String url = "https://rtmnuresults.org";
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

    private void checkInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnected() || mobile.isConnected()) {
            webView.setVisibility(View.VISIBLE);
            //noInternetLayout.setVisibility(View.INVISIBLE);
        } else {
            //else no internet layout will be called
            //noInternetLayout.setVisibility(View.VISIBLE);
        }
    }

}