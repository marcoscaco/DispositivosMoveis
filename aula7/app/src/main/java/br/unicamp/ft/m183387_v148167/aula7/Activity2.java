package br.unicamp.ft.m183387_v148167.aula7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private TextView textViewonCreateTimes;
    private Button button2;
    private int onCreateTimes, onAStartTimes, onResumeTimes, onPauseTimes, onStopTimes;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textViewonCreateTimes = findViewById(R.id.textViewInfos);

        setOnCreateTimes(getOnCreateTimes()+1);

        onCreateTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onCreateTimesActivity2") : 0);
        onResumeTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onResumeTimesActivity2") : 0);
        onPauseTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onPauseTimeActivity2s") : 0);
        onStopTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onStopTimesActivity2") : 0);

        textViewonCreateTimes.setText(getInfos(savedInstanceState));

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               textViewonCreateTimes.setText(getInfos(savedInstanceState));
            }
        });


    }

    private String getInfos(Bundle savedInstanceState){
        Intent Activity2Intent = getIntent();
        String infos = ""
                + "Activity1 '\n'"
                + "OnCreate: "
                + ((Integer) Activity2Intent.getIntExtra("onCreateTimes", 0)).toString()
                + "'\n'"
                + "OnStart: "
                + ((Integer) Activity2Intent.getIntExtra("onStartTimes", 0)).toString()
                + "'\n'"
                + "OnResume: "
                + ((Integer) Activity2Intent.getIntExtra("onResumeTimes", 0)).toString()
                + "'\n'"
                + "OnPause: "
                + ((Integer) Activity2Intent.getIntExtra("onPauseTimes", 0)).toString()
                + "'\n'"
                + "OnStop: "
                + ((Integer) Activity2Intent.getIntExtra("onCreateTimes", 0)).toString()
                + '\n'
                + '\n'
                + '\n'
                + "Activity2 '\n'"
                + "OnCreate: "
                + (savedInstanceState != null ? ((Integer) savedInstanceState.getInt("onCreateTimesActivity2", 0)).toString() : "")
                + "'\n'"
                + "OnStart: "
                + (savedInstanceState != null ? ((Integer) savedInstanceState.getInt("onStartTimesActivity2", 0)).toString() : "")
                + "'\n'"
                + "OnResume: "
                + (savedInstanceState != null ? ((Integer) savedInstanceState.getInt("onResumeTimesActivity2", 0)).toString() : "")
                + "'\n'"
                + "OnPause: "
                + (savedInstanceState != null ? ((Integer) savedInstanceState.getInt("onPauseTimesActivity2", 0)).toString() : "")
                + "'\n'"
                + "OnStop: "
                + (savedInstanceState != null ? ((Integer) savedInstanceState.getInt ("onCreateTimesActivity2", 0)).toString() : "")
        ;
        return infos;
    }

    @Override
    protected void onStart(){
        super.onStart();
        setOnCreateTimes(getOnCreateTimes()+1);
    }

    @Override
    protected void onResume(){
        super.onResume();
        setOnResumeTimes(getOnResumeTimes()+1);

    }

    @Override
    protected void onPause(){
        super.onPause();
        setOnPauseTimes(getOnPauseTimes()+1);
    }

    @Override
    protected void onStop(){
        super.onStop();
        setOnStopTimes(getOnStopTimes()+1);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("onResumeTimesActivity2", getOnResumeTimes());
        savedInstanceState.putInt("onCreateTimesActivity2", getOnCreateTimes());
        savedInstanceState.putInt("onPauseTimesActivity2", getOnPauseTimes());
        savedInstanceState.putInt("onStopTimesActivity2", getOnStopTimes());

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    public int getOnCreateTimes() {
        return onCreateTimes;
    }

    public void setOnCreateTimes(int onCreateTimes) {
        this.onCreateTimes = onCreateTimes;
    }

    public int getOnAStartTimes() {
        return onAStartTimes;
    }

    public void setOnAStartTimes(int onAStartTimes) {
        this.onAStartTimes = onAStartTimes;
    }

    public int getOnResumeTimes() {
        return onResumeTimes;
    }

    public void setOnResumeTimes(int onResumeTimes) {
        this.onResumeTimes = onResumeTimes;
    }

    public int getOnPauseTimes() {
        return onPauseTimes;
    }

    public void setOnPauseTimes(int onPauseTimes) {
        this.onPauseTimes = onPauseTimes;
    }

    public int getOnStopTimes() {
        return onStopTimes;
    }

    public void setOnStopTimes(int onStopTimes) {
        this.onStopTimes = onStopTimes;
    }

}
