public class NQueens {
    public static void main(String[] args) {
        int N = 8; // Change N to the desired board size
        solveNQueens(N);
    }

    public static void solveNQueens(int N) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensHelper(board, 0, N);
    }

    public static void solveNQueensHelper(char[][] board, int row, int N) {
        if (row == N) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, row + 1, N);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, int N) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
