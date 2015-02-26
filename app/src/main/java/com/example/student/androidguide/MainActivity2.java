package com.example.student.androidguide;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends ActionBarActivity {

    private AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        String[] terminology = getResources().getStringArray(R.array.list_of_terminology);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,terminology);

        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        actv.setThreshold(3);
        actv.setAdapter(adapter);

       // Adapter ap =(Adapter) actv;

        //--- text view---
       // TextView txtView = (TextView) findViewById(R.id.autoCompleteTextView1);
        //final String Label = (String)actv.getText().toString();

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               //get selected value
                String selection = (String)parent.getItemAtPosition(position);
                int no = selection.length();
                //Adapter da = new Adapter(this.android.R.layout.lint);
                TextView text = (TextView) findViewById(R.id.textView5);

                   // String lintd = getString(R.string.lint);  //get xml resource
                Resources res =getResources();
                String[]terms=res.getStringArray(R.array.terminology_array);

                for(int i=0; i<terms.length;i++) {
                    if (selection.trim().equalsIgnoreCase(terms[i].trim().substring(0, no))) {
                        text.setText(terms[i]);
                        break;
                    } else
                        text.setText(terms[i].substring(0, no));
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
