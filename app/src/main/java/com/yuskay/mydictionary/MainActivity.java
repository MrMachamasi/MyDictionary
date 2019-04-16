package com.yuskay.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public static final String countries[]={
            "Nepal",
            "india",
            "china",
            "UK"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView theCountries=findViewById(R.id.myList);

        ArrayAdapter countryAdapter=new ArrayAdapter(
                MainActivity.this ,
                android.R.layout.simple_list_item_1,
                countries
        );

        theCountries.setAdapter(countryAdapter);
    }
}
