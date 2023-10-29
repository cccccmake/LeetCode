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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String str = String.valueof(x);
        char[] chars = str.toCharArray();
        char[] array = new char[chars.length];
        for(int i = chars.length - 1; i >= 0; i--){
            array[chars.length - 1 - i] = chars[i];
        }
        long value = Long.valueOf(String.valueOf(array));
        return value > Integer.MAX_VALUE ? 0 : (int) value;
    }

    public static void main(String[] args) {
        Solution solu = new Solution();
        System.out.println(solu.reverse(Integer.MAX_VALUE));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
