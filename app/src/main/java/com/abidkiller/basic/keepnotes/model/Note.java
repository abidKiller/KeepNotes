package com.abidkiller.basic.keepnotes.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    Long Id;
    @ColumnInfo(name = "title")
    String title;
    @ColumnInfo(name = "description")
    String description;
    @ColumnInfo(name="date")
    String date;
    @ColumnInfo(name="pinned")
    Boolean pin;

    public Note(Long id, String title, String description, String date, Boolean pin) {
        Id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.pin = pin;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Boolean getPin() {
        return pin;
    }
}
