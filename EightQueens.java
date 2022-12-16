public class EightQueens {
    static int[] queens = new int[8]; // Stores the column number for each row

    public static void main(String[] args) {
        placeQueens(0);
    }

    public static void placeQueens(int row) {
        if (row == 8) {
            // All queens have been placed, print the solution
            printSolution();
            return;
        }
        for (int col = 0; col < 8; col++) {
            // Try placing a queen in the current row and column
            if (isSafe(row, col)) {
                queens[row] = col; // Place the queen
                placeQueens(row + 1); // Place the remaining queens
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        // Check if the current position is safe for a queen
        for (int r = 0; r < row; r++) {
            // Check if any queens in the same column
            if (queens[r] == col) {
                return false;
            }
            // Check if any queens in the same diagonal
            if (Math.abs(queens[r] - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution() {
        // Print the solution
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
