class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        int[] charRec = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            charRec[magazine.charAt(i) - 'a']++;
            // You need to consider the boundary of the index
            if(i < ransomNote.length())
                charRec[ransomNote.charAt(i) - 'a']--;
        }
        for(int item : charRec){
            if(item < 0)
                return false;
        }
        return true;
    }
}