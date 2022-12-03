package boardgame;

public abstract class Piece {

    protected Position position;
    private final Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() { return board; }

    public abstract boolean[][] possibleMoves();

    // chamado "Hook method" (método gancho), pois utiliza uma função abstrata que será implementada nas subclasses
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat.length; j++) {
//                if (mat[i][j]) {
//                    return true;
//                }
//            }
//        }
        for (boolean[] booleans : mat) {
            for (int j = 0; j < mat.length; j++) {
                if (booleans[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
