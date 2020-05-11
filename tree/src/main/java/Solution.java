import java.util.Stack;
import java.util.regex.Pattern;
public class Solution {
    public int evalRPN(String[] tokens) {
        int a,b,tmp;
        Stack<Integer> stack = new Stack<>();
        if(tokens.length == 1 && isNumeric(tokens[0])){
            return Integer.parseInt(tokens[0]);
        }
        for(String str : tokens){
            if(isNumeric(str)){
               stack.push(Integer.parseInt(str));
            }else{
                b = stack.pop();
                a = stack.pop();
                if(str.equals("+")){
                    tmp = a + b;
                }else if(str.equals("-")){
                    tmp = a - b;
                }else if(str.equals("*")){
                    tmp = a * b;
                }else{
                    tmp = a / b;
                }
                stack.push(tmp);
            }
            
        }
        return stack.peek();
    }
    public  boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^-?[1-9]+[0-9]*$|^0$");
        return pattern.matcher(str).matches();   
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String []strs = new String[]{"3","-4","+"};
        System.out.println(solution.evalRPN(strs));
    }
}