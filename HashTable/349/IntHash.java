class IntHash {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hashArray = new int[1001];
        // List<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> res = new HashSet<>();
        for(int item : nums1)
            hashArray[item]++;
        for(int item : nums2){
            if(hashArray[item] > 0)
                res.add(item);
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}