import org.junit.Test;
import static org.junit.Assert.*;

public class chess_test {

    @Test
    public void testIsCheckWhenRookThreatensKing() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.kingX = 3;
        chessBoard.kingY = 4;
        chessBoard.rookX = 3;
        chessBoard.rookY = 7;
        chessBoard.bishopX = 5;
        chessBoard.bishopY = 6;

        assertTrue(chessBoard.isCheck());
    }

    @Test
    public void testIsCheckWhenBishopThreatensKing() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.kingX = 2;
        chessBoard.kingY = 3;
        chessBoard.bishopX = 5;
        chessBoard.bishopY = 6;
        chessBoard.rookX = 4;
        chessBoard.rookY = 7;

        assertTrue(chessBoard.isCheck());
    }

    @Test
    public void testIsCheckWhenNoThreatToKing() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.kingX = 1;
        chessBoard.kingY = 1;
        chessBoard.rookX = 3;
        chessBoard.rookY = 5;
        chessBoard.bishopX = 6;
        chessBoard.bishopY = 7;

        assertFalse(chessBoard.isCheck());
    }

    @Test
    public void testPrintBoard() {
        ChessBoard chessBoard = new ChessBoard();
        assertNotNull(chessBoard);
        chessBoard.printBoard(); 
    }
}

