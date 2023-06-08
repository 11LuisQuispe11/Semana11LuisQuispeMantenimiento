import javax.swing.ImageIcon;
import java.util.ArrayList;

public class King extends ChessGamePiece {
    private ChessGameBoard board;
    private int row;
    private int col;
    private int color;

    public King(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, false);
        this.board = board;
        this.row = row;
        this.col = col;
        this.color = color;
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = calculateMovesInAllDirections(board, 1);
        return allMoves;
    }

    // Técnica utilizada: Extract Method
    private ArrayList<String> calculateMovesInAllDirections(ChessGameBoard board, int distance) {
        ArrayList<String> moves = new ArrayList<String>();
        moves.addAll(calculateMovesInDirection(board, distance, 1, 1));
        moves.addAll(calculateMovesInDirection(board, distance, -1, 1));
        moves.addAll(calculateMovesInDirection(board, distance, 1, -1));
        moves.addAll(calculateMovesInDirection(board, distance, -1, -1));
        moves.addAll(calculateMovesInDirection(board, distance, 0, 1));
        moves.addAll(calculateMovesInDirection(board, distance, 0, -1));
        moves.addAll(calculateMovesInDirection(board, distance, 1, 0));
        moves.addAll(calculateMovesInDirection(board, distance, -1, 0));
        return moves;
    }

    // Técnica utilizada: Extract Method
    private ArrayList<String> calculateMovesInDirection(ChessGameBoard board, int distance, int rowChange, int colChange) {
        ArrayList<String> moves = new ArrayList<String>();
        int newRow = row + rowChange;
        int newCol = col + colChange;
        if (isValidMove(board, newRow, newCol)) {
            moves.add(getMoveString(newRow, newCol));
        }
        return moves;
    }

    private boolean isValidMove(ChessGameBoard board, int newRow, int newCol) {
        // Lógica para validar el movimiento en el tablero
        // ...
        return true;
    }

    public boolean isChecked(ChessGameBoard board) {
        return getCurrentAttackers(board).size() > 0;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        String imagePath = getImagePath();
        return new ImageIcon(getClass().getResource(imagePath));
    }

    // Técnica utilizada: Extract Method
    private String getImagePath() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return "chessImages/WhiteKing.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return "chessImages/BlackKing.gif";
        } else {
            return "chessImages/default-Unassigned.gif";
        }
    }
}

