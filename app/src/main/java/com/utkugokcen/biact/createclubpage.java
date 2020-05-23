package com.utkugokcen.biact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class createclubpage extends AppCompatActivity {
    String clubname, name, surname, department, email, clubdescription, namesurnameText, password;
    TextView clubnameText, clubdescriptionText, namesurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createclubpagelayout);

        clubnameText = findViewById(R.id.clubnameText);
        clubdescriptionText = findViewById(R.id.clubdescriptionText);
        namesurname = findViewById(R.id.namesurnameT);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        surname = intent.getStringExtra("surname");
        department = intent.getStringExtra("dep");
        email = intent.getStringExtra("mail");
        clubname = intent.getStringExtra("clubname");
        clubdescription = intent.getStringExtra("clubdes");
        namesurnameText = intent.getStringExtra("namesurname");
        password = intent.getStringExtra("password");

        namesurname.setText(namesurnameText);



   }

    public void createclub1Clicked(View view){
        clubname = clubnameText.getText().toString();
        clubdescription = clubdescriptionText.getText().toString();
        Intent intent = new Intent(createclubpage.this, clubfeedpage.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("dep", department);
        intent.putExtra("mail", email);
        intent.putExtra("clubname", clubname);
        intent.putExtra("clubdes", clubdescription);
        intent.putExtra("namesurname", namesurnameText);
        intent.putExtra("password", password);

        startActivity(intent);
    }

    public void addphoto1Clicked(View view){

    }

    public void backClicked(View view){
        Intent intent = new Intent(createclubpage.this, studentprofilepage.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("dep", department);
        intent.putExtra("mail", email);
        intent.putExtra("clubname", clubname);
        intent.putExtra("clubdes", clubdescription);
        intent.putExtra("namesurname", namesurnameText);
        intent.putExtra("password", password);
        startActivity(intent);
    }
}
