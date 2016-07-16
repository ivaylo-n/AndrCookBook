package com.example.koki.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] countries = new String[]{"China", "France",
                "Germany", "India", "Switzerland", "UK", "US"};
        ListAdapter countryAdapter = new
                ArrayAdapter<String>(this, android.R.layout.
                simple_list_item_1, countries);
        setListAdapter(countryAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((TextView) view).getText() + " " + i;
                Toast.makeText(getApplicationContext(), s ,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
