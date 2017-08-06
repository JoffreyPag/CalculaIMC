package com.example.joffr.calculaimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double peso = 0, altura = 0, imc = 0;
    TextView tp, ta, res;
    final static int NOVOPESO = 1, NOVAALTURA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp = (TextView) findViewById(R.id.pesoValor);
        ta = (TextView) findViewById(R.id.alturaValor);
        res = (TextView)findViewById(R.id.resultado);
        tp.setText(String.valueOf(peso));
        ta.setText(String.valueOf(altura));
        res.setText("Aperte o botão para calcular");
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

    public void  Calcular(View v){
        if(peso >= 1){
            if(altura >= 1){
                imc = peso / altura*altura;
                if(imc < 16){
                    res.setText("Magreza Grave");
                }else if(imc >= 16 && imc <17){
                    res.setText("Magreza Moderada");
                }else if(imc >= 17 && imc < 18.5){
                    res.setText("Magreza Leve");
                }else if(imc >= 18.5 && imc < 25){
                    res.setText("Saudavel");
                }else if(imc >= 25 && imc < 30){
                    res.setText("Sobrepeso");
                }else if(imc >= 30 && imc < 35){
                    res.setText("Obesidade Grau I");
                }else if(imc >= 35 && imc < 40){
                    res.setText("Obesidade Grau II");
                }else if(imc >= 40){
                    res.setText("Obesidade Grau III (Mórbida)");
                }
            } else{
                Toast.makeText(this, "não existe altura 0 amigão",Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Mesmo que você se chame Hélio você não é mais leve que o ar!", Toast.LENGTH_SHORT).show();
        }
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
