package com.example.tarun.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    EditText editText;
    int t=1;
    Button add_button;
    Button remove_button;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list);
        editText = (EditText) findViewById(R.id.edit);
        add_button = (Button) findViewById(R.id.add);
        remove_button = (Button) findViewById(R.id.remove);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (t!=0) {
            TextView t = (TextView) view;
            String h;
            h = t.getText().toString();
            Intent i = new Intent(this, activityb.class);
            i.putExtra("te", h);
            startActivity(i);
        }
        if  (t==0) {
            //the remove class is called to remove the item
            remove(position);
            t=1;
        }
    }

    //On clicking the remove button
    public void function(View view) {
        Toast.makeText(this, "Click the item you want to be removed", Toast.LENGTH_SHORT).show();
        t=0;
    }

    public void remove(int p){
        arrayList.remove(p);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "The selected item is removed", Toast.LENGTH_SHORT).show();
    }
}