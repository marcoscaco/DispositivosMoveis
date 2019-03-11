package br.unicamp.ft.m183387_v148167.aula1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
      IMC.class --> Utilitarios para calculo de imc
     */
    private IMC imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Atributos de classe
         */

        // imc
        imc = new IMC();
        //textView que carrega o resultado da conta do IMC
        final TextView textViewIMCcalculado = (TextView) findViewById(R.id.textViewIMCCalculado);
        textViewIMCcalculado.setText(getString(R.string.textViewInformacoesTela1));
        //EditText que Carrega a Entrada do usuario para ALTURA
        final EditText editTextNumero1 = (EditText) findViewById(R.id.editTextNumero1);
        //EditText que Carrega a Entrada do usuario para PESO
        final EditText editTextNumero2 = (EditText) findViewById(R.id.editTextNumero2);
        //Button que RETORNA o IMCcalculado (float)
        final Button btn = (Button) findViewById(R.id.buttonCalcule);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float edit1 = Float.parseFloat(editTextNumero1.getText().toString()); // type cast String-->Float
                float edit2 = Float.parseFloat(editTextNumero2.getText().toString()); // type cast String-->Float
                imc.setPeso(edit1); //
                imc.setAltura(edit2); //
                textViewIMCcalculado.setText(Float.toString(imc.getIMC()));
            }
        });

    }
}
