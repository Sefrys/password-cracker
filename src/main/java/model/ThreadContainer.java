package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadContainer implements Runnable {

    private BruteForcer randomThread;

    public static List<BruteForcer> threadList = new ArrayList<>();

    public static void add(BruteForcer newThread) {
        threadList.add(newThread);
    }

    public static BruteForcer getElement() {
        BruteForcer result = null;
        for (BruteForcer element : threadList) {
            if (element.isFound()) {
                result = element;
                break;
            }
        }
        return result;
    }

    public void run() {
        while(true) {
            if (Thread.interrupted()) {
                break;
            }
            pickRandomElement();
        }
    }
    


    private void pickRandomElement() {
        int index = generateRandomNumber();
        randomThread = threadList.get(index);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        int range = threadList.size() - 1;

        return random.nextInt(range);
    }
}
