package com.model;

public class Project
{
    private int[] projectPerformance = new int[3];

    public Project ( int performance1, int performance2, int performance3)
    {
        this.projectPerformance[0] = performance1;
        this.projectPerformance[1] = performance2;
        this.projectPerformance[2] = performance3;
    }

    public int getperformance1()
    {
        return projectPerformance[0];
    }

    public int getperformance2()
    {
        return projectPerformance[1];
    }

    public int getperformance3()
    {
        return projectPerformance[2];
    }
}
