package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int deltaX = source.getX() > dest.getX() ? -1 : 1;
        int deltaY = source.getY() > dest.getY() ? -1 : 1;
        int size = (dest.getX() - source.getX()) / deltaX;
        Cell[] steps = new Cell[size];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.findBy(source.getX() + deltaX * (i + 1),
                    source.getY() + deltaY * (i + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaY = source.getY() > dest.getY() ? -1 : 1;
        int deltaX = source.getX() > dest.getX() ? -1 : 1;
        int delta = (dest.getX() - source.getX()) * deltaX;
        return source.getY() + delta * deltaY == dest.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
