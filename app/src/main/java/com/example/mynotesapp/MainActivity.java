package com.example.mynotesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mynotesapp.dataBase.AppDataBase;
import com.example.mynotesapp.note.Note;
import com.example.mynotesapp.noteList.CardListData;
import com.example.mynotesapp.noteList.NoteListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    AppDataBase dataBase;
    List<Note> notes;
    List<CardListData> mylistData2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addBtn;
        dataBase = AppDataBase.getInstance(this);

        //DATE
//        SimpleDateFormat formatter = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
//        Date date = new Date();
//        notes.setDate(formatter.format(date));



        //addong button :
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NoteTaker.class);
                startActivity(intent);
            }
        });


        notes = dataBase.noteDao().getAllNotes();
        for(int i=0; i<=notes.size()-1;i++){
            mylistData2.add(new CardListData(notes.get(i).getTitle(),notes.get(i).getNote()));
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        NoteListAdapter adapter = new NoteListAdapter(mylistData2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        Note new_note = (Note) getIntent().getSerializableExtra("note");
        if(new_note!=null){
            Toast.makeText(this, "note: "+dataBase.noteDao().getAllNotes().get(dataBase.noteDao().getAllNotes().size()-1).getTitle(), Toast.LENGTH_SHORT).show();
        }


    }

}