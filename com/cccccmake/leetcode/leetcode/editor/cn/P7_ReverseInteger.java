package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3921 👎 0

/**
 * 整数反转
 *
 * @author saint
 */
public class P7_ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7_ReverseInteger().new Solution();
        System.out.println(solution.reverse(Integer.MAX_VALUE));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverseBruteForce(int x) {
        // special value
        if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE){
            return 0;
        }
        // symbol extraction
        int symbol = x > 0 ? 1 : -1;
        // transform into positive value
        x = Math.abs(x);
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char[] array = new char[chars.length];
        for(int i = chars.length - 1; i >= 0; i--){
            array[chars.length - 1 - i] = chars[i];
        }
        long value = Long.valueOf(String.valueOf(array));
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int) value;
        return result * symbol;
    }

    public int reverseInPlace(int x) {
        // special value
        // NOT responsible for the values larger than MAX_VALUE or less than MIN_VALUE
        if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE){
            return 0;
        }
        // symbol extraction
        int symbol = x > 0 ? 1 : -1;
        // transform into positive value
        x = Math.abs(x);
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        for(int i = 0, j = chars.length - 1; i < j; i++, j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        long value = Long.valueOf(String.valueOf(chars));
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int) value;
        return result * symbol;
    }
    public int reverse(int x) {
        // reverse using the mathematical method
        long value = 0;
        while(x != 0){
            int singleBit = x % 10;
            x /= 10;
            value = value * 10 + singleBit;
        }
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int) value;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}