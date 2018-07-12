package controller;

import model.BruteForcer;
import model.Password;
import utils.AsciiValues;

/**
 * Created by Maciej Jankowicz on 11.07.18, 13:46
 * Contact: mj6367@gmail.com
 */
public class BruteForceController {

    public static void runCracker(Password password){
        char firstCharacter = AsciiValues.LOWER_DIGIT_BOUND.getValue();

        while (firstCharacter < AsciiValues.UPPER_LOWERCASE_LETTER_BOUND.getValue()){

            if(firstCharacter == AsciiValues.UPPER_DIGIT_BOUND.getValue()){
                firstCharacter = AsciiValues.LOWER_CAPITAL_LETTER_BOUND.getValue();

            }else if(firstCharacter == AsciiValues.UPPER_CAPITAL_LETTER_BOUND.getValue()){
                firstCharacter = AsciiValues.LOWER_LOWERCASE_LETTER_BOUND.getValue();
            }

            (new Thread(new BruteForcer(password, firstCharacter))).start();

            firstCharacter++;
        }
    }
}
