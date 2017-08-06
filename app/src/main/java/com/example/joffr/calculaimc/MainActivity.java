package com.example.joffr.calculaimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double peso = 0, altura = 0;
    TextView tp, ta;
    final static int NOVOPESO = 1, NOVAALTURA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp = (TextView) findViewById(R.id.pesoValor);
        ta = (TextView) findViewById(R.id.alturaValor);
        tp.setText(String.valueOf(peso));
        ta.setText(String.valueOf(altura));
    }

    public void ClickPeso(View v) {
        Intent i = new Intent(this, NovoValor.class);
        Bundle b = new Bundle();
        b.putBoolean("tipo", true);
        i.putExtras(b);

        startActivityForResult(i, NOVOPESO);
    }

    public void ClickAltu(View v) {
        Intent i = new Intent(this, NovoValor.class);
        Bundle b = new Bundle();
        b.putBoolean("tipo", false);
        i.putExtras(b);

        startActivityForResult(i, NOVAALTURA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NOVOPESO) {
                //Toast.makeText(this, "Retornou", Toast.LENGTH_SHORT).show();
                /* Você tava criando um bundle e não recebendo, veja que na assinatura da função você recebe
                uma variável chamada data e ela é do tipo intent, portanto, esta variável é a intent retornada pela activity.

                Aqui estou pegando o valor direto da Intent e não de um bundle, pois não achei necessário.
                Se tivesse um bundle: i.getBundle.getStringExtra("novoValor");*/
                Intent i = data;
                peso = Double.parseDouble(i.getStringExtra("novoValor"));
                //É melhor você fazer dessa forma a baixo, no mínimo é mais bonito.
                tp.setText(String.valueOf(peso));
            } else if (requestCode == NOVAALTURA) {
                //Toast.makeText(this, "ok né?", Toast.LENGTH_SHORT).show();
                Intent i = data;
                //String novo = i.getStringExtra("novoValor");
                altura = Double.parseDouble(i.getStringExtra("novoValor"));
                //Mesma coisa do setText acima.
                ta.setText(String.valueOf(altura));
            }
        } else {
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}
