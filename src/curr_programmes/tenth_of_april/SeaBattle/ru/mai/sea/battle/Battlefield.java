package src.curr_programmes.tenth_of_april.SeaBattle.ru.mai.sea.battle;

import java.util.*;

public class Battlefield {

    private final int size;
    private final State field[][];
    private final List<String> alphabet = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

    public Battlefield(int size) {
        this.size =size;
        field = new State[size][size];
        for (int i = 0; i < field.length; ++i) {

            for (int j = 0; j < field[i].length; ++j) {

                field[i][j] = State.EMPTY;
            }
        }
    }

    private void paintCells(int x, int y) {

        field[x][y] = State.FULL;
        for (int i = -1; i <= 1; ++i) {

            for (int j = -1; j <= 1; ++j) {

                int cellX = x + i;
                int cellY = y + j;
                if (cellX < size && cellY < size && cellX > -1 && cellY > -1 && field[cellX][cellY] == State.EMPTY) {
                    field[cellX][cellY] = State.BUSY;
                }
            }

        }
    }

    public void show() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("   1  2  3  4  5  6  7  8  9  10\n");
        for (int i = 0; i < size; ++i) {

            buffer.append(alphabet.get(i)).append(" ");
            for (int j = 0; j < size; ++j) {

                buffer.append("[");
                switch (field[i][j]) {
                    case EMPTY: {
                        buffer.append(" ");
                        break;
                    }
                    case BUSY: {
                        buffer.append("v");
                        break;
                    }
                    case FULL: {
                        buffer.append("*");
                        break;
                    }
                    case BROKEN: {
                        buffer.append("x");
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value");
                }
                buffer.append("]");
            }
            buffer.append("\n");
        }
        System.out.println(buffer.toString());
    }

    public void fillRandom() {

        addShip(4);

       addShip(3);
       addShip(3);

       addShip(2);
       addShip(2);
       addShip(2);

        addShip(1);
        addShip(1);
        addShip(1);
        addShip(1);
    }

    public void addShip(int shipSize) {
        int x;
        int y;
        int diffX;
        int diffY;
        do {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            int way = (int) (Math.random() * 4);
            diffX = 0;
            diffY = 0;
            switch (way) {
                case 0: // север
                    diffX = 0;
                    diffY = 1;
                    break;
                case 1: // восток
                    diffX = 1;
                    diffY = 0;
                    break;
                case 2: // юг
                    diffX = 0;
                    diffY = -1;
                    break;
                case 3: // запад
                    diffX = -1;
                    diffY = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value" + way);
            }
        } while (!checkCurrentAndNextCell(x, y, diffX, diffY, shipSize));
    }

    private boolean checkCurrentAndNextCell(int x, int y, int diffX, int diffY, int shipLength) {

        if (field[y][x] == State.EMPTY) {
            shipLength--;
            if (shipLength == 0) {
                paintCells(x, y);
                return true;
            }
            int newX = x + diffX;
            int newY = y + diffY;
            if (newX > -1 && newY > -1 && newX < size && newY < size
                    && checkCurrentAndNextCell(newX, newY, diffX, diffY, shipLength)) {
                paintCells(x, y);
                return true;
            }
        }
        return false;
    }

}
