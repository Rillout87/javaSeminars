import java.util.ArrayList;
import java.util.List;

class Solution {
       
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        genComb(n, k, 0, new ArrayList<>());
        return result;
    }

    private void genComb(int n, int k, int prevE1, List<Integer> curComb) {
        if (curComb.size() == k) {
            result.add((new ArrayList<>(curComb)));
        }

        for (int i = prevE1 + 1; i <= n; i++) {
            curComb.add(i);
            genComb(n, k, i, curComb);
            curComb.remove(curComb.size() - 1);
        }
    }
}

