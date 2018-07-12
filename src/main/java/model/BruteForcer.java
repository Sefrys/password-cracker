package model;

/**
 * Created by Maciej Jankowicz on 10.07.18, 13:17
 * Contact: mj6367@gmail.com
 */
public class BruteForcer implements Runnable{

    private static int idCounter = 0;

    private int id;
    private char firstChar;
    private int length;
    private int possibleValues;
    private char[] startingSequence;
    private String password;
    private boolean isFound = false;


    public BruteForcer(Password password, char firstChar) {
        this.password = password.getPassword();
        this.length = password.getLength();
        this.firstChar = firstChar;
        this.possibleValues = password.getComplexity().getComplexity();
        prepareStartingSequence();
        assignIdForNewInstance();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                break;
            }
            isFound = search();
            
            if (isFound) {
                break;
            }
        }
    }

    private boolean search() {
        if(Comparator.isPasswordFound(String.valueOf(startingSequence))){
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

            if(Comparator.isPasswordFound(String.valueOf(startingSequence))){
                return true;
            }
        }
        return false;
    }

    private void assignIdForNewInstance() {
        idCounter++;
        id = idCounter;
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
