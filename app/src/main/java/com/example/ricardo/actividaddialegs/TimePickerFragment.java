package com.example.ricardo.actividaddialegs;

import android.app.TimePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

/**
 * Created by Ricardo on 18/01/2018.
 */

public class TimePickerFragment extends DialogFragment{

    private TimePickerDialog.OnTimeSetListener listener;

    public static TimePickerFragment newInstance(TimePickerDialog.OnTimeSetListener listener) {
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setListener(listener);
        return fragment;
    }

    public void setListener(TimePickerDialog.OnTimeSetListener listener) {
        this.listener = listener;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Declaramos los ints
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR);
        int minuto = c.get(Calendar.MINUTE);

        // Devolvemos la información
        return new TimePickerDialog(getActivity(), listener, hora, minuto, true);
    }
}
