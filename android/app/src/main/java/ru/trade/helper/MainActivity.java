package ru.trade.helper;

import android.os.Bundle;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ВСЕГДА свежий UI: чистим HTTP-кэш WebView и перезагружаем страницу,
        // иначе после обновления APK приложение показывает старый index.html.
        try {
            WebView wv = getBridge().getWebView();
            if (wv != null) {
                wv.clearCache(true);
                wv.clearHistory();
                wv.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_NO_CACHE);
                wv.loadUrl("http://45.150.37.188/index.html?v=" + System.currentTimeMillis());
            }
        } catch (Throwable t) { /* ignore */ }
    }
}
