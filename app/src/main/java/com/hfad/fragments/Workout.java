package com.hfad.fragments;

public class Workout {

    private String name;
    private String description;

    private Workout (String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public static final Workout[] workouts = {

            new Workout("The Limb Loosener","5 Handstand Pushups\n10 1-legged squats\n 15 Pull-ups"),
            new Workout("Core Agony", "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n 100 Squats"),
            new Workout("The Wimp Special", "500 Meter run \n 21*1.5 pood kettleball swing\n21 x pull-ups")

    };

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
