package com.model;

public class Project
{
    private int[] projectPerformance = new int[3];

    public Project ( int score1, int score2, int score3)
    {
        this.projectPerformance[0] = score1;
        this.projectPerformance[1] = score2;
        this.projectPerformance[2] = score3;
    }

    public int getScore1()
    {
        return projectPerformance[0];
    }

    public int getScore2()
    {
        return projectPerformance[1];
    }

    public int getScore3()
    {
        return projectPerformance[2];
    }
}
