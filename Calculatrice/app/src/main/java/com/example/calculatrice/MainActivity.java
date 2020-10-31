package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button effacer;
    private EditText remplirT;
    private Button sept;
    private Button huit;
    private String text;
    private Button plus;
    private Integer addition ;
    private Double Total ;
    private Button neuf;
    private Button quatres;
    private Button cinq;
    private Button trois;
    private Button six;
    private Button deux;
    private Button un;
    private Button zero;
    private Button virgule;
    private Button plusoumoins;
    private Double somme;
    private Double somme2;
    private Integer vir;
    private Button egal;
    private boolean Sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        effacer = (Button) findViewById(R.id.tr);
        remplirT = (EditText) findViewById(R.id.text);

        //chiffre
        sept = (Button) findViewById(R.id.sept);
        huit = (Button) findViewById(R.id.se);
        neuf = (Button) findViewById(R.id.neuf);
        quatres = (Button) findViewById(R.id.ci);
        cinq = (Button) findViewById(R.id.hu);
        six = (Button) findViewById(R.id.six);
        trois = (Button) findViewById(R.id.si);
        deux = (Button) findViewById(R.id.deux);
        un = (Button) findViewById(R.id.un);
        zero = (Button) findViewById(R.id.zero);
        addition=0;
        somme=0.0;
        somme2=0.0;
        vir=0;
        //symboles
        virgule = (Button) findViewById(R.id.virgule);
        plusoumoins = (Button) findViewById(R.id.plusoumoins);
        egal = (Button) findViewById(R.id.egal);

        //opérateurs
        plus= findViewById(R.id.plus);
        egal= findViewById(R.id.egal);

        effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                effaceur();
            }
        });

        sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                clavierNum(v);
            }
        });

        huit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                clavierNum(v);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                clavierNum(v);
            }
        });

        egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                clavierNum(v);
            }
        });

        virgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                clavierNum(v);
            }
        });

    }

    public void effaceur(){
        remplirT.setText("0");
    }

    public void clavierNum(View v){
        text =  remplirT.getText().toString();

        switch (v.getId()){

            case R.id.sept:
                if(text.equals("0") || text.equals("")) {
                    remplirT.setText("7");
                }
                else {
                    text=remplirT.getText().toString();
                    Total = Double.parseDouble(text);
                    remplirT.setText(text + ("7"));
                }
                break;

            case R.id.se :
                if(text.equals("0") || text.equals("")) {
                    remplirT.setText("8");
                }
                else {
                    text=remplirT.getText().toString();
                    Total = Double.parseDouble(text);
                    remplirT.setText(text + ("8"));
                }
                break;

            case R.id.egal:
                somme2 = Double.parseDouble(remplirT.getText().toString());
                somme = somme + somme2;
                remplirT.setText(somme.toString());
                somme=0.0;
                somme2=0.0;
                vir=0;
                break;

            case R.id.plus:
                if(addition==0) {
                    somme = somme + Double.parseDouble(remplirT.getText().toString());
                }
                if(addition==1){
                    somme2=Double.parseDouble(remplirT.getText().toString());
                    somme = somme + somme2;
                }
                addition=1;
                remplirT.setText("");
                break;

            case R.id.virgule:
                text=remplirT.getText().toString();
                if (vir==0 && text!="") {
                    remplirT.setText(remplirT.getText().toString() + ".");
                    vir=1;
                }
                if (vir==0) {
                    text = remplirT.getText().toString();
                    remplirT.setText(remplirT.getText().toString() + ".");
                    vir=1;
                }
                if (vir==0 && text=="") {
                    remplirT.setText(remplirT.getText().toString() + "0.");
                    vir=1;
                }

                break;


        }
    }
}