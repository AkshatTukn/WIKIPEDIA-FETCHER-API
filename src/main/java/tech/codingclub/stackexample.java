package tech.codingclub;

import java.util.*;

public class stackexample {
    public static void main(String[] args) {
        System.out.println("This is shreyansh jain ");
        System.out.println("stack example running at" + new Date().toString()+ "sharp");
        Stack<Integer> stack=new Stack<Integer>();
        //stack add or push
        stack.push(12);
        stack.push(23);
        stack.push(34);
        stack.push(44);
        stack.push(19);
        int poped=stack.pop();
        System.out.println("POPED top most element: " + poped);
        System.out.println("Currently Top most element at stack: "+stack.peek());
        System.out.println("index of 3: " + stack.get(3));
        System.out.println("index of 100: " + stack.search(200));
//iterator stack
        Iterator value = stack.iterator();
        while(value.hasNext())
        {
            System.out.println("iterator showing element" + value.next());
        }
        while(!stack.empty())
        {
            System.out.println("popoed: "+stack.pop());
        }

    }
}


