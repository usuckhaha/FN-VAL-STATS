import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class FnStats {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Player dylan = new Player();
        String gum = "";
        System.out.println("Welcome to FN-VAL-STATS, where we get the happiness of your kd to the reach of your in-game tag");
        while(true){
            System.out.print("Lemme take a good look at your gamer tag, gamer boi: ");
            gum = scan.nextLine();
            if(gum.equals("quit"))
                break;
            dylan.setTag(gum);

            //analyzer stuff
            Analyzer.retrieveJSON(dylan);
            System.out.println(Analyzer.kills());

        }

    }
}
