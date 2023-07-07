class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> res = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(operator.contains(tokens[i])){
                int num1 = Integer.valueOf(res.pop());
                int num2 = Integer.valueOf(res.pop());
                int cal = 0;
                if(tokens[i].equals("+")) cal = num1 + num2;
                else if(tokens[i].equals("-")) cal = num1 - num2;
                else if(tokens[i].equals("*")) cal = num1 * num2;
                else cal = num1 / num2;
                res.push(Integer.valueOf(cal));
            }
            else{
                res.push(Integer.parseInt(tokens[i]));
            }
        }
        return Integer.valueOf(res.pop());
    }
}