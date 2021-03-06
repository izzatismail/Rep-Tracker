package com.izzatismail.reptracker.Persistences;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.izzatismail.reptracker.Models.Rep;

@Database(entities = {Rep.class}, version = 1)
public abstract class RepDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "rep_db";

    private static RepDatabase instance;

    public abstract RepDao getRepDao(); //To access Dao

    public static synchronized RepDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    RepDatabase.class,
                    DATABASE_NAME).fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
