package com.example.madooding.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.madooding.listview.adapter.CustomAdapter;
import java.util.ArrayList;
import java.util.List;
import com.example.madooding.listview.RequestCode;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"alecgator", "goat", "rabbit"};
    final List<People> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new People("Akira", R.drawable.image));
        list.add(new People("Job", R.drawable.image2));


    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(new CustomAdapter(this, R.layout.custom_row, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("list", list.get(i));
                intent.putExtra("position", i);
                startActivityForResult(intent, RequestCode.EDIT_TEXT);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == RequestCode.EDIT_TEXT && data != null){
            list.set(data.getIntExtra("position", -1), (People)data.getSerializableExtra("list"));
//            Toast.makeText(this, ((People)data.getSerializableExtra("list")).getName(), Toast.LENGTH_SHORT).show();
        }

    }
}
