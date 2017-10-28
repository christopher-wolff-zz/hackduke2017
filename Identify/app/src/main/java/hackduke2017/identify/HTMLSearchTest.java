package hackduke2017.identify;

import java.net.*;
import java.io.*;

/**
 * Created by danielli on 10/28/17.
 */

import org.jsoup.Jsoup;
public class HTMLSearchTest {
    public static void main(String args[]) {
        try{
            searchArticles("football players");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void searchArticles (String item)throws Exception{

        String stringToReverse = URLEncoder.encode(item, "UTF-8");

        URL url = new URL("https://yahoo.com");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write(item);
        out.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }

}
