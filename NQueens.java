public class NQueens {
    public static void main(String[] args) {
        QueenProblem p = new QueenProblem(6);
        p.solve();
    }
}
class QueenProblem {
    private boolean[][] board;
    private int n;

    public QueenProblem(int n) {
        board = new boolean[n][n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = false;
            }
        }
    }

    public void solve() {
        solve(board, 0);
    }

    public void solve(boolean[][] boardState, int col) {
        if (col >= n) {
            printBoard(boardState);
            return;
        }

        for (int i = 0; i < n; i++) {
            boardState[col][i] = true;
            if (isSafe(boardState, col)) {
                solve(boardState, col + 1);
            }
            boardState[col][i] = false;
        }
    }

    private void printBoard(boolean[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", (a[j][i] ? 1 : 0));
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isSafe(boolean[][] boardState, int col) {
        int row = 0;
        for (int i = 0; i < n; i++) {
            if (boardState[col][i]) row = i;
        }

        for (int i = 0; i < col; i++) {
            if (boardState[i][row]) {
                return false;
            }
        }

        for (int i = 0; (i <= col) && (i <= row); i++) {
            if (boardState[col - i][row - i]) {
                return false;
            }
        }

        for (int i = 0; i <= col && i < n - row; i++) {
            if (boardState[col - i][row + i]) {
                return false;
            }
        }

        return true;
    }
}