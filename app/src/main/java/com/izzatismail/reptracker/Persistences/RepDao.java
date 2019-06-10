package com.izzatismail.reptracker.Persistences;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.izzatismail.reptracker.Models.Rep;

import java.util.List;

@Dao
public interface RepDao {

    @Insert
    void insert(Rep rep);

    @Update
    void update(Rep rep);

    @Delete
    void delete(Rep rep);

    @Query("SELECT * FROM rep_table")
    LiveData<List<Rep>> getAllRep();
}
