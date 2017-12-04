package app.luisger.com.lapizarradeldt;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

/**
 * Created by Luisger94 on 8/4/2017.
 */

public class AjustesActivity extends AppCompatActivity {

    DayNightSwitch dayNightSwitch;
    View background_view;
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajustes_layout);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        dayNightSwitch = (DayNightSwitch)findViewById(R.id.dayNight);
        background_view = findViewById(R.id.background_view);
        text = (TextView) findViewById(R.id.textView);

        dayNightSwitch.setDuration(450);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                if(isNight)
                {
                    Toast.makeText(AjustesActivity.this, "Night Mode Selected", Toast.LENGTH_SHORT).show();
                    background_view.setAlpha(1f);
                    text.setTextColor(Color.WHITE);
                }
                else
                {
                    Toast.makeText(AjustesActivity.this, "Day Mode Selected", Toast.LENGTH_SHORT).show();
                    background_view.setAlpha(0f);
                    text.setTextColor(Color.BLACK);
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent0 = new Intent(AjustesActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_paises:
                        Intent intent1 = new Intent(AjustesActivity.this, PaisesActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_notas:
                        Intent intent2 = new Intent(AjustesActivity.this, NotasActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_ajustes:
                        break;
                }

                return false;
            }
        });
    }
}
