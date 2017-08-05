package com.example.joffr.calculaimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double peso=0, altura=0;
    TextView tp, ta;
    final static int NOVOPESO = 1, NOVAALTURA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp = (TextView)findViewById(R.id.pesoValor);
        ta = (TextView)findViewById(R.id.alturaValor);
        tp.setText(""+peso);
        ta.setText(""+altura);
    }

    public void ClickPeso(View v){
        Intent i = new Intent(this, NovoValor.class);
        Bundle b = new Bundle();
        b.putBoolean("tipo", true);
        i.putExtras(b);

        startActivityForResult(i, NOVOPESO);
    }
    public void ClickAltu(View v){
        Intent i = new Intent(this, NovoValor.class);
        Bundle b = new Bundle();
        b.putBoolean("tipo", false);
        i.putExtras(b);

        startActivityForResult(i, NOVAALTURA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if (requestCode == NOVOPESO) {
                Toast.makeText(this, "Retornou", Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();
                String novo = b.getString("novoValor");
                double nonovo = Double.parseDouble(novo);
                tp.setText("" + nonovo);
            } else if (requestCode == NOVAALTURA) {
                Toast.makeText(this, "ok né?", Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();
                String novo = b.getString("novoValor");
                ta.setText("" + novo);
            }
        } else{
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}
