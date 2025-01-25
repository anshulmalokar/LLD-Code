package types;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private double id;
    private Cell pos;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Player() {
        this.id = ThreadLocalRandom.current().nextDouble();
        pos = new Cell(0,0);
    }

    public Cell getPos() {
        return pos;
    }

    public void setPos(Cell pos) {
        this.pos = pos;
    }
}
