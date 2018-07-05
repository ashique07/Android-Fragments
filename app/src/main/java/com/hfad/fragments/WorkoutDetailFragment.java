package com.hfad.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {


    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(savedInstanceState != null)
        {
            workoutId = savedInstanceState.getLong("workoutId");
        }

        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();

        ft.replace(R.id.stopwatch_container, stopwatchFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        //Get reference to the view by getView()
        View view = getView();

        if(view != null)
        {
            Workout workout = Workout.workouts[(int)workoutId];
            TextView title = (TextView)view.findViewById(R.id.textTitle);
            title.setText(workout.getName());

            TextView description = (TextView)view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    public void setWorkout(long id)
    {
        this.workoutId = id;
    }

    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        savedInstanceState.putLong("workoutId",workoutId);
    }
}
