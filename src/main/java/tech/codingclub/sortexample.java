package tech.codingclub;

import java.util.*;

public class sortexample {
    public static void main(String[] args) {
        System.out.println("This is shreyansh jain ");
        System.out.println("set example running at" + new Date().toString() + "sharp");

        ArrayList<String> emails = new ArrayList();
        emails.add("hr@gooogle.com");
        emails.add("contact@codingclube.com");
        emails.add("admin@tiktok.com");
        System.out.println("Before sort: "+ emails);
        Collections.sort(emails);
        System.out.println("after sort : ##############");
        for(String x:emails)
        {
            System.out.println(x);
        }
        int arr[]={50,10,3,19,14};
        Arrays.sort(arr);
        for(int element:arr){
            System.out.println(arr);
        }


    }
}


