package com.izzatismail.reptracker.ViewModels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.Persistences.RepRepository;

import java.util.List;

public class RepViewModel extends AndroidViewModel {
    private RepRepository mRepRepo;
    private LiveData<List<Rep>> mReps;
    private LiveData<List<Rep>> mRep5;
    private LiveData<List<Rep>> mRepsAsc;

    public RepViewModel(@NonNull Application application) {
        super(application);
        mRepRepo = new RepRepository(application);
        mReps = mRepRepo.retrieveRepTask();
        mRep5 = mRepRepo.retrieveFiveRepTask();
        mRepsAsc = mRepRepo.retrieveRepTaskAsc();
    }

    public void insert(Rep rep){
        mRepRepo.insert(rep);
    }

    public void update(Rep rep){
        mRepRepo.update(rep);
    }

    public void delete(Rep rep){
        mRepRepo.delete(rep);
    }

    public LiveData<List<Rep>> getAllReps(){
        return mReps;
    }

    public LiveData<List<Rep>> getFiveReps(){
        return mRep5;
    }

    public LiveData<List<Rep>> getAllRepsAsc(){
        return mRepsAsc;
    }
}
