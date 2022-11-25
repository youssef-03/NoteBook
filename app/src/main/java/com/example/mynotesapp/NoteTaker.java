package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mynotesapp.dataBase.AppDataBase;
import com.example.mynotesapp.note.Note;
import com.example.mynotesapp.noteList.CardListData;

import java.io.Serializable;

public class NoteTaker extends AppCompatActivity implements Serializable {
    EditText title, note;
    ImageView save;
    AppDataBase dataBase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_taker);


        title = findViewById(R.id.title);
        note = findViewById(R.id.note);
        save = findViewById(R.id.saveBtn);

        dataBase = AppDataBase.getInstance(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating the note

                Note actualNote = new Note();
                actualNote.setTitle(title.getText().toString());
                actualNote.setNote(note.getText().toString());

                //inserting the note in the database
                try{
                    dataBase.noteDao().insertNote(actualNote);
                }
                catch (Exception e){
                    Toast.makeText(NoteTaker.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

                //start an intent
                Intent intent = new Intent(NoteTaker.this,MainActivity.class);
                intent.putExtra("note",actualNote);
                startActivity(intent);
                finish();}
        });


}
}