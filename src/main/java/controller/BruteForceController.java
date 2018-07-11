package controller;

import model.BruteForcer;
import model.Password;

/**
 * Created by Maciej Jankowicz on 11.07.18, 13:46
 * Contact: mj6367@gmail.com
 */
public class BruteForceController {

    public static void runCracker(Password password){

        char firstCharacter = 48;
        while (firstCharacter < 123){
            if(firstCharacter == 58){
                firstCharacter = 65;
            }else if(firstCharacter == 91){
                firstCharacter = 97;
            }

            (new Thread(new BruteForcer(password, firstCharacter))).start();

            firstCharacter++;
        }
    }
}
