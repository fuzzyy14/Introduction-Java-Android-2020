package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.sorties2020.R;

import java.util.Calendar;

public class VueAjouterAlarme extends AppCompatActivity {


    Context myContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_ajouter_alarme);
        Button vueAjouterAlarmeActionAnnuler= (Button)findViewById(R.id.vueAjouterAlarmeActionAnnuler);
        vueAjouterAlarmeActionAnnuler.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        // TODO : faire le code du bouton
                        /*
                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Action Annuler",
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        naviguerRetour();
                    }
                }


        );

        Button vueAjouterAlarmeActionAjouter= (Button)findViewById(R.id.vueAjouterAlarmeActionAjouter);
        vueAjouterAlarmeActionAjouter.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        Calendar dateActuelle = Calendar.getInstance();
                        final int heure = dateActuelle.get(Calendar.HOUR_OF_DAY);
                        final int minutes = dateActuelle.get(Calendar.MINUTE);
                        TimePickerDialog horlogeCadrant = new TimePickerDialog(myContext, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int heure, int minutes) {

                                Intent activerAlarme = new Intent(AlarmClock.ACTION_SET_ALARM);
                                activerAlarme.putExtra(AlarmClock.EXTRA_HOUR, heure);
                                activerAlarme.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                                if(heure <= 24 && minutes <= 60){
                                    startActivity(activerAlarme);

                                }

                                naviguerRetour();
                            }
                        },heure,minutes,android.text.format.DateFormat.is24HourFormat(myContext));


                        horlogeCadrant.show();
                    }
                }


        );
    }
    public void naviguerRetour()
    {
        this.finish();
    }

}

