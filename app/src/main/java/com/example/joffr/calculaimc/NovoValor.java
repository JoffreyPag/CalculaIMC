package com.example.joffr.calculaimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovoValor extends AppCompatActivity {

    TextView tv;
    boolean tipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_valor);
        tv = (TextView) findViewById(R.id.opc);
        Bundle b = new Bundle();
        tipe = b.getBoolean("tipo");
        if (tipe) {
            tv.setText(R.string.peso_titulo);
        } else {
            tv.setText(R.string.altura_titulo);
        }

    }


    public void AlteraValor(View v) {
        EditText et = (EditText) findViewById(R.id.texto);
        String novo = et.getText().toString();
        //Não precisa de um bundle nesse caso.
        //Bundle b = new Bundle();
        //b.putString("novoValor", novo);
        Intent i = new Intent();
        i.putExtra("novoValor", novo);
        //i.putExtras(b);
        setResult(RESULT_OK, i);
        finish();
    }

    public void Cancelamento(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

}
