package tech.codingclub.fetcherandthread;

public class WikiResult {
   public String query;
   public String text_result;
   public String image_url;

   public WikiResult()
    {


    }
public WikiResult(String query,String text_result,String image_url)
{
    this.query=query;
    this.image_url=image_url;
    this.text_result=text_result;
}
public  String getText_result(){
       return text_result;
}

}
