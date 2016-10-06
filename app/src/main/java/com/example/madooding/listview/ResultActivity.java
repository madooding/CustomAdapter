package com.example.madooding.listview;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final boolean[] editFlag = {false};

        Bundle bundle = getIntent().getExtras();
        final People people = (People)bundle.getSerializable("list");
        int position = bundle.getInt("position");
        String profileName = people.getName();
        setTitle(profileName + "\'s Profile");
        ImageView image = (ImageView) findViewById(R.id.resultImageView);
        image.setImageResource(people.getImage());

        final TextView nameView = (TextView) findViewById(R.id.resultNameView);
        nameView.setText(profileName);
        final TextView infoTextView = (TextView) findViewById(R.id.resultInfoView);
        infoTextView.setText(people.getInfo());

        final EditText editInfoView = (EditText) findViewById(R.id.resultEditInfoView);
        final EditText editNameView = (EditText) findViewById(R.id.resultEditNameView);


        final Button backBtn = (Button) findViewById(R.id.backBtn);
        final Button editBtn = (Button) findViewById(R.id.editBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editFlag[0]) {
                    finish();
                } else {
                    editInfoView.setVisibility(view.GONE);
                    infoTextView.setVisibility(view.VISIBLE);
                    editNameView.setVisibility(view.GONE);
                    nameView.setVisibility(view.VISIBLE);
                    editInfoView.setText(people.getInfo());
                    editNameView.setText(people.getName());
                    editBtn.setText("EDIT");
                    backBtn.setText("BACK");
                    editFlag[0] = false;
                }
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editFlag[0]) {
                    editInfoView.setText(people.getInfo());
                    editNameView.setText(people.getName());
                    infoTextView.setVisibility(view.GONE);
                    editInfoView.setVisibility(view.VISIBLE);
                    nameView.setVisibility(view.GONE);
                    editNameView.setVisibility(view.VISIBLE);
                    editBtn.setText("SAVE CHANGES");
                    backBtn.setText("CANCEL");
                } else {
                    people.setInfo(editInfoView.getText().toString());
                    people.setName(editNameView.getText().toString());
                    infoTextView.setText(people.getInfo());
                    nameView.setText(people.getName());
                    editInfoView.setVisibility(view.GONE);
                    infoTextView.setVisibility(view.VISIBLE);
                    editNameView.setVisibility(view.GONE);
                    nameView.setVisibility(view.VISIBLE);
                    setTitle(people.getName() + "\'s Profile");
                    editBtn.setText("EDIT");
                    backBtn.setText("BACK");

                }
                editFlag[0] = !editFlag[0];
            }
        });


        Intent intent = new Intent();
        intent.putExtra("list", people);
        intent.putExtra("position", position);
        setResult(RESULT_OK, intent);


//
//        Toast.makeText(this, people.getName(), Toast.LENGTH_SHORT).show();
    }


}
