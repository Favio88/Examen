package com.favio.examen;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn_nuevo;
    TextView txtv_num, txtv_res, txtv_ganador;
    int num=0, res=0, intentos=0;

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

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn_nuevo.setOnClickListener(this);

        jugarNuevo();
    }

    @Override
    public void onClick(View v) {

        Random rdm=new Random();
        int numRdm=rdm.nextInt(10)+1;

        switch(v.getId()){

            case R.id.btn1:
                txtv_num.setText(Integer.toString(numRdm));
                res=numRdm+res;
                txtv_res.setText(Integer.toString(res));
                btn1.setBackgroundColor(Color.GREEN);
                intentos++;
                btn1.setEnabled(false);
                verificar();
                break;
            case R.id.btn2:
                txtv_num.setText(Integer.toString(numRdm));
                res=numRdm+res;
                txtv_res.setText(Integer.toString(res));
                btn2.setBackgroundColor(Color.GREEN);
                intentos++;
                btn2.setEnabled(false);
                verificar();
                break;
            case R.id.btn3:
                txtv_num.setText(Integer.toString(numRdm));
                res=numRdm+res;
                txtv_res.setText(Integer.toString(res));
                btn3.setBackgroundColor(Color.GREEN);
                intentos++;
                btn3.setEnabled(false);
                verificar();
                break;
            case R.id.btn4:
                txtv_num.setText(Integer.toString(numRdm));
                res=numRdm+res;
                txtv_res.setText(Integer.toString(res));
                btn4.setBackgroundColor(Color.GREEN);
                intentos++;
                btn4.setEnabled(false);
                verificar();
                break;
            case R.id.btn5:
                txtv_num.setText(Integer.toString(numRdm));
                res=numRdm+res;
                txtv_res.setText(Integer.toString(res));
                btn5.setBackgroundColor(Color.GREEN);
                intentos++;
                btn5.setEnabled(false);
                verificar();
                break;
            case R.id.btn_nuevo:
                jugarNuevo();
                break;
        }
    }

    public void jugarNuevo(){

        num=0;
        res=0;
        intentos=0;

        txtv_num.setText(" ");
        txtv_ganador.setText(" ");
        txtv_res.setText("0");

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);

        btn1.setBackgroundColor(Color.GRAY);
        btn2.setBackgroundColor(Color.GRAY);
        btn3.setBackgroundColor(Color.GRAY);
        btn4.setBackgroundColor(Color.GRAY);
        btn5.setBackgroundColor(Color.GRAY);
    }

    public void verificar(){

        if(res==21 || (intentos==5 && res<=21)){

            txtv_ganador.setText("Felicidades!!! Has ganado");
            txtv_ganador.setTextColor(Color.GREEN);

            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
        }

        if(res>21){

            txtv_ganador.setText("Lo siento. Has perdido");
            txtv_ganador.setTextColor(Color.RED);

            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
        }
    }
}
