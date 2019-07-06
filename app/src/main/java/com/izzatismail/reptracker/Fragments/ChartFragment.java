package com.izzatismail.reptracker.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.izzatismail.reptracker.Activities.MainActivity;
import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.Utility;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {

    public static final String TAG = "ChartFragment";
    private LineChart mLineChart;
    private RepViewModel mViewModel;
    private View rootView;
    private TextView mText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chart, container, false);
        setHasOptionsMenu(true);

        initChart(rootView);
        setCompoundChart();

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.chart_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.compoundMenu:
                setCompoundChart();
                ((MainActivity)getActivity()).setActionBarTitle("Compound Progress");
                return true;
            case R.id.isolationMenu:
                setIsolationChart();
                ((MainActivity)getActivity()).setActionBarTitle("Isolation Progress");
                return true;
            case R.id.bodyweightMenu:
                setBodyweightChart();
                ((MainActivity)getActivity()).setActionBarTitle("Bodyweight Progress");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void initChart(View view){
        mLineChart = view.findViewById(R.id.allChart);
        mLineChart.setDragEnabled(false);
        mLineChart.setScaleEnabled(false);
        mLineChart.getXAxis().setEnabled(false);
        mLineChart.getDescription().setEnabled(false);
        mLineChart.getAxisRight().setEnabled(false);
        mLineChart.setNoDataText("Loading Chart Data");
        mText = view.findViewById(R.id.textNoChartData);

        ((MainActivity)getActivity()).setActionBarTitle("Compound Progress");

    }

    public void setCompoundChart(){
        final ArrayList<Entry> yValuesBench = new ArrayList<>();
        final ArrayList<Entry> yValuesDeadlift = new ArrayList<>();
        final ArrayList<Entry> yValuesSquat = new ArrayList<>();
        final ArrayList<Entry> yValuesOHP = new ArrayList<>();
        final ArrayList<Entry> yValuesRow = new ArrayList<>();

        final ArrayList<String> dates = new ArrayList<>();

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getAllRepsAsc().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(final List<Rep> reps) {

                if(reps.isEmpty() || reps.size() < 3){
                    mText.setVisibility(View.VISIBLE);
                    mLineChart.setVisibility(View.GONE);
                }else{
                    for (int i = 0; i < reps.size(); i++) {
                        Log.d(TAG, "onChanged: reps : " + reps.get(i).toString());

                        Rep data = reps.get(i);

                        String day = data.getTimestamp().substring(8, 10);
                        String month = data.getTimestamp().substring(5, 7);
                        month = Utility.getMonthFromNumber(month);
                        String timestamp = day + " " + month;
                        dates.add(timestamp);

                        Float benchWeight = (Float) Float.parseFloat(data.getBenchWeight());
                        Float dlWeight = (Float) Float.parseFloat(data.getDeadliftWeight());
                        Float squatWeight = (Float) Float.parseFloat(data.getSquatWeight());
                        Float rowWeight = (Float) Float.parseFloat(data.getRowWeight());
                        Float ohpWeight = (Float) Float.parseFloat(data.getOHPWeight());

                        if (benchWeight != 0.0) {
                            yValuesBench.add(new Entry(i, benchWeight));
                        }

                        if (dlWeight != 0.0) {
                            yValuesDeadlift.add(new Entry(i, dlWeight));
                        }

                        if (squatWeight != 0.0) {
                            yValuesSquat.add(new Entry(i, squatWeight));
                        }

                        if (rowWeight != 0.0) {
                            yValuesRow.add(new Entry(i, rowWeight));
                        }

                        if (ohpWeight != 0.0) {
                            yValuesOHP.add(new Entry(i, ohpWeight));
                        }
                    }

                    LineDataSet set1 = new LineDataSet(yValuesBench, "Bench Press");
                    set1.setFillAlpha(110);
                    set1.setColor(Color.RED);
                    set1.setDrawCircles(false);
                    set1.setDrawValues(false);
                    set1.setLineWidth(3f);

                    LineDataSet set2 = new LineDataSet(yValuesDeadlift, "Deadlift");
                    set2.setFillAlpha(110);
                    set2.setColor(Color.BLUE);
                    set2.setDrawCircles(false);
                    set2.setDrawValues(false);
                    set2.setLineWidth(3f);

                    LineDataSet set3 = new LineDataSet(yValuesSquat, "Squat");
                    set3.setFillAlpha(110);
                    set3.setColor(Color.GRAY);
                    set3.setDrawCircles(false);
                    set3.setDrawValues(false);
                    set3.setLineWidth(3f);

                    LineDataSet set4 = new LineDataSet(yValuesRow, "Row");
                    set4.setFillAlpha(110);
                    set4.setColor(Color.MAGENTA);
                    set4.setDrawCircles(false);
                    set4.setDrawValues(false);
                    set4.setLineWidth(3f);

                    LineDataSet set5 = new LineDataSet(yValuesOHP, "OHP");
                    set5.setFillAlpha(110);
                    set5.setColor(Color.GREEN);
                    set5.setDrawCircles(false);
                    set5.setDrawValues(false);
                    set5.setLineWidth(3f);

                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                    dataSets.add(set1);
                    dataSets.add(set2);
                    dataSets.add(set3);
                    dataSets.add(set4);
                    dataSets.add(set5);

                    LineData lineData = new LineData(dataSets);
                    mLineChart.invalidate();
                    mLineChart.setData(lineData);
                    mLineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Toast.makeText(rootView.getContext(), "Weight : " + e.getY() + "kg", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected() {

                        }
                    });
                }
            }
        });
    }

    public void setIsolationChart(){
        final ArrayList<Entry> yValuesCurl = new ArrayList<>();
        final ArrayList<Entry> yValuesExt = new ArrayList<>();
        final ArrayList<String> dates = new ArrayList<>();

        mViewModel.getAllRepsAsc().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(final List<Rep> reps) {

                if(reps.isEmpty() || reps.size() < 3){
                    mText.setVisibility(View.VISIBLE);
                    mLineChart.setVisibility(View.GONE);
                }else {
                    for (int i = 0; i < reps.size(); i++) {
                        Log.d(TAG, "onChanged: reps : " + reps.get(i).toString());

                        Rep data = reps.get(i);

                        String day = data.getTimestamp().substring(8, 10);
                        String month = data.getTimestamp().substring(5, 7);
                        month = Utility.getMonthFromNumber(month);
                        String timestamp = day + " " + month;
                        dates.add(timestamp);

                        Float curlWeight = (Float) Float.parseFloat(data.getCurlWeight());
                        Float extWeight = (Float) Float.parseFloat(data.getExtWeight());

                        if (curlWeight != 0.0) {
                            yValuesCurl.add(new Entry(i, curlWeight));
                        }

                        if (extWeight != 0.0) {
                            yValuesExt.add(new Entry(i, extWeight));
                        }
                    }

                    LineDataSet set1 = new LineDataSet(yValuesCurl, "Curl");
                    set1.setFillAlpha(110);
                    set1.setColor(Color.RED);
                    set1.setDrawCircles(false);
                    set1.setDrawValues(false);
                    set1.setLineWidth(3f);

                    LineDataSet set2 = new LineDataSet(yValuesExt, "Extension");
                    set2.setFillAlpha(110);
                    set2.setColor(Color.BLUE);
                    set2.setDrawCircles(false);
                    set2.setDrawValues(false);
                    set2.setLineWidth(3f);

                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                    dataSets.add(set1);
                    dataSets.add(set2);

                    LineData lineData = new LineData(dataSets);
                    mLineChart.invalidate();
                    mLineChart.setData(lineData);
                    mLineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Toast.makeText(rootView.getContext(), "Weight : " + e.getY() + "kg", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected() {

                        }
                    });
                }
            }
        });
    }

    public void setBodyweightChart(){
        final ArrayList<Entry> yValuesPushUp = new ArrayList<>();
        final ArrayList<Entry> yValuesPullUp = new ArrayList<>();

        final ArrayList<String> dates = new ArrayList<>();

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mViewModel.getAllRepsAsc().observe(this, new Observer<List<Rep>>() {
            @Override
            public void onChanged(final List<Rep> reps) {

                if(reps.isEmpty() || reps.size() < 3){
                    mText.setVisibility(View.VISIBLE);
                    mLineChart.setVisibility(View.GONE);
                }else {
                    for (int i = 0; i < reps.size(); i++) {
                        Log.d(TAG, "onChanged: reps : " + reps.get(i).toString());

                        Rep data = reps.get(i);

                        String day = data.getTimestamp().substring(8, 10);
                        String month = data.getTimestamp().substring(5, 7);
                        month = Utility.getMonthFromNumber(month);
                        String timestamp = day + " " + month;
                        dates.add(timestamp);

                        Float pushUp = (Float) Float.parseFloat(data.getPushupRep());
                        Float pullUp = (Float) Float.parseFloat(data.getPullupRep());

                        if (pushUp != 0.0) {
                            yValuesPushUp.add(new Entry(i, pushUp));
                        }

                        if (pullUp != 0.0) {
                            yValuesPullUp.add(new Entry(i, pullUp));
                        }
                    }

                    LineDataSet set1 = new LineDataSet(yValuesPushUp, "Push Up Rep");
                    set1.setFillAlpha(110);
                    set1.setColor(Color.RED);
                    set1.setDrawCircles(false);
                    set1.setDrawValues(false);
                    set1.setLineWidth(3f);

                    LineDataSet set2 = new LineDataSet(yValuesPullUp, "Pull Up Rep");
                    set2.setFillAlpha(110);
                    set2.setColor(Color.BLUE);
                    set2.setDrawCircles(false);
                    set2.setDrawValues(false);
                    set2.setLineWidth(3f);

                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                    dataSets.add(set1);
                    dataSets.add(set2);

                    LineData lineData = new LineData(dataSets);
                    mLineChart.invalidate();
                    mLineChart.setData(lineData);
                    mLineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Toast.makeText(rootView.getContext(), (int) e.getY() + " reps", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected() {

                        }
                    });
                }
            }
        });
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
