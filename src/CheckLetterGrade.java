public class CheckLetterGrade {

    public static String CheckLetterGrade(double averageGrade) {

        String letterGrade = "";

        if (averageGrade >= 90) {
            letterGrade = "A.  Four Stars ****";
        } else if (averageGrade < 90 && averageGrade >= 80) {
            letterGrade = "B.  Three Stars ***";
        } else if (averageGrade < 80 && averageGrade >= 70) {
            letterGrade = "C.  Two Stars **";
        } else if (averageGrade < 70 && averageGrade >= 60) {
            letterGrade = "D.  One Star *";
        } else if (averageGrade < 60) {
            letterGrade = "F.  No Stars";
        }

        return letterGrade;

    }
}
