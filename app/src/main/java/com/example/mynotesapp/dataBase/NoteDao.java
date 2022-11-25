package com.example.mynotesapp.dataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mynotesapp.note.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert(onConflict = REPLACE)
    void insertNote(Note note);
    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();
//    @Query("UPDATE notes SET title=:title, notes=:notes WHERE ID=:id")
//    void update(int id, String title, String notes);
    @Delete
    void deletNote(Note note);
}
