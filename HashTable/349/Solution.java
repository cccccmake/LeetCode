class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> numRec = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int item : nums1)
            numRec.add(item);
        for(int item : nums2){
            if(numRec.contains(item))
                res.add(item);
        }
        // Integer[] finalRes = new Integer[res.size()];
        // WTF is this?
        // finalRes = res.toArray(finalRes);
        // WTF is this?
        return res.stream().mapToInt(i->i).toArray();
    }
}