package com.example.demo_6_search_view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    SearchView searchView;
    ListView listView;

    String name[] = {"Vinay","Vinayak","Vijay","Anuj","Ajay","Ajit","Harpal","Hitesh","Hardip"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.actext_view);
        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,name);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setTextColor(Color.BLUE);

        listView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+autoCompleteTextView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Name : "+name[i], Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                Toast.makeText(MainActivity.this, "Query : "+s, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override

            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}