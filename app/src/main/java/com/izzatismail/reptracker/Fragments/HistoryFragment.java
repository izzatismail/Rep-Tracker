package com.izzatismail.reptracker.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.izzatismail.reptracker.Activities.MainActivity;
import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.RepDialog;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryFragment extends Fragment implements CompactCalendarView.CompactCalendarViewListener {

    private static final String TAG = "HistoryFragment";
    private RepViewModel mViewModel;
    private CompactCalendarView mCompactCalendarView;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
    private View rootView;
    private Long millis;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_history, container, false);

        mCompactCalendarView = (CompactCalendarView)rootView.findViewById(R.id.calendar_rep);

        ((MainActivity)getActivity()).setActionBarTitle(simpleDateFormat.format(mCompactCalendarView.getFirstDayOfCurrentMonth()));

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getAllReps().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(List<Rep> reps) {
                for (int i=0; i<reps.size(); i++) {

                    Rep data = reps.get(i);

                    String day = data.getTimestamp().substring(8,10);
                    String month = data.getTimestamp().substring(5,7);
                    String year = data.getTimestamp().substring(0,4);
                    String timestamp = month + "/" + day + "/" + year;

                    try {
                        millis = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).parse(timestamp).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Event event = new Event(Color.RED, millis, data);
                    mCompactCalendarView.addEvent(event);
                }
            }
        });

        mCompactCalendarView.setListener(this);

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
    public void onDayClick(Date dateClicked) {
        List<Event> events = mCompactCalendarView.getEvents(dateClicked);
        if(!events.isEmpty()){
            Rep data = (Rep)events.get(0).getData();

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);

            RepDialog repDialog = RepDialog.newInstance(data);
            Log.d(TAG, "onDayClick: Selected Note : " + data.toString());

            repDialog.show(ft, "Rep Dialog");
        }else{
            Toast.makeText(getActivity(), "No Workout Added", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMonthScroll(Date firstDayOfNewMonth) {
        ((MainActivity)getActivity()).setActionBarTitle(simpleDateFormat.format(firstDayOfNewMonth));
    }
}
