package com.abidkiller.basic.keepnotes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;

import com.abidkiller.basic.keepnotes.model.Note;

@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class RoomDb extends RoomDatabase {
    public static RoomDb database;
    public static String DATABASE_NAME="KeepNotes";

    public  synchronized static RoomDb getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(
                    context.getApplicationContext(),
                    RoomDb.class,
                    DATABASE_NAME
            ).allowMainThreadQueries().
                    fallbackToDestructiveMigration().
                    build();
        }

        return database;
    }


    public abstract MainDao getMainDao();

}
