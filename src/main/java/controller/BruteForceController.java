package controller;

import model.BruteForcer;
import model.Password;
import model.ThreadContainer;
import utils.AsciiValues;
import view.View;

/**
 * Created by Maciej Jankowicz on 11.07.18, 13:46
 * Contact: mj6367@gmail.com
 */
public class BruteForceController {

    private static ThreadContainer threadContainer;
    private static Thread t1;

    public static void runCracker(Password password){
        char firstCharacter = AsciiValues.LOWER_DIGIT_BOUND.getValue();

        while (firstCharacter < AsciiValues.UPPER_LOWERCASE_LETTER_BOUND.getValue()){

            if(firstCharacter == AsciiValues.UPPER_DIGIT_BOUND.getValue()){
                firstCharacter = AsciiValues.LOWER_CAPITAL_LETTER_BOUND.getValue();

            }else if(firstCharacter == AsciiValues.UPPER_CAPITAL_LETTER_BOUND.getValue()){
                firstCharacter = AsciiValues.LOWER_LOWERCASE_LETTER_BOUND.getValue();
            }

            BruteForcer bruteForcer = new BruteForcer(password, firstCharacter);
            ThreadContainer.add(bruteForcer);

            new Thread(bruteForcer).start();

            prepareSequenceForDisplay();
            firstCharacter++;
        }
       t1.interrupt();
    }

    public static void runThreadContainer() {
        initializeContainerForThreads();
        t1 = new Thread(threadContainer);
        t1.start();
    }

    private static void initializeContainerForThreads() {
        threadContainer = new ThreadContainer();
    }

    private static void prepareSequenceForDisplay() {
        if (ThreadContainer.threadList.size() > 0) {
            View view = new View();

            if (threadContainer.getRandomThread() == null) {

            }
            else {
                char[] signs = threadContainer.getRandomThread().getStartingSequence();
                String result = buildWord(signs);

                int numberOfThreads = ThreadContainer.threadList.size();

                view.display(numberOfThreads);
                view.display(result);
            }
        }
    }

    private static String buildWord(char[] signs) {
        StringBuilder sb = new StringBuilder();

        for (char sign : signs) {
            sb.append(sign);
        }
        return sb.toString();
    }

}
