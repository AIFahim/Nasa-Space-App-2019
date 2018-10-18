package com.decoderssquad.airpolllutionmonitoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Device extends AppCompatActivity {
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        wb=findViewById(R.id.web);

        wb.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
         wb.loadUrl("https://aqicn.org/city/bangladesh/dhaka/us-consulate/");


         //kkkk








    }
}
