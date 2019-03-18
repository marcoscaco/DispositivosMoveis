package br.unicamp.ft.m183387.aula2;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;
    private EditText editTextLogin;
    private EditText editTextPass;
    private EditText editTextMessage;
    private EditText editTextDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // enviar formulario
        btnEnviar = findViewById(R.id.send_button);
        btnEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        editTextLogin = findViewById(R.id.editTextLogin);
                        editTextPass = findViewById(R.id.editTextPassword);
                        editTextMessage = findViewById(R.id.message);
                        editTextDest = findViewById(R.id.dest);
                        if (!editTextPass.getText().toString().matches(" ")){
                            new GmailSend(
                                    editTextLogin.getText().toString(),
                                    editTextPass.getText().toString(),
                                    editTextDest.getText().toString(),
                                    "VIA AULA2 SI701",
                                    editTextMessage.getText().toString()
                            );
                            Toast messsageToast = Toast.makeText(v.getContext(),
                                    "OK", Toast.LENGTH_LONG);
                            messsageToast.show();
                        }
                        else {
                            Toast messsageToast = Toast.makeText(v.getContext(),
                                    "AUTH NEEDED", Toast.LENGTH_LONG);
                            messsageToast.show();
                        }


                    }
                }
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
