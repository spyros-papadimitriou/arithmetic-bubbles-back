package gr.spyros.arithmetic_bubbles.utils;

import java.util.List;

public class NumberUtils {
    public static int getRandomInteger(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

}
