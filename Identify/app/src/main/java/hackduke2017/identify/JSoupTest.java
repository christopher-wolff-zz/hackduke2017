package hackduke2017.identify;


import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
/**
 * Created by danielli on 10/28/17.
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSoupTest{
    public static void main(String[] args) throws IOException{
        System.out.print(wikiThis("Tax"));
    }

    public static String wikiThis(String item) throws IOException{
        String url ="https://simple.wikipedia.org/wiki/"+ item;
        Document doc = Jsoup.connect(url).get();
        Elements paragraphs= doc.select("p");
        StringBuilder textBlock=new StringBuilder();
        for(Element p: paragraphs){
            textBlock.append(p.text());
            textBlock.append("\n");
        }

        return textBlock.toString();
    }
}
