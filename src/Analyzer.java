        import java.net.*;
        import java.io.*;

//wins, kdr, kills, time played, win percentage, matches,
public class Analyzer{
    private String json = "";

    public void retrieveJSON(String ign){
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
            this.json = line.substring(line.indexOf("stats")+5);
            this.json = this.json.substring(this.json.indexOf("stats")+5);
            this.json = this.json.substring(this.json.indexOf("all"), this.json.indexOf("\"platform\": \"touch\","));



        }
        catch(FileNotFoundException ex)
        {
            this.json = "unknown";
        }
        catch(MalformedURLException e)
        {
            this.json = "badly formed url exception occurred";

        }
        catch(IOException e)
        {
            this.json = "IO exception occurred";

        }
        if(!this.json.contains("[0-9]"))
            System.out.println(this.json);

    }
    public String wins(){
        String winn = this.json.substring(this.json.indexOf("Wins"));
        winn = winn.substring(winn.indexOf("value")+3, winn.indexOf("."));
        return winn;
    }
    public String kdr(){
        String kd = this.json.substring(this.json.indexOf("KD"));
        kd = kd.substring(kd.indexOf("value")+3, kd.indexOf(","));
        return kd;
    }


}