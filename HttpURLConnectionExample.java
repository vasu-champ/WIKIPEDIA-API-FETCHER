package uitility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
    private final static String USER_AGENT = "Mozilla/5.0";
    public static String sendGet(String urlStr) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line ;
        while((line=rd.readLine())!=null){
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) {
        try{
            String urlStr = "https://en.wikipedia.org/wiki/Albert_Einstein";
            System.out.println(sendGet(urlStr));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

