package app.luisger.com.lapizarradeldt;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Luisger94 on 8/4/2017.
 */

public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas_layout);

        TextView title = (TextView) findViewById(R.id.notasActivityTitle1);
        title.setText("Notas Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent0 = new Intent(NotasActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_paises:
                        Intent intent1 = new Intent(NotasActivity.this, PaisesActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_notas:
                        break;

                    case R.id.ic_ajustes:
                        Intent intent3 = new Intent(NotasActivity.this, AjustesActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }
}
