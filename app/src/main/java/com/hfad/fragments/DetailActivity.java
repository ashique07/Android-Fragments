package com.hfad.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "workoutId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        Intent intent = getIntent();
        workoutDetailFragment.setWorkout((Long) intent.getExtras().get(EXTRA_WORKOUT_ID));
    }
}
