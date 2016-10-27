package com.example.rael.parcial22;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int aa,bb;
    SeekBar dif;
    TextView timer;
    Boolean counterIsActive = false;
    Button st;
    CountDownTimer countDownTimer;

    public void resetTimer() {
        timer.setText("00:30");
        dif.setProgress(30);
        countDownTimer.cancel();
        dif.setEnabled(true);
        counterIsActive = false;
    }

    public void updateTimer(int secondsLeft) {
        int minutes = (int) secondsLeft / 60;
        int seconds = (int) secondsLeft % 60;

        String secondsString = Integer.toString(seconds);
        if (secondsString.length() < 2) {
            secondsString = "0" + secondsString;
        }

        String minutesString = Integer.toString(minutes);
        if (minutesString.length() < 2) {
            minutesString = "0" + minutesString;
        }

        timer.setText(minutesString + ":" + secondsString);
    }

    public void next (View view) {
        TextView corr = (TextView) findViewById(R.id.corre);
        TextView incorr = (TextView) findViewById(R.id.incorre);

        String cor, incor;
        cor = corr.getText().toString();
        incor = incorr.getText().toString();

        int incorrect, punto, corect, co;
        punto = 0;
        corect = Integer.valueOf(cor);
        co = 0;
        incorrect = Integer.valueOf(incor);

        EditText respu = (EditText) findViewById(R.id.resp);
        String srespu = String.valueOf(respu);


        Random rand = new Random();
        int number = rand.nextInt(150) + 1;
        TextView n1 = (TextView) findViewById(R.id.num1);
        String sn1 = String.valueOf(number);
        n1.setText(sn1);

        Random rand2 = new Random();
        int number2 = rand2.nextInt(150) + 1;
        TextView n2 = (TextView) findViewById(R.id.num2);
        String sn2 = String.valueOf(number2);
        n1.setText(sn2);

        int x = new Integer(n1.getText().toString());
        int y = new Integer(n2.getText().toString());


        int respues = x + y;
        String re = String.valueOf(respues);


        if (re == srespu) {
            aa = corect + 1;
            co = aa;
            String coo = String.valueOf(co);
            corr.setText(coo);

        } else {
            bb = incorrect + 1;
            punto = bb;
            String incc = String.valueOf(punto);
            incorr.setText(incc);

        }
    }

    public void st(View view) {
        TextView corr = (TextView)findViewById(R.id.corre);
        TextView incorr = (TextView)findViewById(R.id.incorre);

        String cor, incor;
        cor = corr.getText().toString();
        incor = incorr.getText().toString();

        int incorrect, punto, corect, co;
        punto = 0;
        corect = Integer.valueOf(cor);
        co = 0;
        incorrect = Integer.valueOf(incor);

        EditText respu = (EditText)findViewById(R.id.resp);
        String srespu = String.valueOf(respu);


        Random rand = new Random();
        int number = rand.nextInt(150)+1;
        TextView n1 = (TextView)findViewById(R.id.num1);
        String sn1 = String.valueOf(number);
        n1.setText(sn1);

        Random rand2 = new Random();
        int number2 = rand2.nextInt(150)+1;
        TextView n2 = (TextView)findViewById(R.id.num2);
        String sn2 = String.valueOf(number2);
        n1.setText(sn2);

        int x = new Integer(n1.getText().toString());
        int y = new Integer(n2.getText().toString());


        int respues = x+y;
        String re = String.valueOf(respues);




        if ( re == srespu ) {
            aa = corect + 1;
            co = aa;
            String coo = String.valueOf(co);
            corr.setText(coo);

        } else {
            bb = incorrect + 1;
            punto = bb;
            String incc = String.valueOf(punto);
            incorr.setText(incc);



            if (!counterIsActive) {

                counterIsActive = true;
                dif.setEnabled(false);

                countDownTimer = new CountDownTimer(dif.getProgress() * 1000 + 100, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        updateTimer((int) millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {

                        timer.setText("00:00");
                        resetTimer();
                    }
                }.start();

            } else {
                resetTimer();
            }
        }

        dif = (SeekBar)findViewById(R.id.dif);
        timer = (TextView)findViewById(R.id.timer);
        st = (Button)findViewById(R.id.st);


        dif.setMax(30);
        dif.setProgress(30);

        timer.setEnabled(false);

        dif.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

