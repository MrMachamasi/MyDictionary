package com.yuskay.mydictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {
            "Nepal", "KTM",
            "india", "Delhi",
            "china", "beijing",
            "UK", "london",
            "Japan","Tokyo"

    };

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView theCountries = findViewById(R.id.myList);

        dictionary = new HashMap<>();

        for (int i = 0; i < countries.length; i += 2) {
            dictionary.put(countries[i], countries[i+1]);
        }

        ArrayAdapter countryAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String> (dictionary.keySet())
        );

        theCountries.setAdapter(countryAdapter);
        theCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> theCountries, View view, int position, long id) {
                String country=theCountries.getItemAtPosition(position).toString();
                String capital=dictionary.get(country);
//                Toast.makeText(getApplicationContext(),capital.toString(), Toast.LENGTH_SHORT).show();


                Intent intent=new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("capital",capital);
                startActivity(intent);



            }
        });
    }
}
