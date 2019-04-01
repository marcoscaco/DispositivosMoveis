package br.unicamp.ft.m183387_v148167.aula4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainActivityView;
    private MyFirstAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainActivityView = findViewById(R.id.mainRecycle);
        mainActivityView.setHasFixedSize(true);
        mainActivityView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MyFirstAdapter((new ArrayList(Arrays.asList(Alunos.alunos))));
        mainActivityView.setAdapter(mainAdapter);
        mainAdapter.setMyOnItemClickListener(new MyFirstAdapter.MyOnItemClickListener() {
                                                 @Override
                                                 public void MyOnItemClick(String nome) {
                                                     Toast toast = Toast.makeText(MainActivity.this, "Aluno: " + nome, Toast.LENGTH_LONG);
                                                     toast.show();
                                                 }
                                             }
        );
    }
}
