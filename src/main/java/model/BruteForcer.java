package model;

import java.util.Date;

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
        this.possibleValues = 10 ;//password.getComplexity().getComplexity();
        this.startingSequence = new char[this.length];
        this.startingSequence[0] = this.firstChar;
        for(int i = 1; i < this.length; i++){
            this.startingSequence[i] = '0';
        }
    }

    @Override
    public void run() {
        System.out.println("running");
        Date start = new Date();
        boolean found = search();
        Date end = new Date();
        if(found) System.out.println("it took: " + (end.getTime() - start.getTime()) + "ms");
        System.out.println("end");
    }

    private boolean search(){
        if(String.valueOf(startingSequence).equals(this.password)){
            return true;
        }

        double charCode = -1d;

        for(int i = 0; i<Math.pow(possibleValues, this.length); i++){
            for(int j = 1; j < startingSequence.length; j++){

                charCode = ((new Double(i/(Math.pow(possibleValues,j)))).intValue()%possibleValues); //+48
                if(charCode <10) {                      //numbers
                    charCode += 48;
                }else if(charCode>=10 && charCode<36){  //letters
                    charCode += 55;
                }else if(charCode >=36 && charCode<62){
                    charCode += 61;
                }
                startingSequence[j] = (char) charCode;
            }

            if(Checker. (startingSequence)){
                System.out.println("found password: " + String.valueOf(startingSequence));
                return true;
            }
        }
        return false;
    }
}
