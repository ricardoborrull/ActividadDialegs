package com.example.ricardo.actividaddialegs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    //Declaramos los campos
    private TextView txtFecha, txtHora, txtColor;
    private Button fecha, hora, color;
    private String colores[] = {"Azul", "Verde", "Rojo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos los campos
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtHora = (TextView) findViewById(R.id.txtHora);
        txtColor = (TextView) findViewById(R.id.txtColor);

        fecha = (Button) findViewById(R.id.fecha);
        hora = (Button) findViewById(R.id.hora);
        color = (Button) findViewById(R.id.color);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el AlertBuilder
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //Elegimos el título y aáñadimos los items del array
                builder.setTitle("Elige un color").setItems(colores, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialeg, int posicio) {
                                txtColor.setText(colores[posicio]);
                            }
                        });
                builder.create();
                builder.show();
            }
        });
    }


    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anyo, int mes, int dia) {
                //Aquí recogemos la información (Añadimos 1 al mes porque enero sale como 0)
                final String fechaSelecionada = dia + " / " + (mes+1) + " / " + anyo;
                txtFecha.setText(fechaSelecionada);
            }
        });
        newFragment.show(MainActivity.this.getSupportFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog() {
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                //Aquí recogemos la información
                final String horaSelecionada = hora+":"+minuto;
                txtHora.setText(horaSelecionada);
            }
        });
        newFragment.show(MainActivity.this.getSupportFragmentManager(), "timePicker");
    }

}
