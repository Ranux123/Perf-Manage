package com.service;

public class ProjectService
{
    public int calculateTotalScore( int score1, int score2, int score3)
    {
        int sum = score1 + score2 + score3;
        return sum;
    }

    public double calculateAverageScore( int score1, int score2, int score3 )
    {
        int sum = score1 + score2 + score3;
        return ( ( double ) sum / 3 );
    }

    public String calculateGradeScore( int score1, int score2, int score3 )
    {
        double average = calculateAverageScore( score1, score2, score3 );
        int roundedAverage = ( int ) Math.round( average );
        if( average >= 80 )
        {
            return "Outstanding! -> " + roundedAverage + "%";
        }
        else if( average >= 70 )
        {
            return "Exceeds Expectations! -> " + roundedAverage + "%";
        }
        else if( average >= 40 )
        {
            return "Meets Expectations! -> " + roundedAverage + "%";
        }
        else
        {
            return "Needs Improvement! -> " + roundedAverage + "%";
        }
    }
}


