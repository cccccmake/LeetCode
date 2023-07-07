class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> rec = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(rec.empty() == true){
                rec.push(s.charAt(i));
            }
            else{
                if(s.charAt(i) == rec.peek().charValue())
                    rec.pop();
                else
                    // this can be optimized in the very first if condition
                    rec.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(rec.empty() == false){
            sb.insert(0, rec.pop().charValue());
        }
        return sb.toString();
    }
}