package com.izzatismail.reptracker.Fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.izzatismail.reptracker.Activities.AddNewRepActivity;
import com.izzatismail.reptracker.Adapters.RepAdater;
import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.VerticalSpacingItemDecorator;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = "HomeFragment";
    private RepViewModel mViewModel;
    private FloatingActionButton mFab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false); //For Fragments, you have to inflate the view first
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_rep);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(20);
        recyclerView.addItemDecoration(itemDecorator);
        mFab = rootView.findViewById(R.id.floatingAB);
        mFab.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        final RepAdater repAdater = new RepAdater();
        recyclerView.setAdapter(repAdater);

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getAllReps().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(@Nullable List<Rep> reps) {
                //Update RecyclerView
                repAdater.setReps(reps);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mViewModel.delete(repAdater.getRepAt(viewHolder.getAdapterPosition())); //Swipe to delete
                Toast.makeText(getActivity(), "Record Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        return rootView;
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), AddNewRepActivity.class));
    }
}
