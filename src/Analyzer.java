import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Analyzer{
   
   public static String wins(String ign){
   
   BufferedReader br = null;
    
    try{
      
     String website = "https://fortnitetracker.com/profile/all/" + ign;
     
     URL tracker = new URL(website);
     
     br = new BufferedReader(new InputStreamReader(tracker.OpenStream()));
     
      String inputLine;
      String line = "";
     
    while ((inputLine = br.readLine()) != null)
      		      line+=inputLine;
        
        			br.close();
        			int pos=0;
	                    
			        pos = line.indexOf("WINS");
      			  if(pos>-1)
        			{
          			 int endbdayIndex = line.indexOf("matchesFiltered.reduce(function (total, match) { return total + self.getStat(match.stats, 'Top1').value }, 0);");
          				String wins = line.substring(pos+6, endbdayIndex);
          				return "Wins: " + wins ;                
			    		}
    					else
    						return "We don't know";
                     
             
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

			  
           	
			  


