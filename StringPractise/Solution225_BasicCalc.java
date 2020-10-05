package StringPractise;

import java.util.Stack;

public class Solution225_BasicCalc {
    public int calculate(String s) {
        if(s == null || s.length() ==0)
            return 0;
        Stack<Integer> stack  = new Stack<>();
        int i =0;
        char prevSign = '+';
        int num =0;
       
        while(i< s.length()){
            char current = s.charAt(i);
                
            if(Character.isDigit(current)){
                num = num*10 + current -'0';
            }
            if(!Character.isDigit(current) && current != ' ' || i == s.length()-1){
                if(prevSign == '+'){
                    stack.push(num);
                }else if(prevSign == '-')
                {
                    stack.push(-num);
                }else if(prevSign == '*'){
                    stack.push(stack.pop()*num);
                }else{
                    stack.push(stack.pop()/num);
                }

                prevSign = current;
                num =0;
            }
            i++;
            
        }
        int result =0;
        while(stack.size()>0){
            result += stack.pop();
        }
        

        return result;
    }
    public static void main(String args[]){
        Solution225_BasicCalc calc=  new Solution225_BasicCalc();
        System.out.println(calc.calculate(" 2+ 3 * 4 "));

    }
}