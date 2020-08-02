package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionCorrect() {
        BishopBlack black = new BishopBlack(Cell.A1);
        assertThat(black.position(), is(Cell.A1));
    }

    @Test
    public void whenWayCorrect() throws ImpossibleMoveException {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] result = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(black.way(Cell.C1, Cell.G5), is(result));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayNotCorrect() throws ImpossibleMoveException {
        BishopBlack black = new BishopBlack(Cell.C1);
        black.way(Cell.C1, Cell.G6);
    }

    @Test
    public void whenIsDiagonalCorrect() {
        BishopBlack black = new BishopBlack(Cell.F8);
        assertThat(black.isDiagonal(Cell.F8, Cell.H6), is(true));
    }

    @Test
    public void whenCopyCorrect() {
        Figure black = new BishopBlack(Cell.A1);
        Figure blackCopy = black.copy(Cell.B2);
        assertThat(blackCopy.position(), is(Cell.B2));
    }
}