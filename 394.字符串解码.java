/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String decodeString0(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int singleNumber = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> number = new Stack<>();
        Stack<Character> string = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                singleNumber = singleNumber * 10 + chars[i] - '0';
            } else if (chars[i] == '[' && (chars[i] >= 'a' && chars[i] <= 'z')) {
                if (singleNumber != 0) {
                    number.push(singleNumber);
                    singleNumber = 0;
                }
                string.push(chars[i]);
            } else if (chars[i] == ']') {
                int repeat = 1;
                if(!number.isEmpty()){
                    repeat = number.pop();
                }
                StringBuilder partial = new StringBuilder();
                while(!string.isEmpty() && string.peek() != '['){
                    partial.append(string.pop());
                }
                if(!string.isEmpty()){
                    string.pop();
                    partial.insert(0, string.pop());
                }
                for(int j = 1; j < repeat; j++){
                    partial.append(partial);
                }
                res.append(partial.toString());
            }
        }
        return res.toString();
    }
    public String decodeString(String s) {
        int multi = 0;
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        // stores the string appears before '['
        Stack<String> partialStack = new Stack<>();
        Stack<Integer> repeatStack = new Stack<>();
        for(char c : chars){
            // calculate the repeat times
            if(c <= '9' && c >= '0'){
                multi = multi * 10 + c - '0';
            }else if(c == '['){
                // need to store the current results before
                // starting building the string within the brackets
                // e.g., abc2[ab]
                repeatStack.push(multi);
                partialStack.push(res.toString());
                // reset the repeat time and the StringBuilder for the current string
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                // end of the brackets
                StringBuilder tmp = new StringBuilder();
                int currentMulti = repeatStack.pop();
                // tmp.append(partialStack.pop());
                // repeat the current string
                for(int i = 0; i < currentMulti; i++){
                    tmp.append(res);
                }
                // don't forget the string before the '['
                res = new StringBuilder(partialStack.pop() + tmp);
            }else{
                // StringBuilder for the current string
                res.append(c);
            }
        }
        return res.toString();
    }
}
// @lc code=end
