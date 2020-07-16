package com.annuel.project.server.entites;




import com.annuel.project.server.model.Matches;

import java.util.ArrayList;
import java.util.List;

public class Compteur {

    public static int nbMatches = 0;
    public static int nbMatchesMemeDate = 1;
    public static int nbMatchesTotal = 10;
    public static int nbPlayerTotal = 40;
    public static int getNbTeamTotal = 40;
    public static int nbPlayer = 0;
    public static int nbTeam = 0;
    public static int nbGames = 0;
    public static int getNbGameTotal = 20;
    public static String currentDate="0";
    public static List<Matches> listMatchs = new ArrayList<>();
    public static List<Player> collectPlayer = new ArrayList<>();
    public static List<Team> collectTeam = new ArrayList<>();
    public static List<Game> collectGames = new ArrayList<>();



    public static void modifyDate(String date2)
    {
        if(!currentDate.contains(date2))
        {
            nbMatches++;
            nbMatchesMemeDate=1;
            currentDate=date2;
        }
    }


}
