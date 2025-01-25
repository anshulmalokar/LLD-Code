package Manager;

import types.Board;
import types.Cell;
import types.Dice;
import types.Player;

import java.util.ArrayDeque;

public class GameManager {
    private Board board;
    private Dice dice;
    private ArrayDeque<Player> players = new ArrayDeque<>();
    private boolean winner = false;

    public GameManager(){
        board = new Board(10);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers(){
        players.add(new Player());
        players.add(new Player());
    }

    public void startGame(){
        while (!winner){
            Player currPlayer = players.removeFirst();
            Cell cell = currPlayer.getPos();
            int steps = dice.rollDice();
            int[] arr = new int[2];
            findNewPos(arr, steps, cell);
            int x1=arr[0];
            int y1=arr[1];
            if(x1 >= 10 || y1>=10 || x1 < 0 || y1 < 0){
                System.out.println("Player rolled out of bound playing again + " + currPlayer.getId());
            }else{
                Cell newPlayerCell = getCell(x1, y1);
                currPlayer.setPos(newPlayerCell);
                cell = currPlayer.getPos();
                System.out.println(currPlayer.getId() + "x: " + cell.getX() + "  y: " + cell.getY());
                players.addLast(currPlayer);
                if(cell.getX() == 0 && cell.getY() == 0){
                    System.out.println(currPlayer.getId() + " is the winner");
                    winner = true;
                }
            }
        }
    }

    private void findNewPos(int[] arr, int steps, Cell cell){
        int currX = cell.getX();
        int currY = cell.getY();
        int newTotal = currY*currX + steps;
        if(newTotal > 81){
            arr[0] = -1;
            arr[1] = -1;
            return;
        }
        arr[0] = currX;
        arr[1] = currY;
    }

    private Cell getCell(int x, int y){
        Cell boardCell = board.getCell(x,y);
        if(boardCell.getJump() == null){
            return boardCell;
        }else{
            int x1 = boardCell.getX();
            int y1 = boardCell.getY();
            return board.getCell(x1, y1);
        }
    }
}