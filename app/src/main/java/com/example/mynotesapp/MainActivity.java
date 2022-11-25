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

import com.example.mynotesapp.dataBase.AppDataBase;
import com.example.mynotesapp.note.Note;
import com.example.mynotesapp.noteList.CardListData;
import com.example.mynotesapp.noteList.NoteListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    AppDataBase dataBase;
    List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addBtn;

        //DATE
//        SimpleDateFormat formatter = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
//        Date date = new Date();
//        notes.setDate(formatter.format(date));
        CardListData[] mylistData = new CardListData[]{
            new CardListData("toto","ttttttttttttttttttttt"),
            new CardListData("toto","ttttttttttttttttttttt"),
            new CardListData("toto","ttttttttttttttttttttt"),
        };



//        addBtn = findViewById(R.id.addBtn);
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,NoteTaker.class);
//                startActivityForResult(intent,101);
//            }
//        });


//        if(notes!=null){
//            for (int i = 0; i < notes.size(); i++) {
//                CardListData listData =new CardListData(notes.get(i).getTitle(),notes.get(i).getNote());
//            }
//        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        NoteListAdapter adapter = new NoteListAdapter(mylistData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==101){
//            if(resultCode == Activity.RESULT_OK){
//                Note new_note =  (Note) data.getSerializableExtra("note");
//                dataBase.noteDao().insertNote(new_note);
//                notes.addAll(dataBase.noteDao().getAllNotes());
//
//            }
//        }
//}
}