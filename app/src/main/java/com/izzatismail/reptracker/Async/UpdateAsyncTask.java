package com.izzatismail.reptracker.Async;

import android.os.AsyncTask;
import android.util.Log;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.Persistences.RepDao;

public class UpdateAsyncTask extends AsyncTask<Rep, Void, Void> {

    private static final String TAG = "insertAsyncTask";

    private RepDao mDao;
    public UpdateAsyncTask(RepDao dao) {
        mDao = dao;
    }

    @Override
    protected Void doInBackground(Rep... reps) {
        Log.d(TAG, "doInBackground: thread : " + Thread.currentThread().getName());
        mDao.update(reps[0]);
        return null;
    }
}

//Best for executing a single task