package com.abidkiller.basic.keepnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.abidkiller.basic.keepnotes.model.Note;

public class NoteTakeActivity extends AppCompatActivity {

    EditText editText_title,editText_Description;
    ImageView image_save;
    Note note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_take);
        image_save=findViewById(R.id.image_save);
        editText_title=findViewById(R.id.editText_title) ;
        editText_Description=findViewById(R.id.editText_Description);

        image_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title =editText_title.getText().toString();
                String description=editText_Description.getText().toString();

            }
        });

    }
}