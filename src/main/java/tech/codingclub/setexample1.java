package tech.codingclub;

import java.util.*;

public class setexample1 {
    public static void main(String[] args) {


        System.out.println("This is shreyansh jain ");
        System.out.println("set example running at" + new Date().toString() + "sharp");

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("hr@gooogle.com");
        arrayList.add("contact@codingclube.com");
        arrayList.add("admin@tiktok.com");
        arrayList.add("admin@yahoo.com");
        arrayList.add("hr@tiktok.com");
        arrayList.add("admin@linkedin.com");
        arrayList.add("admin@yahoo.com");
        Set<String> uniqueemails = new HashSet<String>();
        uniqueemails.add("admin@google.com");
        uniqueemails.addAll(arrayList);
        ArrayList<String> blacklistemail=new ArrayList<String>();
        blacklistemail.add("hr@tiktok.com");
        blacklistemail.add("admin@tiktok.com");
        Iterator<String> iterator = uniqueemails.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator showing: " + iterator.next());
        }
        for (String x : uniqueemails) {
            System.out.println("for loop showing : " + x);

        }
    System.out.println("size of set: "+uniqueemails.size());
        uniqueemails.remove("admin@linkedin.com");

        uniqueemails.removeAll(blacklistemail);
        System.out.println("removing linkedin mail");
        for(String x:uniqueemails)
        {
            System.out.println("send mail : " + x);

        }
        boolean codingclubindia=uniqueemails.contains("contact@codingclube.com");
       System.out.println(codingclubindia);
    }

}
