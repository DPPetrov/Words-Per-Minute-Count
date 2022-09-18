import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WordsPerMinute {
    //randomly selected words that will be displayed for the user to type in
    static String[] words = {"potato", "tomato", "Skyrim", "note", "Naruto", "ninja", "Voltron", "hat", "bat",
            "rat", "that", "Johnny", "Yo", "carrot", "watch", "car", "dog"};

    public static void main(String[] args) throws InterruptedException {
        //countdown before the user is required to create input
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        Random rand = new Random();
        for (int i = 0; i < 17; i++) {
            //generates a random number of words from the array
            System.out.print(words[rand.nextInt(17)] + " ");
        }
        System.out.println();
        double start = LocalTime.now().toNanoOfDay();

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        double end = LocalTime.now().toNanoOfDay();
        double timePassed = end - start;
        double seconds = timePassed / 1000000000.0;
        int numOfChars = userInput.length(); //spaces included
        System.out.printf("Time elapsed: %.2f seconds\n", seconds);

        // (x characters / 5) / 1min = y WPM - formula calc. words per min

        int wpm =(int) (((double)(numOfChars / 5 ) / seconds) * 60);

        System.out.println("Your word per minute count is: " + wpm + "!");
    }
}
