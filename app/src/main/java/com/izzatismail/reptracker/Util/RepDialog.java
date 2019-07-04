package com.izzatismail.reptracker.Util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.izzatismail.reptracker.Models.Rep;
import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.ViewModels.RepViewModel;

public class RepDialog extends DialogFragment {

    public static final String TAG = "RepDialog";
    private RepViewModel mViewModel;

    private TextView mBenchW, mBenchR, mBenchS, mRowW, mRowR, mRowS,
        mOHPW, mOHPR, mOHPS, mSquatR, mSquatW, mSquatS,
        mDLW, mDLR, mDLS, mCurlW, mCurlS, mCurlR,
        mExtW, mExtR, mExtS, mPullR, mPullS, mPushR, mPushS,
        mBodyweight;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_selected_day, null);

        mViewModel = ViewModelProviders.of(this).get(RepViewModel.class);

        Bundle bundle = getArguments();
        final Rep rep = bundle.getParcelable("Selected Rep");
        Log.d(TAG, "onCreateDialog: Parsed note : " + rep.toString());

        initializeWidget(view);
        setWidget(rep);

        builder.setView(view)
                .setTitle(rep.getTitle())
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mViewModel.delete(rep);
                        Toast.makeText(getActivity(), "Workout Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }



    private void initializeWidget(View view) {
        mBenchW = view.findViewById(R.id.benchDialog_weightText);
        mBenchR = view.findViewById(R.id.benchDialog_repText);
        mBenchS = view.findViewById(R.id.benchDialog_setText);

        mRowW = view.findViewById(R.id.rowDialog_weightText);
        mRowR = view.findViewById(R.id.rowDialog_repText);
        mRowS = view.findViewById(R.id.rowDialog_setText);

        mOHPW = view.findViewById(R.id.ohpDialog_weightText);
        mOHPR = view.findViewById(R.id.ohpDialog_repText);
        mOHPS = view.findViewById(R.id.ohpDialog_setText);

        mSquatW = view.findViewById(R.id.squatDialog_weightText);
        mSquatR = view.findViewById(R.id.squatDialog_repText);
        mSquatS = view.findViewById(R.id.squatDialog_setText);

        mDLW = view.findViewById(R.id.dlDialog_weightText);
        mDLR = view.findViewById(R.id.dlDialog_repText);
        mDLS = view.findViewById(R.id.dlDialog_setText);

        mCurlW = view.findViewById(R.id.curlDialog_weightText);
        mCurlR = view.findViewById(R.id.curlDialog_repText);
        mCurlS = view.findViewById(R.id.curlDialog_setText);

        mExtW = view.findViewById(R.id.extDialog_weightText);
        mExtR = view.findViewById(R.id.extDialog_repText);
        mExtS = view.findViewById(R.id.extDialog_setText);

        mPullR = view.findViewById(R.id.pullDialog_repText);
        mPullS = view.findViewById(R.id.pullDialog_setText);

        mPushR = view.findViewById(R.id.pushDialog_repText);
        mPushS = view.findViewById(R.id.pushDialog_setText);

        mBodyweight = view.findViewById(R.id.bodyDialog_weightText);
    }

    private void setWidget(Rep rep) {
        mBenchW.setText(rep.getBenchWeight());
        mBenchR.setText(rep.getBenchRep());
        mBenchS.setText(rep.getBenchSet());

        mRowW.setText(rep.getRowWeight());
        mRowR.setText(rep.getRowRep());
        mRowS.setText(rep.getRowSet());

        mOHPW.setText(rep.getOHPWeight());
        mOHPR.setText(rep.getOHPRep());
        mOHPS.setText(rep.getOHPSet());

        mSquatW.setText(rep.getSquatWeight());
        mSquatR.setText(rep.getSquatRep());
        mSquatS.setText(rep.getSquatSet());

        mDLW.setText(rep.getDeadliftWeight());
        mDLR.setText(rep.getDeadliftRep());
        mDLS.setText(rep.getDeadliftSet());

        mCurlW.setText(rep.getCurlWeight());
        mCurlR.setText(rep.getCurlRep());
        mCurlS.setText(rep.getCurlSet());

        mExtW.setText(rep.getExtWeight());
        mExtR.setText(rep.getExtRep());
        mExtS.setText(rep.getExtSet());

        mPullR.setText(rep.getPullupRep());
        mPullS.setText(rep.getPullupSet());

        mPushR.setText(rep.getPushupRep());
        mPushS.setText(rep.getPushupSet());

        mBodyweight.setText(rep.getBodyweight());
    }

    public static RepDialog newInstance(Rep rep) {
        RepDialog fragment = new RepDialog();

        Bundle bundle = new Bundle();
        bundle.putParcelable("Selected Rep", rep);
        fragment.setArguments(bundle);

        return fragment;
    }
}
