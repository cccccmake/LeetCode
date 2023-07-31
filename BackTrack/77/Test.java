import java.util.*;
class Test {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> rec = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(k, n, 1);
        return res;
    }

    public void backtrack(int k, int n, int start){
        if(rec.size() == k){
            res.add(rec);
            System.out.println("res UPDATED: " + res);
            return;
        }
        for(int i = start; i <= n; i++){
            rec.add(i);
            System.out.println("rec now is: " + rec);
            backtrack(k, n, i+1);
            rec.remove(rec.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.combine(4, 2);
        System.out.println(test.res);
        return;
    }
}