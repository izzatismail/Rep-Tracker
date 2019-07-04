package com.izzatismail.reptracker.Fragments;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
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
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.izzatismail.reptracker.Activities.AddNewRepActivity;
import com.izzatismail.reptracker.Activities.MainActivity;
import com.izzatismail.reptracker.Adapters.RepAdater;
import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.RepDialog;
import com.izzatismail.reptracker.Util.VerticalSpacingItemDecorator;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = "HomeFragment";
    private RepViewModel mViewModel;
    private FloatingActionButton mFab;
    private TextView mText, mText2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false); //For Fragments, you have to inflate the view first
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_rep);
        ((MainActivity)getActivity()).setActionBarTitle("Rep Tracker");
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(20);
        recyclerView.addItemDecoration(itemDecorator);
        mFab = rootView.findViewById(R.id.floatingAB);
        mText = rootView.findViewById(R.id.textNoData);
        mText2 = rootView.findViewById(R.id.textLast5);
        mFab.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        final RepAdater repAdater = new RepAdater();
        recyclerView.setAdapter(repAdater);

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getFiveReps().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(@Nullable List<Rep> reps) {
                //Update RecyclerView
                repAdater.submitList(reps);
                if(reps.isEmpty()){
                    mText.setVisibility(View.VISIBLE);
                    mText2.setVisibility(View.GONE);
                }else{
                    mText.setVisibility(View.GONE);
                    mText2.setVisibility(View.VISIBLE);
                }
            }
        });

        repAdater.setOnItemClickListener(new RepAdater.OnItemClickListener() {
            @Override
            public void onItemClick(Rep rep) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                RepDialog repDialog = RepDialog.newInstance(rep);
                Log.d(TAG, "onItemClick: Selected Note : " + rep.toString());

                repDialog.show(ft, "Rep Dialog");
            }
        });

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
