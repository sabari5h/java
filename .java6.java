import java.util.Scanner;

class ScoreException extends Exception
{
    public ScoreException(String message)
    {
        super(message);
    }
}

public class TestScore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] studid = {"A1", "B2", "C3", "D4", "E5"};
        int[] scores = new int[studid.length];
        for (int i = 0; i < studid.length; i++) {
            System.out.print("Enter the test score for student " + studid[i] + ": ");
            try
            {
                int score = Integer.parseInt(sc.nextLine());
                if (score < 0 || score > 100)
                {
                    throw new ScoreException("Invalid score! Score must be between 0 and 100.");
                }
                scores[i] = score;
            }
            catch (NumberFormatException e)
            {
                System.err.println("Invalid input! Please enter a numeric score.");
                scores[i] = 0;
            }
            catch (ScoreException e)
            {
                System.err.println(e.getMessage());
                scores[i] = 0;
            }
        }

        System.out.println("\nStudent ID\tTest Score");
        for (int i = 0; i < studid.length; i++) {
            System.out.println(studid[i] + "\t\t" + scores[i]);
        }

        sc.close();
    }
}