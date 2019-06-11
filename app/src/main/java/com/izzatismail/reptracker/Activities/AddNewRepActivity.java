package com.izzatismail.reptracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.izzatismail.reptracker.R;

public class AddNewRepActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mTraining, mBW, mbenchW, mbenchR, mbenchS,
            mrowW, mrowR, mrowS,
            mOHPW, mOHPR, mOHPS,
            msquatW, msquatR, msquatS,
            mdeadliftW, mdeadliftR, mdeadliftS;

    private Button mButton;
    private TextInputLayout mTrainingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_rep);

        initWidgets();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow);
        setTitle(R.string.new_data);
    }

    private void initWidgets() {
        mTraining = findViewById(R.id.field_trainingday_text);
        mBW = findViewById(R.id.field_weight_text);
        mbenchW = findViewById(R.id.bench_weight_text);
        mbenchR = findViewById(R.id.bench_rep_text);
        mbenchS = findViewById(R.id.bench_set_text);
        mrowW = findViewById(R.id.row_weight_text);
        mrowR = findViewById(R.id.row_rep_text);
        mrowS = findViewById(R.id.row_set_text);
        mOHPW = findViewById(R.id.ohp_weight_text);
        mOHPR = findViewById(R.id.ohp_rep_text);
        mOHPS = findViewById(R.id.ohp_set_text);
        msquatW = findViewById(R.id.squat_weight_text);
        msquatR = findViewById(R.id.squat_rep_text);
        msquatS = findViewById(R.id.squat_set_text);
        mdeadliftW = findViewById(R.id.deadlift_weight_text);
        mdeadliftR = findViewById(R.id.deadlift_rep_text);
        mdeadliftS = findViewById(R.id.deadlift_set_text);

        mTrainingLayout = findViewById(R.id.field_trainingday);
        mButton = findViewById(R.id.button_next);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AddNewRepActivity.this, MoreAddNewRepActivity.class);

        String training, BW, benchW, benchR, benchS,
                rowW, rowR, rowS,
                OHPW, OHPR, OHPS,
                squatW, squatR, squatS,
                deadliftW, deadliftR, deadliftS;

        training = mTraining.getText().toString();
        BW = mBW.getText().toString();
        benchW = mbenchW.getText().toString();
        benchR = mbenchR.getText().toString();
        benchS = mbenchS.getText().toString();
        rowW = mrowW.getText().toString();
        rowR = mrowR.getText().toString();
        rowS = mrowS.getText().toString();
        OHPW = mOHPW.getText().toString();
        OHPR = mOHPR.getText().toString();
        OHPS = mOHPS.getText().toString();
        squatW = msquatW.getText().toString();
        squatR = msquatR.getText().toString();
        squatS = msquatS.getText().toString();
        deadliftW = mdeadliftW.getText().toString();
        deadliftR = mdeadliftR.getText().toString();
        deadliftS = mdeadliftS.getText().toString();

        if(training.equals("")) {
            mTrainingLayout.setError("Field must be filled");
            return;
        }
        if(BW.equals("")) BW = "0";
        if(benchW.equals("")) benchW = "0";
        if(benchR.equals("")) benchR = "0";
        if(benchS.equals("")) benchS = "0";
        if(rowW.equals("")) rowW = "0";
        if(rowR.equals("")) rowR = "0";
        if(rowS.equals("")) rowS = "0";
        if(OHPW.equals("")) OHPW = "0";
        if(OHPR.equals("")) OHPR = "0";
        if(OHPS.equals("")) OHPS = "0";
        if(squatW.equals("")) squatW = "0";
        if(squatR.equals("")) squatR = "0";
        if(squatS.equals("")) squatS = "0";
        if(deadliftW.equals("")) deadliftW = "0";
        if(deadliftR.equals("")) deadliftR = "0";
        if(deadliftS.equals("")) deadliftS = "0";

        intent.putExtra("Training Day", training);
        intent.putExtra("Bodyweight", BW);
        intent.putExtra("Bench Weight", benchW);
        intent.putExtra("Bench Rep", benchR);
        intent.putExtra("Bench Set", benchS);
        intent.putExtra("Row Weight", rowW);
        intent.putExtra("Row Rep", rowR);
        intent.putExtra("Row Set", rowS);
        intent.putExtra("OHP Weight", OHPW);
        intent.putExtra("OHP Rep", OHPR);
        intent.putExtra("OHP Set", OHPS);
        intent.putExtra("Squat Weight", squatW);
        intent.putExtra("Squat Rep", squatR);
        intent.putExtra("Squat Set", squatS);
        intent.putExtra("Deadlift Weight", deadliftW);
        intent.putExtra("Deadlift Rep", deadliftR);
        intent.putExtra("Deadlift Set", deadliftS);

        startActivity(intent);
    }
}
