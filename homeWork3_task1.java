//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
import java.util.ArrayList;

public class homeWork3 {

    public static void main(String[] args) {

        ArrayList<Integer> leftD = new ArrayList<>();
        ArrayList<Integer> rightD = new ArrayList<>();
        ArrayList<ArrayList<Integer>> blockList = new ArrayList<>(2);
        blockList.add(leftD);
        blockList.add(rightD);

        ArrayList<Integer> curRes = new ArrayList<Integer>();
        combine(0, 0, blockList, curRes);
    }

    public static boolean validPos(int numRow, int numCol, ArrayList<ArrayList<Integer>> check) {
        
        if ((check.get(0).indexOf(numRow + numCol) == -1) && (check.get(1).indexOf(numRow - numCol + 8) == -1)) {
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> combine(int curRow, int curCol, ArrayList<ArrayList<Integer>> blockList, ArrayList<Integer> curRes) {
        if (curRes.size() == 8) {
            printList(curRes);
            return curRes;
        }
        if (curRow == 8)
        {
            int temp = curRes.remove(curRes.size() - 1);
            blockList.get(0).remove(curRes.size());
            blockList.get(1).remove(curRes.size());
            combine(temp + 1, curCol - 1, blockList, curRes);
            return curRes;
        }

        if (validPos(curRow, curCol, blockList) && (curRes.indexOf(curRow) == -1)) {
            curRes.add(curRow);
            blockList.get(0).add(curRow + curCol);
            blockList.get(1).add(curRow - curCol + 8);
            combine(0, curCol + 1, blockList, curRes);
        }
        if (curRes.size() < 8) {
            combine(curRow + 1, curRes.size(), blockList, curRes);
        }
        return curRes;
    }

    public static void printList(ArrayList<Integer> arrList) {
        int sizeBoard = arrList.size();
        System.out.println("Итоговая доска:");
        for (int item : arrList) {
            for (int currCell = 0; currCell < sizeBoard; currCell++) {
                if (currCell == item) System.out.print(("Q") + "\t");
                else System.out.print((".") + "\t");
            }
            System.out.println();
        }
    }
}
