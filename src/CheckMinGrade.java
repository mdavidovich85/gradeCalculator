public class CheckMinGrade {

    public static double CheckMinGrade(double[] allGrades) {

        double minGrade = allGrades[0];

        for (double grade : allGrades) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }

        return minGrade;
    }
}
