package com.example.madooding.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final boolean[] editFlag = {false};

        Bundle bundle = getIntent().getExtras();
        final Person person = (Person)bundle.getSerializable("list");
        int position = bundle.getInt("position");
        String profileName = person.getName();
        setTitle(profileName + "\'s Profile");
        ImageView image = (ImageView) findViewById(R.id.resultImageView);
        image.setImageResource(person.getImage());

        final TextView nameView = (TextView) findViewById(R.id.resultNameView);
        nameView.setText(profileName);
        final TextView infoTextView = (TextView) findViewById(R.id.resultInfoView);
        infoTextView.setText(person.getInfo());

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
                    editInfoView.setText(person.getInfo());
                    editNameView.setText(person.getName());
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
                    editInfoView.setText(person.getInfo());
                    editNameView.setText(person.getName());
                    infoTextView.setVisibility(view.GONE);
                    editInfoView.setVisibility(view.VISIBLE);
                    nameView.setVisibility(view.GONE);
                    editNameView.setVisibility(view.VISIBLE);
                    editBtn.setText("SAVE CHANGES");
                    backBtn.setText("CANCEL");
                } else {
                    person.setInfo(editInfoView.getText().toString());
                    person.setName(editNameView.getText().toString());
                    infoTextView.setText(person.getInfo());
                    nameView.setText(person.getName());
                    editInfoView.setVisibility(view.GONE);
                    infoTextView.setVisibility(view.VISIBLE);
                    editNameView.setVisibility(view.GONE);
                    nameView.setVisibility(view.VISIBLE);
                    setTitle(person.getName() + "\'s Profile");
                    editBtn.setText("EDIT");
                    backBtn.setText("BACK");

                }
                editFlag[0] = !editFlag[0];
            }
        });


        Intent intent = new Intent();
        intent.putExtra("list", person);
        intent.putExtra("position", position);
        setResult(RESULT_OK, intent);


//
//        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }


}
