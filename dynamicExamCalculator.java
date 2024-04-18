import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamicExamCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of sections: ");
        int numOfsect = scanner.nextInt();

        int score[][] = new int[numOfsect][];

        for (int i = 0; i < numOfsect; i++) {
            System.out.print("Enter number of students on section" + (i + 1) + ":");

            int numOfStudents = scanner.nextInt();

            score[i] = new int[numOfStudents];

            for (int j = 0; j < numOfStudents; j++) {
                System.out.print("Enter the score of student " + (j + 1) + ": ");
                score[i][j] = scanner.nextInt();

            }

        }

        System.out.println("");
        System.out.println("Select what you want to get");
        System.out.println("");
        System.out.println("1. The average exam score for each individual section");
        System.out.println("2. The average exam score for all the students in all sections");
        System.out.println("3. The highest exam score per sections.");
        System.out.println("4. The lowest exam score per sections.");
        System.out.println("5. The highest exam score among all sections.");
        System.out.println("6. The lowest exam score among all sections.");
        System.out.println("7. The exam score that appears most frequently among all three sections (Mode).");
        System.out.println("8. The middle exam score among all three sections (Median).");
        System.out.println("");
        System.out.print("Enter the number to select: ");

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                for (int i = 0; i < numOfsect; i++) {
                    int sum = 0;
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                    double average = (double) sum / score[i].length;
                    System.out.println("The average score for section " + (i + 1) + ": " + average);
                      
                }
                break;

            case 2:
                int sum = 0;
                for (int i = 0; i < numOfsect; i++) {
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                }

                int totalStudents = 0;
                for (int[] sectionScores : score) {
                    totalStudents += sectionScores.length;
                }

                double average = (double) sum / totalStudents;

                System.out.println("The average score for all the sections is: " + average);
                break;
            case 3:
                for (int i = 0; i < numOfsect; i++) {
                    sum = 0;
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                    int highScore = Integer.MIN_VALUE;

                    for (int scr : score[i]) {
                        if (scr > highScore) {
                            highScore = scr;
                        }
                    }

                    System.out.println("The high score for section " + (i + 1) + " is : " + highScore);
                }

                break;
            case 4:

                for (int i = 0; i < numOfsect; i++) {
                    sum = 0;
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                    int lowestScore = Integer.MAX_VALUE;
                    for (int scr : score[i]) {
                        if (scr < lowestScore) {
                            lowestScore = scr;
                        }
                    }

                    System.out.println("The lowest score for section " + (i + 1) + " is : " + lowestScore);
                }
                break;
            case 5:

                int overAllHighScore = Integer.MIN_VALUE;
                for (int i = 0; i < numOfsect; i++) {
                    sum = 0;
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                    int highScore = Integer.MIN_VALUE;

                    for (int scr : score[i]) {
                        if (scr > highScore) {
                            highScore = scr;
                        }
                    }
                    if (highScore > overAllHighScore) {
                        overAllHighScore = highScore;
                    }
                }
                System.out.println("The highest score for all the sections is : " + overAllHighScore);

                break;
            case 6:

                int overAlllowestScore = Integer.MAX_VALUE;
                for (int i = 0; i < numOfsect; i++) {
                    sum = 0;
                    for (int scr : score[i]) {
                        sum += scr;
                    }
                    int lowestScore = Integer.MAX_VALUE;

                    for (int scr : score[i]) {
                        if (scr < lowestScore) {
                            lowestScore = scr;
                        }
                    }
                    if (lowestScore < overAlllowestScore) {
                        overAlllowestScore = lowestScore;
                    }
                }
                System.out.println("The lowest score for all the sections is : " + overAlllowestScore);

                break;
            case 7:
                HashMap<Integer, Integer> commonGradesCount = new HashMap<>();
                Integer commonGrade = 0;
                for (int i = 0; i < numOfsect; i++) {
                    for (int scr : score[i]) {
                        Integer numAppearGrade = commonGradesCount.get(scr);
                        if (numAppearGrade == null) {
                            commonGradesCount.put(scr, 0);
                            numAppearGrade = 0;
                        }
                        numAppearGrade++;
                        commonGradesCount.put(scr, numAppearGrade);
                        if (numAppearGrade > commonGrade) {
                            commonGrade = numAppearGrade;
                        }
                    }
                }

                List<Integer> commonGrades = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : commonGradesCount.entrySet()) {
                    if (commonGrade == entry.getValue()) {
                        commonGrades.add(entry.getKey());
                    }
                }

                System.out.println("most common grades: " + commonGrades.toString());
                break;
            case 8:
                List<Integer> scoreSet = new ArrayList<>();
                for (int i = 0; i < numOfsect; i++) {
                    for (int scr : score[i]) {
                        scoreSet.add(scr);
                    }
                }
                Collections.sort(scoreSet);
                if (scoreSet.size() % 2 != 0) {
                    System.out.println(scoreSet.get((scoreSet.size() / 2)));
                }

                else {
                    int upperBoundIndex = scoreSet.size() / 2;
                    int lowerBoundIndex = upperBoundIndex - 1;
                    System.out.println((scoreSet.get(lowerBoundIndex) + scoreSet.get(upperBoundIndex)) / 2);
                }
                break;
            default:

                break;
        }

    }

    static void aveOfIndividualSect() {

    }

}
