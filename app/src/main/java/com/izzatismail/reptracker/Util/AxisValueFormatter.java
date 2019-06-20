package com.izzatismail.reptracker.Util;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class AxisValueFormatter extends ValueFormatter {
    private ArrayList<String> mValues;
    public AxisValueFormatter(ArrayList<String> values){
        this.mValues = values;
    }

    @Override
    public String getFormattedValue(float value) {
        return mValues.get((int) value);
    }
}
