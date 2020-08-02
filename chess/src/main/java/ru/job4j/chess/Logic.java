package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = null;
        try {
           steps = figures[index].way(source, dest);
        } catch (IllegalStateException e) {
            throw new ImpossibleMoveException();
        }
        if (!isFree(steps)) {
            throw new OccupiedCellException();
        }
        figures[index] = figures[index].copy(dest);
    }

    private boolean isFree(Cell[] steps) throws OccupiedCellException {
        for (Cell cell : steps) {
            for (Figure figure : figures) {
                if (figure != null && figure.position().equals(cell)) {
                    throw new OccupiedCellException();
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            if (figures[index] != null && figures[index].position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
