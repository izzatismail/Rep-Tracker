package com.izzatismail.reptracker.Persistences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import android.content.Context;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.Async.insertAsyncTask;
import com.izzatismail.reptracker.Async.DeleteAsyncTask;
import com.izzatismail.reptracker.Async.UpdateAsyncTask;

import java.util.List;

public class RepRepository {

    private RepDatabase mRepDatabase;

    public RepRepository(Context context){ mRepDatabase = RepDatabase.getInstance(context); }

    public void insert(Rep rep){
        new insertAsyncTask(mRepDatabase.getRepDao()).execute(rep);
    }

    public void update(Rep rep){
        new UpdateAsyncTask(mRepDatabase.getRepDao()).execute(rep);
    }

    public void delete(Rep rep){
        new DeleteAsyncTask(mRepDatabase.getRepDao()).execute(rep);
    }

    public LiveData<List<Rep>> retrieveRepTask(){
        return mRepDatabase.getRepDao().getAllRep();
    }
}
