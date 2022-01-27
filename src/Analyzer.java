import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.nio.charset.*;
import org.json.*;


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
                         System.out.println(line+ "AHAAAAA");

        			in.close();
        			int pos=0;
	                    
			        pos = line.indexOf("'metadata': {'key': 'Top1', 'name': 'Wins','categoryKey': 'tops','categoryName': 'Tops','isReversed': false},'value': ", pos+1);
      			  if(pos>-1)
        			{
          			 //int endbdayIndex = line.indexOf("'metadata': {'key': 'Top1', 'name': 'Wins','categoryKey': 'tops','categoryName': 'Tops','isReversed': false},'value': ");
            
          				String wins = line.substring(pos+211, pos+215);
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

			  
           	
			  


