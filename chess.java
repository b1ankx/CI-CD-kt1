import java.util.Random;

class ChessBoard {
    char[][] board;
    int kingX, kingY;
    int rookX, rookY;
    int bishopX, bishopY;

    public ChessBoard() {
        board = new char[8][8];
        initializeBoard();
        placeRandomPieces();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeRandomPieces() {
        Random random = new Random();

        kingX = random.nextInt(8);
        kingY = random.nextInt(8);
        board[kingX][kingY] = 'K';

        rookX = random.nextInt(8);
        rookY = random.nextInt(8);
        while (rookX == kingX && rookY == kingY) {
            rookX = random.nextInt(8);
            rookY = random.nextInt(8);
        }
        board[rookX][rookY] = 'L';

        bishopX = random.nextInt(8);
        bishopY = random.nextInt(8);
        while ((bishopX == kingX && bishopY == kingY) || (bishopX == rookX && bishopY == rookY)) {
            bishopX = random.nextInt(8);
            bishopY = random.nextInt(8);
        }
        board[bishopX][bishopY] = 'S';
    }

    public boolean isCheck() {
        // проверяем, находятся ли король и ладья в одной строке или столбце
        if (kingX == rookX || kingY == rookY) {
            return true;
        }

        // проверяем, находятся ли король и слон на одной диагонали
        if (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY)) {
            return true;
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class chess {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        System.out.println("Исходная шахматная доска:");
        chessBoard.printBoard();

        if (chessBoard.isCheck()) {
            System.out.println("Шах! Король находится под угрозой.");
        } else {
            System.out.println("Шаха нет. Король в безопасности.");
        }
    }
}
