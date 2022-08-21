//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class homeWork3 {

    
    static int[][] moves = new int[][]{{2, 1, -1, -2, -2, -1, 1, 2}, {1, 2, 2, 1, -1, -2, -2, -1}};

    public static void main(String[] args) {

        int[][] board = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }

        board[0][0] = 1; // стартуем с точки (0,0)
        if (!findBoard(0, 0, 2, board)) {
            System.out.println("решения нет");
        } else {
            printArr(board);
        }
    }

    public static boolean validPos(int curRow, int curCol, int[][] currBoard) {

        if ((curRow >= 0) && (curCol >= 0) && (curRow < 8) && (curCol < 8)
                && (currBoard[curRow][curCol] == 0)) {
            return true;//ход в пределах доски и ячейка не занята
        }
        return false;
    }

    public static boolean findBoard(int curRow, int curCol, int count, int[][] currBoard) {
        if (count == 65) {
            return true;
        }
        for (int currMove = 0; currMove < 8; currMove++) {
            int nextRow = curRow + moves[0][currMove];
            int nextCol = curCol + moves[1][currMove];

            if (validPos(nextRow, nextCol, currBoard)) {
                currBoard[nextRow][nextCol] = count;
                if (findBoard(nextRow, nextCol, count + 1, currBoard)) {
                    return true;
                } else {
                    currBoard[nextRow][nextCol] = 0;
                }
            }
        }
        return false;
    }

    public static void printArr(int[][] arr) {
        System.out.println("print Board");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
