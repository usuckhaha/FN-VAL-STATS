import java.net.*;
import java.io.*;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class Analyzer{
   
   public static String wins(String ign){
   
  
    
    try{
      
     String website = "https://fortnitetracker.com/profile/all/" + ign;
     
     URL tracker = new URL(website);
     URLConnection yc = tracker.openConnection();
     BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));     
      String inputLine;
      String line = "";
     
    while ((inputLine = in.readLine()) != null)
      		      line+=inputLine;
                

        			in.close();
        		   line = line.substring(line.indexOf("<script type=\"text/javascript\">var imp_data = {")+31,line.indexOf("<script type=\"text/x-template\" id=\"trn-profile-header-favorite-template\">")-9);
                Object file = JSONValue.parse(line);
                JSONObject json = (JSONObject)file;
    
	              JSONObject stats = (JSONObject) json.get("stats");
                 System.out.println(stats);
                     
             
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

			  
           	
			  


