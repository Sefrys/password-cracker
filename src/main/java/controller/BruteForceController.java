package controller;

import model.BruteForcer;
import model.Password;
import model.ThreadContainer;
import utils.AsciiValues;

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
}
