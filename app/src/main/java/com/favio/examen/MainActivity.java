package com.favio.examen;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn_nuevo;
    TextView txtv_num, txtv_res, txtv_ganador;
    int num=0, res=0, intentos=0;
    LinearLayout ll_cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn_nuevo=findViewById(R.id.btn_nuevo);
        txtv_num=findViewById(R.id.txtv_num);
        txtv_res=findViewById(R.id.txtv_res);
        txtv_ganador=findViewById(R.id.txtv_ganador);
        ll_cartas=findViewById(R.id.ll_cartas);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        btn_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugarNuevo();
            }
        });

        jugarNuevo();
    }

    @Override
    public void onClick(View v) {

        Random rdm=new Random();
        int numRdm=rdm.nextInt(9)+1;

        Button btn=(Button)v;

        txtv_num.setText(Integer.toString(numRdm));
        res=numRdm+res;
        txtv_res.setText(Integer.toString(res));
        btn.setBackgroundColor(Color.GREEN);
        intentos++;
        btn.setEnabled(false);
        verificar();
    }

    public void jugarNuevo(){

        num=0;
        res=0;
        intentos=0;

        txtv_num.setText(" ");
        txtv_ganador.setText(" ");
        txtv_res.setText("0");

        habilitarCartas();
    }

    public void verificar(){

        if(!verificarIntentos() && res<=21){

            txtv_ganador.setText("Felicidades!!! Has ganado");
            txtv_ganador.setTextColor(Color.GREEN);

            deshabilitarCartas();
        }

        if(res>21){

            txtv_ganador.setText("Lo siento. Has perdido");
            txtv_ganador.setTextColor(Color.RED);

            deshabilitarCartas();
        }
    }

    public void habilitarCartas(){

        int numCartas=ll_cartas.getChildCount();

        for(int i=0; i<numCartas; i++){

            View v=ll_cartas.getChildAt(i);
            v.setEnabled(true);
            v.setBackgroundColor(Color.GRAY);
        }
    }

    public void deshabilitarCartas(){

        int numCartas=ll_cartas.getChildCount();

        for(int i=0; i<numCartas; i++){

            View v=ll_cartas.getChildAt(i);
            v.setEnabled(false);
        }
    }

    public boolean verificarIntentos(){

        boolean intentos=false;
        int numCartas=ll_cartas.getChildCount();

        for(int i=0; i<numCartas; i++){

            View v=ll_cartas.getChildAt(i);

            if(v instanceof  Button){

                if(v.isEnabled()){

                    intentos=true;
                }
            }

        }
        return intentos;
    }
}
