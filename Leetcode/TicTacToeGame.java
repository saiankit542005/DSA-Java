public class TicTacToeGame {
    /**
     * fillBoard method:
     * - moves array ke according board fill karta hai
     * - even index par Player A ("X")
     * - odd index par Player B ("O")
     * - har move ke baad winner check karta hai
     * 
     * @param board 3x3 Tic Tac Toe board
     * @param moves players ke moves (row, col)
     * @return "A", "B", "Draw" ya "Panding"
     */
    public String fillBoard(String board[][], int moves[][]) {
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
    
            if (i % 2 == 0) {
                board[row][col] = "X";

                if (checkWinner("X", board)) {
                    return "A";
                }

            } else {
            
                board[row][col] = "O";
                if (checkWinner("O", board)) {
                    return "B";
                }
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }

        return "Panding";
    }
    public void printBoard(String board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    System.out.print("_   ");
                } else {
                    System.out.print(board[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
    public boolean checkWinner(String s, String board[][]) {

        /**
         * rows check
         */
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(s) &&
                    board[i][1].equals(s) &&
                    board[i][2].equals(s)) {
                return true;
            }
        }
        /**
         * columns check
         */
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(s) &&
                    board[1][j].equals(s) &&
                    board[2][j].equals(s)) {
                return true;
            }
        }
        /**
         * main diagonal check
         */
        if (board[0][0] == s &&
                board[1][1] == s &&
                board[2][2] == s) {
            return true;
        }
        /**
         * anti-diagonal check
         */
        if (board[0][2].equals(s) &&
                board[1][1].equals(s) &&
                board[2][0].equals(s)) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
       //board initialize
        String board[][] = {
                { "", "", "" },
                { "", "", "" },
                { "", "", "" }
        };

        // moves of player (row, col)
        int moves[][] = {
                { 0, 0 }, { 0, 1 },
                { 0, 2 }, { 1, 0 },
                { 1, 1 }, { 1, 2 },
                { 2, 1 }, { 2, 0 },
                { 2, 2 }

        };

        TicTacToeGame obj = new TicTacToeGame();

        String result = obj.fillBoard(board, moves);
        System.out.println("Game Board");
        obj.printBoard(board);
        System.out.println();

        if (result.equals("A") || result.equals("B")) {
            System.out.println("Conguratulations,Winner is " + result);
        } else {
            System.out.println("Match " + result);
        }

        System.out.println();
    }
}
