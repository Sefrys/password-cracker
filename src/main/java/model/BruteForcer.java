package model;

import controller.BruteForceController;
import utils.AsciiValues;
import utils.Complexity;
import view.View;

/**
 * Created by Maciej Jankowicz on 10.07.18, 13:17
 * Contact: mj6367@gmail.com
 */
public class BruteForcer implements Runnable{

    private char firstChar;
    private char[] startingSequence;
    private int length;
    private int possibleValues;
    private String password;
    private boolean isFound = false;
    private View view;



    public BruteForcer(Password password, char firstChar){
        this.password = password.getPassword();
        this.length = password.getLength();
        this.firstChar = firstChar;
        this.possibleValues = password.getComplexity().getComplexity();
        this.view = new View();
        prepareStartingSequence();
    }


    @Override
    public void run() {
        while (!isFound) {
            if (Thread.interrupted()) {
                break;
            }
            isFound = search();

            if (isFound) {
                view.display("Password cracked successfully. Aborting");
                BruteForceController.stopCrackingThreads();
                break;
            }
        }
    }
    private double generateCharCode(int combinationValue, int charSequencePosition) {

       return (new Double(combinationValue/(Math.pow(possibleValues, charSequencePosition)))).intValue() % possibleValues;
    }

    private boolean search() {
        if(Comparator.isPasswordFound(String.valueOf(startingSequence))){
            return true;
        }

        int lowerCaseOffset = 55;
        int upperCaseOffset = 61;
        double charCode;

        for (int i = 0; i < Math.pow(possibleValues, this.length); i++) {
            for (int j = 1; j < startingSequence.length; j++) {

                charCode = generateCharCode(i, j);

                if(charCode < Complexity.NUMS.getComplexity()) {
                    charCode += AsciiValues.LOWER_DIGIT_BOUND.getValue();

                } else if(charCode >= Complexity.NUMS.getComplexity() && charCode < Complexity.LETTERS.getComplexity()) {
                    charCode += lowerCaseOffset;

                } else if(charCode >= Complexity.LETTERS.getComplexity() && charCode < Complexity.NUMS_AND_LETTERS.getComplexity()) {
                    charCode += upperCaseOffset;
                }
                startingSequence[j] = (char) charCode;
            }

            if(Comparator.isPasswordFound(String.valueOf(startingSequence))){
                return true;
            }
        }
        return false;
    }

    private void prepareStartingSequence() {
        this.startingSequence = new char[this.length];
        this.startingSequence[0] = this.firstChar;

        for(int i = 1; i < this.length; i++){
            this.startingSequence[i] = '0';
        }
    }

    public boolean isFound() {
        return isFound;
    }
}
