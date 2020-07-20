package ru.job4j.puzzle;

public class Win {
    public static boolean isHorizontal(int[][] board, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVertical(int[][] board, int cell) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][cell] != 1) {
                return false;
            }
        }
        return true;
    }

    public static int[] extractDiagonal(int[][] board) {
       int[] result = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = board[i][i];
        }
        return result;
    }

    public static boolean check(int[][] board) {
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < diagonal.length; i++) {
            if (diagonal[i] == 1) {
                return isHorizontal(board, i) || isVertical(board, i);
            }
        }
        return false;
    }
}
