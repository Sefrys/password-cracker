package model;

import utils.AsciiValues;
import utils.Complexity;

/**
 * Created by Maciej Jankowicz on 10.07.18, 13:17
 * Contact: mj6367@gmail.com
 */
public class BruteForcer implements Runnable{

    private char firstChar;
    private int length;
    private int possibleValues;
    private char[] startingSequence;
    private String password;


    public BruteForcer(Password password, char firstChar){
        this.password = password.getPassword();
        this.length = password.getLength();
        this.firstChar = firstChar;
        this.possibleValues = password.getComplexity().getComplexity();
        prepareStartingSequence();
    }

    @Override
    public void run() {

//        while (true) {
//            if (Thread.interrupted()) {
//                break;
//            }
            boolean found = search();
//        }
    }

    private boolean search(){
        if(Comparator.isPasswordFound(String.valueOf(startingSequence))){
            return true;
        }

        int numOffset = 55;
        int numLetterOffset = 61;
        double charCode;

        for(int i = 0; i<Math.pow(possibleValues, this.length); i++){
            for(int j = 1; j < startingSequence.length; j++){

                charCode = ((new Double(i/(Math.pow(possibleValues,j)))).intValue() % possibleValues);
                if(charCode < Complexity.NUMS.getComplexity()) {
                    charCode += AsciiValues.LOWER_DIGIT_BOUND.getValue();
                }else if(charCode >= Complexity.NUMS.getComplexity() && charCode < Complexity.LETTERS.getComplexity()){
                    charCode += numOffset;
                }else if(charCode >= Complexity.LETTERS.getComplexity() && charCode < Complexity.NUMS_AND_LETTERS.getComplexity()){
                    charCode += numLetterOffset;
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
}
