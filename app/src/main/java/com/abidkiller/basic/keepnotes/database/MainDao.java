package com.abidkiller.basic.keepnotes.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.abidkiller.basic.keepnotes.model.Note;

import java.util.List;

@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(Note note);
    @Query("Select * from note order by id desc")
    List<Note> getNotes();

    @Query("Update note set title=:title, description=:description where id=:id")
    void updateNote(Long id,String title,String description);

    @Delete
    void deleteNote(Note note);


}
