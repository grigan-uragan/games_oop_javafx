package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.A1);
        logic.add(black);
        logic.move(Cell.C1, Cell.G5);

    }

    @Test(expected = OccupiedCellException.class)
    public void whenCellOccupiedFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C1);
        BishopBlack blackTwo = new BishopBlack(Cell.D2);
        logic.add(blackTwo);
        logic.add(black);
        logic.move(Cell.C1, Cell.G5);

    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureImpossibleMoveFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C1);
        logic.add(black);
        logic.move(Cell.C1, Cell.G6);

    }
}