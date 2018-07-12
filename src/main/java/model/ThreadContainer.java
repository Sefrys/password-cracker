package model;

import java.util.ArrayList;
import java.util.List;

public class ThreadContainer {

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
}
