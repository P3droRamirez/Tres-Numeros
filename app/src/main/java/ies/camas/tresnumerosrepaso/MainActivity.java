package ies.camas.tresnumerosrepaso;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

EditText txtNum1,txtNum2, txtNum3;
TextView labelIzquierda,labelCentro, labelDerecha;
Button btnMenor,btnMayor, btnOrdAsc, btnOrdDesc, btnBorrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtNum3 = findViewById(R.id.txtNum3);


        labelIzquierda = findViewById(R.id.labelResultado1);
        labelCentro = findViewById(R.id.labelResultado2);
        labelDerecha = findViewById(R.id.labelResultado3);

        btnBorrar = findViewById(R.id.btnBorrar);
        btnMayor = findViewById(R.id.btnMayor);
        btnMenor = findViewById(R.id.btnMenor);
        btnOrdAsc = findViewById(R.id.btnOrdenAsc);
        btnOrdDesc = findViewById(R.id.btnOrdenDesc);

        btnBorrar.setOnClickListener(view -> borrar());
        btnMenor.setOnClickListener(view -> {
            String num1str = txtNum1.getText().toString();
            String num2str = txtNum2.getText().toString();
            String num3str = txtNum3.getText().toString();
            int num1 = Integer.parseInt(num1str);
            int num2 = Integer.parseInt(num2str);
            int num3 = Integer.parseInt(num3str);
            int resultado = menor(num1,num2,num3);

            labelCentro.setText(String.valueOf(resultado));
            labelDerecha.setText("");
            labelIzquierda.setText("");
        });
        btnMayor.setOnClickListener(view -> {
            String num1str = txtNum1.getText().toString();
            String num2str = txtNum2.getText().toString();
            String num3str = txtNum3.getText().toString();
            int num1 = Integer.parseInt(num1str);
            int num2 = Integer.parseInt(num2str);
            int num3 = Integer.parseInt(num3str);
            int resultado = mayor(num1,num2,num3);

            labelCentro.setText(String.valueOf(resultado));
            labelIzquierda.setText("");
            labelDerecha.setText("");
        });

        btnOrdAsc.setOnClickListener(view -> {
            String num1str = txtNum1.getText().toString();
            String num2str = txtNum2.getText().toString();
            String num3str = txtNum3.getText().toString();
            int num1 = Integer.parseInt(num1str);
            int num2 = Integer.parseInt(num2str);
            int num3 = Integer.parseInt(num3str);
            Integer[] array = ordAsc(num1,num2,num3);

            labelIzquierda.setText(String.valueOf(array[0]));
            labelCentro.setText(String.valueOf(array[1]));
            labelDerecha.setText(String.valueOf(array[2]));
        });
        btnOrdDesc.setOnClickListener(view -> {
            String num1str = txtNum1.getText().toString();
            String num2str = txtNum2.getText().toString();
            String num3str = txtNum3.getText().toString();
            int num1 = Integer.parseInt(num1str);
            int num2 = Integer.parseInt(num2str);
            int num3 = Integer.parseInt(num3str);
            Integer[] array = ordAsc(num1,num2,num3);

            labelIzquierda.setText(String.valueOf(array[2]));
            labelCentro.setText(String.valueOf(array[1]));
            labelDerecha.setText(String.valueOf(array[0]));
        });


    }
    public void borrar(){
        txtNum1.setText("");
        txtNum2.setText("");
        txtNum3.setText("");
        labelIzquierda.setText("");
        labelCentro.setText("");
        labelDerecha.setText("");
    }
    public int menor(int n1, int n2, int n3){
        return Math.min(Math.min(n1,n2),n3);
    }
    public int mayor(int n1, int n2, int n3){
        return Math.max(Math.max(n1,n2),n3);
    }
    public Integer[] ordAsc(int n1, int n2, int n3){
        Integer[] numOrdenados ={n1,n2,n3};
        Arrays.sort(numOrdenados);

        return numOrdenados;
    }


}