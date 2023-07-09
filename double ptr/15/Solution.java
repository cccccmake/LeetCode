class Solution {
    public String reverseWords(String s) {
        int slow = 0;
        int fast = s.length() - 1;
        // remove the redandent spaces in the head and the tail
        while(s.charAt(slow) == ' ') slow++;
        while(s.charAt(fast) == ' ') fast--;
        // reverse the whole string
        while(slow < fast){
            char temp = s.charAt(fast);
            s.charAt(fast) = s.charAt(slow);
            s.charAt(slow) = temp;
        }
        // reverse word by word
        slow = 0;
        fast = 0;
        for(; fast < s.length(); fast++){
            while(fast < s.length() && s.charAt(fast) != ' ') fast++;
            // reaches '' or fast == s.length()
            if(fast < s.length()){
                // update the slow for next iteration
                int newSlow = fast;
                fast--;
                // reverse the word happens here
                while(slow < fast){
                    char temp = s.charAt(fast);
                    s.charAt(fast) = s.charAt(slow);
                    s.charAt(slow) = temp;
                }
                slow = newSlow + 1;
            }
            else{
                // reached the end of the string/array
                fast--;
                while(slow < fast){
                    char temp = s.charAt(fast);
                    s.charAt(fast) = s.charAt(slow);
                    s.charAt(slow) = temp;
                }
            }
        }
        return;
    }
}