package model;

/**
 * Created by Maciej Jankowicz on 10.07.18, 13:17
 * Contact: mj6367@gmail.com
 */
public class BruteForcer implements Runnable{

    private char firstChar;
    private int length;
    private char[] possibleValues;
    private char[] startingSequence;
    private boolean found;
    private String password;


    public BruteForcer(Password password){
        this.password = password.getWord();
        this.firstChar = password.getCharArray()[0];
        this.length = password.getLenght();
        this.possibleValues = password.getComplexity();
        this.startingSequence = new char[this.length];
        this.startingSequence[0] = this.firstChar;
        for(int i = 1; i < this.length; i++){
            this.startingSequence[i] = this.possibleValues[0];
        }
    }

    @Override
    public void run() {
        found = search();
    }

    private boolean search(){
        if(String.valueOf(startingSequence).equals(this.password)){
            return true;
        }

        for(int i = 0; i<Math.pow(possibleValues.length, this.length); i++){
            for(int j = 1; j < startingSequence.length; j++){
                startingSequence[j] = (char) ((new Double(i/(Math.pow(10,j)))).intValue()%10 + 48);
            }
            System.out.println(String.valueOf(startingSequence));
            if(String.valueOf(startingSequence).equals(password)){
                return true;
            }
        }
        return false;
    }
}
