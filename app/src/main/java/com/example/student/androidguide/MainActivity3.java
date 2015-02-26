package com.example.student.androidguide;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity3 extends ActionBarActivity {


    private WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        browser = (WebView)findViewById(R.id.webView);
       // browser.setWebViewClient(new MyBrowser());


        ListView lv = (ListView) findViewById(R.id.listView);

        Resources res =getResources();
        String[]weblist=res.getStringArray(R.array.weblist_array);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,weblist);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String select = (String) parent.getItemAtPosition(position);
                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(select);


            }
        });
    }
  //  private class MyBrowser extends WebViewClient {
     //   @Override
       // public boolean shouldOverrideUrlLoading(WebView view, String url) {
           // view.loadUrl(url);
           // return true;
       // }
  //  }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.menu_help:
                Intent helpIntent =new Intent(this,MainActivity4.class);
                startActivity(helpIntent);
                return true;
            case R.id.menu_about:
                Intent aboutIntent =new Intent(this,MainActivity5.class);
                startActivity(aboutIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
