package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AppointmentwithDoctor extends AppCompatActivity {
    WebView web;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentwith_doctor);

        web = findViewById(R.id.webView);

        // Circular progress bar before the url loads in the webView.
        progress = findViewById(R.id.progress);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("https://www.practo.com/doctors");
        boolean doubleBackToExitPressedOnce = false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(AppointmentwithDoctor.this,
                SignedInActivity.class);


        startActivity(i);
}

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }

        // This method is called after the url finishes loading.
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            // Make the progress bar invisible after the loading completes.
            progress.setVisibility(View.GONE);

            // Make the web view visible after it loads the contents.
            web.setVisibility(View.VISIBLE);
        }
    }


}