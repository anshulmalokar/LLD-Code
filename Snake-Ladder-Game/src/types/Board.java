package types;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] board;

    public Board(int size){
        board = new Cell[size][size];
        init();
    }

    public Cell getCell(int x, int y){
        return board[x][y];
    }

    private void init(){
        int numOfLadder = ThreadLocalRandom.current().nextInt(1,3);
        addLadders(numOfLadder);
        int numOfSnakes = ThreadLocalRandom.current().nextInt(1,3);
        addSnake(numOfSnakes);
    }

    private void addLadders(int numberOfLadder){
        for(int i=0;i<numberOfLadder;i++){
            int x1 = ThreadLocalRandom.current().nextInt(0,9);
            int y1 = ThreadLocalRandom.current().nextInt(0, 9);
            Cell start = board[x1][y1];
            int x2 = -1;
            while (x2 < x1){
                x2 = ThreadLocalRandom.current().nextInt(0,9);
            }
            int y2 = ThreadLocalRandom.current().nextInt(0, 9);
            start.setJump(new Jump(x2, y2));
        }
    }

    private void addSnake(int numberOfSnakes){
        for(int i=0;i<numberOfSnakes;i++){
            int x1 = ThreadLocalRandom.current().nextInt(0,9);
            int y1 = ThreadLocalRandom.current().nextInt(0, 9);
            Cell start = board[x1][y1];
            int x2 = 11;
            while (x2 > x1){
                x2 = ThreadLocalRandom.current().nextInt(0,9);
            }
            int y2 = ThreadLocalRandom.current().nextInt(0, 9);
            start.setJump(new Jump(x2, y2));
        }
    }
}