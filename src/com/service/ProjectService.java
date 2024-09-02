package com.service;

public class ProjectService
{
    /**
     * his method calculates the total score by summing up the scores of three projects.
     * @param score1
     * @param score2
     * @param score3
     * @return
     */
    public int calculateTotalScore( int score1, int score2, int score3)
    {
        int sum = score1 + score2 + score3;
        return sum;
    }

    /**
     * This method calculates the average score of three project scores.
     * @param score1
     * @param score2
     * @param score3
     * @return
     */
    public double calculateAverageScore( int score1, int score2, int score3 )
    {
        int sum = score1 + score2 + score3;
        return ( ( double ) sum / 3 );
    }

    /**
     * This method calculates the grade based on the average score of three project scores.
     * It returns a string indicating the grade and the rounded average percentage.
     * @param score1
     * @param score2
     * @param score3
     * @return
     */
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


