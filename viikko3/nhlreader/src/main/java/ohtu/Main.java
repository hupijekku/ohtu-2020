package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Oliot:");
        
        ArrayList<Player> suomalaiset = new ArrayList<Player>();
        
        for (Player player : players) {
        	//System.out.println(player.getNationality());
            if (player.getNationality().equals("FIN")) {
            	//System.out.println("A");
            	suomalaiset.add(player);
            }
        }
        
        Collections.sort(suomalaiset, (o1, o2) -> ((o1.getGoals() + o1.getAssists()) < (o2.getGoals() + o2.getAssists()))?1:-1);
        
        for (Player player : suomalaiset) {
        	System.out.println(String.format("%-20s - %-3s - %s + %s = %s", player.getName(), player.getNationality(), player.getGoals(), player.getAssists(), player.getGoals() + player.getAssists()));
        }
    }
  
}
