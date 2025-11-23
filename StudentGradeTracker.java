import java.util.Scanner;

public class StudentGradeTracker {
    static final int PASS_MARKS = 40;

    public static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public static void printSubjectResults(String[] subjects, int[] marks) {
        for (int i = 0; i < subjects.length; i++) {
            String result = marks[i] >= PASS_MARKS ? "Pass" : "Fail";
            System.out.println(subjects[i] + ": " + marks[i] + " - " + result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] subjects = new String[n];
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();

            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); // consume newline
        }

        System.out.println("\nResults for " + studentName + ":");
        printSubjectResults(subjects, marks);

        double average = calculateAverage(marks);
        System.out.printf("Average Marks: %.2f\n", average);

        if (average >= PASS_MARKS) {
            System.out.println("Overall Result: Pass");
        } else {
            System.out.println("Overall Result: Fail");
        }

        scanner.close();
    }
}
