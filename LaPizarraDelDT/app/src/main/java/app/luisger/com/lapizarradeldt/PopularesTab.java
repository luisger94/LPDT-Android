package app.luisger.com.lapizarradeldt;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Luisger94 on 8/1/2017.
 */

public class PopularesTab extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.populares, container, false);

        WebView viewMain = (WebView) view.findViewById(R.id.webViewPopular);
        String input = "https://www.lapizarradeldt.com/search>q=popular";
        viewMain.setWebViewClient(new WebViewClient());
        WebSettings webSettings1 = viewMain.getSettings();
        viewMain.getSettings().setJavaScriptEnabled(true);
        viewMain.loadUrl(input);

        return view;
    }
}
