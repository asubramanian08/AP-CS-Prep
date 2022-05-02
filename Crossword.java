public class Crossword {
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares) {
        puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int lastLabel = 0;
        for (int i = 0; i < puzzle.length; i++)
            for (int j = 0; j < puzzle[0].length; j++)
                if (toBeLabeled(i, j, blackSquares))
                    puzzle[i][j] = new Square(blackSquares[i][j], ++lastLabel);
                else
                    puzzle[i][j] = new Square(blackSquares[i][j], 0);
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        if (blackSquares[r][c])
            return false;
        boolean aboveFilled = (r == 0 || blackSquares[r - 1][c]);
        boolean leftFilled = (c == 0 || blackSquares[r][c - 1]);
        return aboveFilled || leftFilled;
    }
}