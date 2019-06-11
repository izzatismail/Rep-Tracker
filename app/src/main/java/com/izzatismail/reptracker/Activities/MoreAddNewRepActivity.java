package com.izzatismail.reptracker.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.izzatismail.reptracker.R;
import com.izzatismail.reptracker.Util.Utility;

public class MoreAddNewRepActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "MoreAddNewRepActivity";

    private String mTraining, mBW, mbenchW, mbenchR, mbenchS,
            mrowW, mrowR, mrowS,
            mOHPW, mOHPR, mOHPS,
            msquatW, msquatR, msquatS,
            mdeadliftW, mdeadliftR, mdeadliftS;

    String CurlW, CurlR, CurlS, ExtW, ExtS,
            ExtR, PullR, PullS,
            PushR, PushS;

    private EditText mCurlW, mCurlR, mCurlS, mExtW, mExtS,
            mExtR, mPullR, mPullS,
            mPushR, mPushS;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_add_new_rep);

        getFromIntent();
        initWidgets();
    }

    private void getFromIntent() {
        Intent intent = getIntent();
        mTraining = intent.getStringExtra("Training Day");
        mBW = intent.getStringExtra("Bodyweight");
        mbenchW = intent.getStringExtra("Bench Weight");
        mbenchR = intent.getStringExtra("Bench Rep");
        mbenchS = intent.getStringExtra("Bench Set");
        mrowW = intent.getStringExtra("Row Weight");
        mrowR = intent.getStringExtra("Row Rep");
        mrowS = intent.getStringExtra("Row Set");
        mOHPW = intent.getStringExtra("OHP Weight");
        mOHPR = intent.getStringExtra("OHP Rep");
        mOHPS = intent.getStringExtra("OHP Set");
        msquatW = intent.getStringExtra("Squat Weight");
        msquatR = intent.getStringExtra("Squat Rep");
        msquatS = intent.getStringExtra("Squat Set");
        mdeadliftW = intent.getStringExtra("Deadlift Weight");
        mdeadliftR = intent.getStringExtra("Deadlift Rep");
        mdeadliftS = intent.getStringExtra("Deadlift Set");
    }

    public void toStringAndValidation(){
        CurlW = mCurlW.getText().toString();
        CurlR = mCurlR.getText().toString();
        CurlS = mCurlS.getText().toString();
        ExtW = mExtW.getText().toString();
        ExtS = mExtS.getText().toString();
        ExtR = mExtR.getText().toString();
        PullR = mPullR.getText().toString();
        PullS = mPullS.getText().toString();
        PushR = mPushR.getText().toString();
        PushS = mPushS.getText().toString();

        if(CurlW.equals("")) CurlW = "0";
        if(CurlR.equals("")) CurlR = "0";
        if(CurlS.equals("")) CurlS = "0";
        if(ExtW.equals("")) ExtW = "0";
        if(ExtS.equals("")) ExtS = "0";
        if(ExtR.equals("")) ExtR = "0";
        if(PullR.equals("")) PullR = "0";
        if(PullS.equals("")) PullS = "0";
        if(PushR.equals("")) PushR = "0";
        if(PushS.equals("")) PushS = "0";
    }

    @Override
    public void onClick(View v) {
        toStringAndValidation();

        String timestamp = Utility.getCurrentTimeStamp();
    }

    private void initWidgets() {
        mCurlW = findViewById(R.id.curl_weight_text);
        mCurlR = findViewById(R.id.curl_rep_text);
        mCurlS = findViewById(R.id.curl_set_text);
        mExtW = findViewById(R.id.ext_weight_text);
        mExtS = findViewById(R.id.ext_set_text);
        mExtR = findViewById(R.id.ext_rep_text);
        mPullR = findViewById(R.id.pullup_rep_text);
        mPullS = findViewById(R.id.pullup_set_text);
        mPushR = findViewById(R.id.pushup_rep_text);
        mPushS = findViewById(R.id.pushup_set_text);

        mButton = findViewById(R.id.button_save);
        mButton.setOnClickListener(this);
    }
}
