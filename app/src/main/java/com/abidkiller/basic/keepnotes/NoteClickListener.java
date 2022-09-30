package com.abidkiller.basic.keepnotes;

import androidx.cardview.widget.CardView;

import com.abidkiller.basic.keepnotes.model.Note;

public interface NoteClickListener {
    void  onClick(Note note);
    void onLongClick(Note note, CardView cardView);
}
