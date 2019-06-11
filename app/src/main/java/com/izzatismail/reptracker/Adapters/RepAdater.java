package com.izzatismail.reptracker.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.Utility;

import java.util.ArrayList;
import java.util.List;

public class RepAdater extends RecyclerView.Adapter<RepAdater.RepHolder> {

    private List<Rep> mRep = new ArrayList<>();

    @NonNull
    @Override
    public RepHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_rep_list_item, viewGroup, false);
        return new RepHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepHolder repHolder, int i) {
        Rep currentRep = mRep.get(i);
        repHolder.textTitle.setText(currentRep.getTitle());
        String day = currentRep.getTimestamp().substring(0,2);
        String month = currentRep.getTimestamp().substring(3,5);
        month = Utility.getMonthFromNumber(month);
        String year = currentRep.getTimestamp().substring(6,10);
        String timestamp = day + " " + month + " " + year;
        repHolder.textTimestamp.setText(timestamp);
    }

    @Override
    public int getItemCount() {
        return mRep.size();
    }

    public void setReps(List<Rep> reps){
        this.mRep = reps;
        notifyDataSetChanged();
    }

    public Rep getRepAt(int position){
        return mRep.get(position);
    }

    class RepHolder extends RecyclerView.ViewHolder{
        private TextView textTitle, textTimestamp;

        public RepHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.rep_title);
            textTimestamp = itemView.findViewById(R.id.rep_timestamp);
        }
    }
}
