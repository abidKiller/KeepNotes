package com.abidkiller.basic.keepnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abidkiller.basic.keepnotes.adapter.NotesAdapter;
import com.abidkiller.basic.keepnotes.database.RoomDb;
import com.abidkiller.basic.keepnotes.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    List<Note> notes = new ArrayList<>();
    RoomDb database;
    FloatingActionButton home_float_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.home_float_button);
        home_float_button=findViewById(R.id.home_float_button);
        database=RoomDb.getInstance(this);
        notes=database.getMainDao().getNotes();

        updateRecycler(notes);

        home_float_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NoteTakeActivity.class);
                startActivityForResult(intent,101); // 101 for adding 102 for editing
            }
        });
    }

    private void updateRecycler(List<Note> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

        notesAdapter=new NotesAdapter(MainActivity.this,notes,noteClickListener);
        recyclerView.setAdapter(notesAdapter);




    }

    final NoteClickListener noteClickListener= new NoteClickListener(){

        @Override
        public void onClick(Note note) {

        }

        @Override
        public void onLongClick(Note note, CardView cardView) {

        }
    };
}