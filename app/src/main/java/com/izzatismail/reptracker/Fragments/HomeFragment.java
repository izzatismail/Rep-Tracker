package com.izzatismail.reptracker.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";
    private RepViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getAllReps().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(@Nullable List<Rep> reps) {
                //Update RecyclerView
                Toast.makeText(getContext(), "OnChanged", Toast.LENGTH_SHORT).show();
            }
        });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    /* Lifecycle */
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: called");
    }
}
