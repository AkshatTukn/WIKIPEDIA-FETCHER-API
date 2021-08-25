package tech.codingclub;

import java.util.Scanner;
import java.util.Stack;

public class datastructure2 {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                while (sc.hasNext()) {
                    String input=sc.next();
                    System.out.println("input is: " + input);

                    Stack<Character> stack = new Stack<Character>();
                    boolean balanced = true;
                    for(int i = 0 ; i< input.length(); i++ ){
                        char ch = input.charAt(i);//
                        if( ch=='(' || ch=='{' || ch=='[' ){
                            stack.push(ch);
                        }else{
                            // closing bracket
                            if(stack.size()==0){
                                // Not balanced !
                                balanced = false;
                                break;
                            }else if(  (ch==')' && stack.peek() == '(') ||  ( ch=='}' && stack.peek() == '{') ||  (ch==']' && stack.peek() == '[') ){
                                stack.pop();
                            }else{
                                // Not balanced !
                                balanced = false;
                                break;
                            }
                        }
                    }

                    if(stack.size()!=0)
                        balanced = false;

                    System.out.println(balanced);

                }

            }
        }





