package app.luisger.com.lapizarradeldt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent0 = new Intent(webActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_paises:
                        Intent intent1 = new Intent(webActivity.this, PaisesActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_notas:
                        Intent intent2 = new Intent(webActivity.this, NotasActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_ajustes:
                        Intent intent3 = new Intent(webActivity.this, AjustesActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }


}
