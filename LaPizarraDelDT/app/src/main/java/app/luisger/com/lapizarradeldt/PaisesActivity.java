package app.luisger.com.lapizarradeldt;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Luisger94 on 8/4/2017.
 */

public class PaisesActivity extends AppCompatActivity {

    ListView list;
    String[] itemname={
            "ARG",
            "Estados Unidos",
            "Paraguay",
            "Venezuela"
    };

    Integer[] imgid={

            R.drawable.argentina,
            R.drawable.estadosunidos,
            R.drawable.paraguay,
            R.drawable.venezuela,

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paises_layout);

        PaisesListAdapter adapter = new PaisesListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.paisesList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String input = "https://google.com";

                if (position == 0)
                {
                    Intent intent4 = new Intent(PaisesActivity.this, webActivity.class);
                    intent4.putExtra("input", "https://www.lapizarradeldt.com/search/label/Argentina");
                    startActivity(intent4);
                }
                if (position == 1)
                {
                    Intent intent4 = new Intent(PaisesActivity.this, webActivity.class);
                    intent4.putExtra("input", "https://www.lapizarradeldt.com/search?q=United+States");
                    startActivity(intent4);
                }
                if (position == 2)
                {
                    Intent intent4 = new Intent(PaisesActivity.this, webActivity.class);
                    intent4.putExtra("input", "http://www.lapizarradeldt.com/search/label/Paraguay");
                    startActivity(intent4);
                }
                if (position == 3)
                {
                    Intent intent4 = new Intent(PaisesActivity.this, webActivity.class);
                    intent4.putExtra("input", "http://www.lapizarradeldt.com/search/label/Venezuela");
                    startActivity(intent4);
                }


            }
        });



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
                        Intent intent0 = new Intent(PaisesActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_paises:
                        break;

                    case R.id.ic_notas:
                        Intent intent2 = new Intent(PaisesActivity.this, NotasActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_ajustes:
                        Intent intent3 = new Intent(PaisesActivity.this, AjustesActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }



}
