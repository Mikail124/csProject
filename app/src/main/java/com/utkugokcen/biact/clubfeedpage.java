package com.utkugokcen.biact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class clubfeedpage extends AppCompatActivity {
    TextView clubnameText;
    ImageView manicon;
    String clubname, name, surname, department, email,clubdescription,namesurnameText, password;
    private FirebaseFirestore firebaseFireStore;
    ArrayList<String> eventNameFromFB;
    ArrayList<String> eventDateFromFB;
    ArrayList<String> eventTimeFromFB;
    ArrayList<String> eventLocationFromFB;
    ArrayList<String> eventPointFromFB;
    ArrayList<String> eventDescriptionFromFB;
    ArrayList<String> eventImageFromFB;
    ArrayList<String> eventOwnerFromFB;
    FeedRecyclerAdapterForClub feedRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubfeedpagelayout);

        clubnameText = findViewById(R.id.clubname);
        manicon = findViewById(R.id.manicon);

        Intent intent = getIntent();
        clubname = intent.getStringExtra("clubname");
        name = intent.getStringExtra("name");
        surname = intent.getStringExtra("surname");
        department = intent.getStringExtra("dep");
        email = intent.getStringExtra("mail");
        clubdescription = intent.getStringExtra("clubdes");
        namesurnameText = intent.getStringExtra("namesurname");
        password = intent.getStringExtra("password");
        clubnameText.setText(clubname);

        eventOwnerFromFB = new ArrayList<>();
        eventNameFromFB = new ArrayList<>();
        eventDateFromFB = new ArrayList<>();
        eventTimeFromFB = new ArrayList<>();
        eventLocationFromFB = new ArrayList<>();
        eventPointFromFB = new ArrayList<>();
        eventDescriptionFromFB = new ArrayList<>();
        eventImageFromFB = new ArrayList<>();

        firebaseFireStore = FirebaseFirestore.getInstance();

        getDataFromFireStore();

        //RecyclerView

        RecyclerView recyclerView = findViewById(R.id.recyclerView_club);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedRecyclerAdapter = new FeedRecyclerAdapterForClub(eventOwnerFromFB,eventNameFromFB ,eventDateFromFB, eventTimeFromFB, eventLocationFromFB,
                eventPointFromFB, eventDescriptionFromFB, eventImageFromFB);
        recyclerView.setAdapter(feedRecyclerAdapter);



    }


    public void getDataFromFireStore(){

        CollectionReference collectionReference = firebaseFireStore.collection("clubPageEvents");

        collectionReference.orderBy("postdate", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if(e != null){
                    Toast.makeText(clubfeedpage.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if(queryDocumentSnapshots != null){

                    for(DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()){

                        Map<String, Object> data = snapshot.getData();
                        String eventOwner = (String) data.get("eventowner");
                        String eventName = (String) data.get("eventname");
                        String eventDate = (String) data.get("eventdate");
                        String eventTime = (String) data.get("eventtime");
                        String eventLocation = (String) data.get("eventlocation");
                        String eventPoint = (String) data.get("eventpoint");
                        String eventDescription = (String) data.get("eventdescription");
                        String downloadUrl = (String) data.get("downloadurl");

                        eventOwnerFromFB.add(eventOwner);
                        eventNameFromFB.add(eventName);
                        eventDateFromFB.add(eventDate);
                        eventTimeFromFB.add(eventTime);
                        eventLocationFromFB.add(eventLocation);
                        eventPointFromFB.add(eventPoint);
                        eventDescriptionFromFB.add(eventDescription);
                        eventImageFromFB.add(downloadUrl);

                        feedRecyclerAdapter.notifyDataSetChanged();
                    }
                }

            }
        });




    }

    public void manClicked(View view){
        Intent intent = new Intent(clubfeedpage.this, studentfeedpage.class);
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

    public void addClicked(View view){
        Intent intent = new Intent(clubfeedpage.this, createeventpage.class);
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

    public void profileClicked(View view){
        Intent intent = new Intent(clubfeedpage.this, clubprofilepage.class);
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

    public void settingsClicked(View view){
        Intent intent = new Intent(clubfeedpage.this, settingspage.class);
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
