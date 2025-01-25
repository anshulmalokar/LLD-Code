package types;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int min = 1;
    private final int max = 6;
    private int count = 1;

    public Dice(int count){
        this.count = count;
    }

    public int rollDice(){
        int time = 0;
        int steps = 0;
        while (time < count) {
            steps += ThreadLocalRandom.current().nextInt(min, max);
            time++;
        }
        return steps;
    }
}
