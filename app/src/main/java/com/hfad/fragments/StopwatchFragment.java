 package com.hfad.fragments;

import android.os.Handler;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private int seconds = 0;
    private Boolean running = false;
    private Boolean wasRunning = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        runtimer(layout);

        Button startButton = layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);

        Button stopButton = layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);

        Button resetButton = layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        return layout;

    }

    public void onClick (View view)
    {
        switch (view.getId()) {
            case R.id.start_button:
                onClickStart(view);
                break;

            case R.id.stop_button:
                onClickStop(view);
                break;

            case R.id.reset_button:
                onClickReset(view);
                break;
        }

    }

    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);

    }

    public void onStop()
    {
        super.onStop();

        wasRunning = running;
        running = false;

    }

    public void onStart()
    {
        super.onStart();
        if(wasRunning)
        {
            running = true;
        }
    }

    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runtimer(View view)
    {
        final TextView timeView = (TextView)(view.findViewById(R.id.time_view));

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d",hours,minutes,secs);

                timeView.setText(time);

                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });


    }


}
