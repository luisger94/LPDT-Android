package app.luisger.com.lapizarradeldt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URL;


public class webActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String input;
        //String input = "https://google.com";
        //URL sourceURL = new URL(input);

        Intent intent = getIntent();
        input = intent.getStringExtra("input");

        WebView view = (WebView) this.findViewById(R.id.webView);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(input);
        view.getSettings().setJavaScriptEnabled(true);
    }
}
