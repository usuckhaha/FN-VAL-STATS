        import java.net.*;
        import java.io.*;
//@Author: Dylan Wang
        //Dylan got the JSON file out of the HTML and Angel turned it into actual information we could use
public class Analyzer{
    private static String json = "";    //we will later save only the JSON code into this class variable

    public static void retrieveJSON(Player gamer){    //retrieve the JSON file from the HTML Buffered from the url generated
        try{   //Dylan was here

            String website = "https://fortnitetracker.com/profile/all/" + gamer.getTag();  //generate website using the user-provided gamer tag

            URL tracker = new URL(website);   //create website object using the previously generated website
            URLConnection yc = tracker.openConnection();   //open connection to the wilderness
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));   //buffer go brrrrrrr
            String inputLine;   //new line
            String line = "";   //rest of the file
            while ((inputLine = in.readLine()) != null) {   //buffer new line and check if it's not empty
                line = line.concat(inputLine);   //add line to whole "file"
            }
            in.close();   //close connection. no more internet for Dylan
            line = line.substring(line.indexOf("<script type=\"text/javascript\">var imp_data = {")+31);  //I'm still too lazy to write all this in a single line;
            json = line.substring(line.indexOf("stats")+5);
            json = json.substring(json.indexOf("stats")+5);
            json = json.substring(json.indexOf("all"), json.indexOf("\"platform\": \"gamepad\","));



        }
        catch(FileNotFoundException ex)
        {
            json = "unknown";   //we really don't know:(
        }
        catch(MalformedURLException e)
        {
            json = "badly formed url exception occurred";   //too bad

        }
        catch(IOException e)
        {
            json = "IO exception occurred";   //IO stands for Input Output

        }

    }
    public static String wins(){  //get those juicy wins
        String winn = json.substring(json.indexOf("Wins"));   //I'm too lazy to write all this on a single line
        winn = winn.substring(winn.indexOf("value")+8, winn.indexOf("."));
        return winn;
    }
    public static String kdr(){  //Kill Death Ratio
        String kd = json.substring(json.indexOf("KD"));
        kd = kd.substring(kd.indexOf("value")+8);
        kd = kd.substring(0, kd.indexOf(","));
        return kd;
    }
    public static String kills(){  //Dylan go pew pew, kids go wac
        String k = json.substring(json.indexOf("Kills"));
        k = k.substring(k.indexOf("value")+8, k.indexOf("."));
        return k;
    }
    public static String matches(){  //How many times have you entered into a Fortnite match
        String mat = json.substring(json.indexOf("Matches"));
        mat = mat.substring(mat.indexOf("value")+8, mat.indexOf("."));
        return mat;
    }
    public static String winRatio(){  //Win Lose Ratio
        String wr = json.substring(json.indexOf("WinRatio"));
        wr = wr.substring(wr.indexOf("value")+8);
        wr = wr.substring(0, wr.indexOf(","));
        return wr;
    }
    public static String tmPlyd(){   //Time you have gone without taking a shower
        String t = json.substring(json.indexOf("Time Played"));
        t = t.substring(t.indexOf("displayValue")+16);
        t = t.substring(0, t.indexOf("m \"")+1);
        return t;
    }
    public static String title(){   //Warlord's entitlement
        return json.substring(json.indexOf("description")+15, json.indexOf(",", json.indexOf("description"))-1);
    }

}