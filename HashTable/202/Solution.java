class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> recSet = new HashSet<>();
        while(n != 1){
            n = cal(n);
            if(recSet.contains(n)) return false;
            recSet.add(n);
        }
        // bullshit code below. If we reach here, n = 1
        /*
        if(n == 1)
            return true;
        return false;
         */
        return true;
    }

    public static int cal(int n){
        // calculate the sum of the numbers' square of n
        int res = 0;
        while(n != 0){
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
}