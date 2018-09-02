/*
GradeCalculator.java
by Mike Davidovich
Last Modified 9/2/2018
Concordia St. Paul
CSC 315 Fall 2018 1st Term

This program prompts the user to enter the number of students in the classroom and the number of exam scores,
then prompts for each student’s name and the scores for each exam.
The exam scores are  entered as a sequence of numbers separated by blank space.

THe program will also check for negative scores.  If any score is negative, it will prompt the user to reenter
the scores. The program does not deal with inputs that are not numbers.

For each student, the program calculates the student’s the average score, lowest score, highest score, letter grade,
and the number of stars to give the student.

Before the program terminates, it prints the class statistics: average grade, lowest grade, highest.
*/

import java.util.*;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numStudents;
        int numExams;
        double averageGrade = 0;
        double classAverage = 0;
        String studentName;

        System.out.println("Welcome ot the Grade Calculator!");

        System.out.print("Please enter the number of students: ");
        numStudents = scan.nextInt();

        System.out.print("Please enter the number of exams: ");
        numExams = scan.nextInt();
        scan.nextLine();

        //Arrays will keep track of grade per student and average for whole class
        double[] studentGrades = new double[numExams];
        double[] allGrades = new double[numStudents];
        int allGradeIndex = 0;

        // This iterates through each student based on the input
        // Only allGrades[] is preserved through the iterations
        for (int student = 1; student <= numStudents; student++) {

            System.out.print("Please enter student " + student + "'s name: ");
            studentName = scan.nextLine();
            //System.out.println(studentName);

            boolean isReady = false;

            while (isReady == false) {

                System.out.print("Enter exam scores: ");

                //Set up array of scores
                for (int i = 0; i < studentGrades.length; i++) {
                    studentGrades[i] = scan.nextDouble();
                }
                scan.nextLine();

                //Check array for negative scores
                for (int i = 0; i < studentGrades.length; i++) {
                    if (studentGrades[i] < 0) {
                        System.out.println("Invalid input!");
                        isReady = false;
                        break;
                    } else isReady = true;
                }
            }

            //Sums up the grades to calculate average
            for (double grade : studentGrades) {
                averageGrade = averageGrade + grade;
                //System.out.println(averageGrade);
            }

            //Calculates average grade and adds to class array
            //Moves the index for the class array +1 to consume next student's score
            averageGrade = averageGrade/numExams;
            allGrades[allGradeIndex] = averageGrade;
            allGradeIndex++;
            classAverage = classAverage + averageGrade;

            System.out.println();

            //These functions have been encapsulated in other classes
            System.out.println(studentName + "'s average grade is " + averageGrade);
            System.out.println(CheckLetterGrade.CheckLetterGrade(averageGrade));

            double maxGrade = CheckMaxGrade.CheckMaxGrade(studentGrades);
            System.out.println(studentName + "' highest grade is " + maxGrade);

            double minGrade = CheckMinGrade.CheckMinGrade(studentGrades);
            System.out.println(studentName + "' lowest grade is " + minGrade);

            System.out.println();

            averageGrade = 0;
            //System.out.println(Arrays.toString(studentGrades));
        }

        //This prints out the class statistics
        System.out.println("Class average: " + classAverage/numStudents);
        //System.out.println(Arrays.toString(allGrades));

        double maxGrade = CheckMaxGrade.CheckMaxGrade(allGrades);
        System.out.println("Highest grade: " + maxGrade);
        //System.out.println(Arrays.toString(allGrades));

        double minGrade = CheckMinGrade.CheckMinGrade(allGrades);
        System.out.println("Lowest grade: " + minGrade);
        //System.out.println(Arrays.toString(allGrades));

        System.out.println();

        System.out.print("Thank you for using Grade Calculator!");

    }
}
