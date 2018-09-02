public class CheckMaxGrade {

    public static double CheckMaxGrade(double[] allGrades) {

        double maxGrade = allGrades[0];

        for (double grade : allGrades) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }

        return maxGrade;
    }
}
