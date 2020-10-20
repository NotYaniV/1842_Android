package com.example.webviewapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    SwipeRefreshLayout refreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String httpSite = "https://youtube.com";
        getSupportActionBar().hide();
        webView = (WebView) findViewById(R.id.webview);
        refreshLayout = findViewById(R.id.swiperefresh);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setSoundEffectsEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String httpSite) {
                //True if the host application wants to leave the current WebView and handle the url itself, otherwise return false.
                return false;
            }
        });

        if (haveNetwork()) webView.loadUrl(httpSite);
        else if (!haveNetwork()) {
            Toast.makeText(this, "Network connection is not available,Loading html page", Toast.LENGTH_SHORT);
            webView.loadUrl("file:///android_asset/profile.html");
        }
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (haveNetwork()) {
                    webView.loadUrl(httpSite);
                } else if (!haveNetwork()) {
                    // enter the code for html page
                    webView.loadUrl("file:///android_asset/profile.html");

                }
                refreshLayout.setRefreshing(false); // else infinite refreshing
            }
        });

    }
        @RequiresApi(api = Build.VERSION_CODES.M)
        private boolean haveNetwork()
        {
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            /*boolean isWifiConn = false;
            boolean isMobileConn = false;
            for (Network network : connMgr.getAllNetworks()) {
                NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    if (networkInfo.isConnected())  {
                        isWifiConn |= networkInfo.isConnected();
                        Log.i(String.valueOf(isWifiConn), "have WIFI network: ");
                    }

                }
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    if (networkInfo.isConnected()) {
                        isMobileConn |= networkInfo.isConnected();
                        Log.i(String.valueOf(isMobileConn), "have mobile network: ");
                    }
                }
            }
            return (isMobileConn || isWifiConn);*/

        }
}


