        import java.net.*;
        import java.io.*;

//wins, kdr, kills, time played, win percentage, matches,
public class Analyzer{
    private static String json = "";

    public static void retrieveJSON(Player gamer){
        try{

            String website = "https://fortnitetracker.com/profile/all/" + gamer.getTag();

            URL tracker = new URL(website);
            URLConnection yc = tracker.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            String line = "";
            while ((inputLine = in.readLine()) != null) {
                line = line.concat(inputLine);
            }
            in.close();

            line = line.substring(line.indexOf("<script type=\"text/javascript\">var imp_data = {")+31,line.indexOf("<script type=\"text/x-template\" id=\"trn-profile-header-favorite-template\">"));
            json = line.substring(line.indexOf("stats")+5);
            json = json.substring(json.indexOf("stats")+5);
            json = json.substring(json.indexOf("all"), json.indexOf("\"platform\": \"touch\","));



        }
        catch(FileNotFoundException ex)
        {
            json = "unknown";
        }
        catch(MalformedURLException e)
        {
            json = "badly formed url exception occurred";

        }
        catch(IOException e)
        {
            json = "IO exception occurred";

        }
        //if(!json.contains("[0-9]"))
          //  System.out.println(json);

    }
    public String wins(){
        String winn = json.substring(json.indexOf("Wins"));
        winn = winn.substring(winn.indexOf("value")+8, winn.indexOf("."));
        return winn;
    }
    public String kdr(){
        String kd = json.substring(json.indexOf("KD"));
        kd = kd.substring(kd.indexOf("value")+8, kd.indexOf(","));
        return kd;
    }
    public static String kills(){
        String k = json.substring(json.indexOf("Kills"));
        k = k.substring(k.indexOf("value")+8, k.indexOf("."));
        return k;
    }
    public String matches(){
        String mat = json.substring(json.indexOf("Matches"));
        mat = mat.substring(mat.indexOf("value")+8, mat.indexOf("."));
        return mat;
    }
    public String winRatio(){
        String wr = json.substring(json.indexOf("KD"));
        wr = wr.substring(wr.indexOf("value")+8, wr.indexOf(","));
        return wr;
    }
    public String tmPlyd(){
        String t = json.substring(json.indexOf("KD"));
        t = t.substring(t.indexOf("value")+8, t.indexOf(","));
        return t;
    }

}