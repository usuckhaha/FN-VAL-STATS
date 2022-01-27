        import java.net.*;
        import java.io.*;


public class Analyzer{

    public static String wins(String ign){



        try{

            String website = "https://fortnitetracker.com/profile/all/" + ign;

            URL tracker = new URL(website);
            URLConnection yc = tracker.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            String line = "";
            while ((inputLine = in.readLine()) != null) {
                line = line.concat(inputLine);
            }
            in.close();

            line = line.substring(line.indexOf("<script type=\"text/javascript\">var imp_data = {")+31,line.indexOf("<script type=\"text/x-template\" id=\"trn-profile-header-favorite-template\">")-9);
            String json = line.substring(line.indexOf("stats")+5);
            json = json.substring(json.indexOf("stats")+5);
            json = json.substring(json.indexOf("all"));



        }
        catch(FileNotFoundException ex)
        {
            return "unknown";
        }
        catch(MalformedURLException e)
        {
            return "badly formed url exception occurred";

        }
        catch(IOException e)
        {
            return "IO exception occurred";

        }

    }


}