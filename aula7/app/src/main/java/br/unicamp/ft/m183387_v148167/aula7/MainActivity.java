package br.unicamp.ft.m183387_v148167.aula7;

import android.content.Intent;
import android.os.Debug;
import android.support.v4.util.DebugUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMain;

    private TextView textViewMain;

    private Button button_Save, button_Load, buttonActivity2;

    private String texto;

    private int onCreateTimes, onAStartTimes, onResumeTimes, onPauseTimes, onStopTimes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMain = findViewById(R.id.editTextMainAc);
        textViewMain = findViewById(R.id.textViewMainAc);

        texto = (savedInstanceState != null ? savedInstanceState.getString("texto") : " ");
        onCreateTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onCreateTimes") : 0);
        onResumeTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onResumeTimes") : 0);
        onPauseTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onPauseTimes") : 0);
        onStopTimes  = (savedInstanceState != null ? savedInstanceState.getInt("onStopTimes") : 0);

        textViewMain.setText(texto);

        button_Save = findViewById(R.id.buttonSaveMainAc);
        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTexto(editTextMain.getText().toString());
            }
        });

        button_Load = findViewById(R.id.buttonLoadMainAc);
        button_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewMain.setText(getTexto());

            }
        });

        buttonActivity2 = findViewById(R.id.buttonActivity2);
        buttonActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity2Intent = new Intent(MainActivity.this, Activity2.class);
                Activity2Intent.putExtra("onCreateTimes", getOnCreateTimes());
                Activity2Intent.putExtra("onResumeTimes", getOnResumeTimes());
                Activity2Intent.putExtra("onPauseTimes", getOnPauseTimes());
                Activity2Intent.putExtra("onStopTimes", getOnStopTimes());
                startActivity(Activity2Intent);
            }
        });
        setOnCreateTimes(getOnCreateTimes()+1);

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
        super.onPause();;
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
        savedInstanceState.putString("texto", getTexto());
        savedInstanceState.putInt("onResumeTimes", getOnResumeTimes());
        savedInstanceState.putInt("onCreateTimes", getOnCreateTimes());
        savedInstanceState.putInt("onPauseTimes", getOnPauseTimes());
        savedInstanceState.putInt("onStopTimes", getOnStopTimes());

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.out.println("ON DESTROY  " + getTexto());

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
