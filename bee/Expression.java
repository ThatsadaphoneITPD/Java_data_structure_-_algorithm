package com.bee;
import java.util.Stack;//isEmty push and pop get form here stack libary
public class Expression {

    public static boolean Expre(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
    public static void main(String args[]) {
        String E1 = "A * (B - C)";
        String E2 = "A * (B - C";
        String E3 = "(A * (B+C))";
        String E4 = "(A * (B+C)";

        System.out.println(E1 +" ==> "+ Expre(E1));
        System.out.println(E2 +" ==> "+ Expre(E2));
        System.out.println(E3 +" ==> "+ Expre(E3));
        System.out.println(E4 +" ==> "+ Expre(E4));
    }
}
