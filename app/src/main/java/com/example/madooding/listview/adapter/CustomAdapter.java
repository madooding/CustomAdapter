package com.example.madooding.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madooding.listview.Person;
import com.example.madooding.listview.R;

import java.util.List;

/**
 * Created by madooding on 9/30/2016 AD.
 */

public class CustomAdapter extends ArrayAdapter<Person> {
    private final List<Person> list;

    public CustomAdapter(Context context, int resource, List<Person> list){
        super(context, resource, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Person person = list.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(person.getName());

        ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
        imageView.setImageResource(person.getImage());


        return row;
    }
}
