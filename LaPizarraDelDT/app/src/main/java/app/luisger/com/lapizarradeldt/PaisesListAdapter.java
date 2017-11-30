package app.luisger.com.lapizarradeldt;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Luisger94 on 8/5/2017.
 */

public class PaisesListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public PaisesListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.paiseslist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.paiseslist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    };
}
