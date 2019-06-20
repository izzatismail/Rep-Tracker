package com.izzatismail.reptracker.Persistences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("SELECT * FROM rep_table ORDER BY timestamp DESC")
    LiveData<List<Rep>> getAllRep();

    @Query("SELECT * FROM rep_table ORDER BY timestamp ASC")
    LiveData<List<Rep>> getAllRepAsc();
}
