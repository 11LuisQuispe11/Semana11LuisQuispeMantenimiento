import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Queen extends ChessGamePiece {
    private ChessGameBoard board;
    private int row;
    private int col;
    private int color;

    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        this.board = board;
        this.row = row;
        this.col = col;
        this.color = color;
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = calculateMovesInAllDirections(board, 8);
        return allMoves;
    }

    // Técnica utilizada: Extract Method
    private ArrayList<String> calculateMovesInAllDirections(ChessGameBoard board, int distance) {
        ArrayList<String> moves = new ArrayList<String>();
        moves.addAll(calculateNorthEastMoves(board, distance));
        moves.addAll(calculateNorthWestMoves(board, distance));
        moves.addAll(calculateSouthEastMoves(board, distance));
        moves.addAll(calculateSouthWestMoves(board, distance));
        moves.addAll(calculateNorthMoves(board, distance));
        moves.addAll(calculateSouthMoves(board, distance));
        moves.addAll(calculateWestMoves(board, distance));
        moves.addAll(calculateEastMoves(board, distance));
        return moves;
    }

    // Resto del código sin cambios

    @Override
    public ImageIcon createImageByPieceType() {
        String imagePath = getImagePath();
        return new ImageIcon(getClass().getResource(imagePath));
    }

    // Técnica utilizada: Extract Method
    private String getImagePath() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return "chessImages/WhiteQueen.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return "chessImages/BlackQueen.gif";
        } else {
            return "chessImages/default-Unassigned.gif";
        }
    }
}

