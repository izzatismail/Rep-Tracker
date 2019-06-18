package com.izzatismail.reptracker.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
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

public class RepAdater extends ListAdapter<Rep, RepAdater.RepHolder> {
    private OnItemClickListener listener;

    public RepAdater() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Rep> DIFF_CALLBACK = new DiffUtil.ItemCallback<Rep>() {
        @Override
        public boolean areItemsTheSame(@NonNull Rep oldItem, @NonNull Rep newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Rep oldItem, @NonNull Rep newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getTimestamp().equals(newItem.getTimestamp());
        }
    };

    @NonNull
    @Override
    public RepHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_rep_list_item, viewGroup, false);
        return new RepHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepHolder repHolder, int i) {
        Rep currentRep = getItem(i);
        repHolder.textTitle.setText(currentRep.getTitle());
        String day = currentRep.getTimestamp().substring(0,2);
        String month = currentRep.getTimestamp().substring(3,5);
        month = Utility.getMonthFromNumber(month);
        String year = currentRep.getTimestamp().substring(6,10);
        String timestamp = day + " " + month + " " + year;
        repHolder.textTimestamp.setText(timestamp);
    }

    public Rep getRepAt(int position){
        return getItem(position);
    }

    class RepHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textTitle, textTimestamp;

        public RepHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.rep_title);
            textTimestamp = itemView.findViewById(R.id.rep_timestamp);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(listener != null && position != RecyclerView.NO_POSITION)
                listener.onItemClick(getItem(position));
        }
    }

    /* Best practice for onClickListener for best performance */
    public interface OnItemClickListener{
        void onItemClick(Rep rep);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
