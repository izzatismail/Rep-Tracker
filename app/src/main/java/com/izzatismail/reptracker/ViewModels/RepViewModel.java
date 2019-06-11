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

    public RepViewModel(@NonNull Application application) {
        super(application);
        mRepRepo = new RepRepository(application);
        mReps = mRepRepo.retrieveRepTask();
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
}
