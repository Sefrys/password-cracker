package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

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

    public static void remove() {
        Iterator<BruteForcer> iterator = threadList.iterator();

        while(iterator.hasNext()) {
            BruteForcer element = iterator.next();

            if (element.isFound()) {
                iterator.remove();
            }
            else {
                iterator.remove();
            }
        }
    }

    public void run() {
        while(true) {
            if (Thread.interrupted()) {
                break;
            }
            remove();
            pickRandomElement();

            try {
                sleep(2000);
            }
            catch (InterruptedException e) {}
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

    public BruteForcer getRandomThread() {
        return randomThread;
    }
}
