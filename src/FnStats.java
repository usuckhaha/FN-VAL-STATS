import java.util.Scanner;
//@Author: Angel
public class FnStats {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);  //User's input
        Player dylan = new Player();  //Dylan plays too much
        String gum = "";   //gamer tag. gum stands for chewing gum bc we wack-wack again and again
        System.out.println("Welcome to FN-STATS, where we get the happiness of your kd to the reach of your in-game tag.\nYou may enter \"quit\" to end your suffering");
        while(true){   //we must remain true to ourselves
            System.out.print("Lemme take a good look at your gamer tag, gamer boi: ");
            gum = scan.nextLine();
            if(gum.equals("quit"))   //are you done?
                break;     //bye bye, u
            dylan.setTag(gum);   //Dylan has got gum

            //analyzer stuff
            try {
                Analyzer.retrieveJSON(dylan);   //save Jason... or was it Jay's son?
                System.out.println("The " + Analyzer.title().toLowerCase() + ".\nWins: " + Analyzer.wins() + "\nKDR: " + Analyzer.kdr() + "\nTotal Kills: " + Analyzer.kills() + "\nTotal Time Played: " + Analyzer.tmPlyd() + "\nTotal Matches: " + Analyzer.matches() + "\nWin Ratio: " + Analyzer.winRatio() + "%\n\n");  //get them, jeff
            }
            catch(StringIndexOutOfBoundsException e){
                System.out.println("This information could not be accessed, this user profile may be set to private or may not exist at all\n");  //prints out to console if there was nothing to read on the generated website:'(
            }
        }

    }
}
