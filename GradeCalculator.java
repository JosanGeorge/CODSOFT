import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        double totalMarks = 0.0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + ": ");
            double subjectMarks = sc.nextDouble();
            totalMarks += subjectMarks;
        }

        double avgPercent = totalMarks / (numSubjects * 100.0);

        String grade;

        if (avgPercent >= 0.9) {
            grade = "A+";
        } else if (avgPercent >= 0.8) {
            grade = "A";
        } else if (avgPercent >= 0.7) {
            grade = "B";
        } else if (avgPercent >= 0.6) {
            grade = "C";
        } else if (avgPercent >= 0.5) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + (averagePercentage * 100) + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
