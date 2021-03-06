package barqsoft.footballscores.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import barqsoft.footballscores.R;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilities {
    public static final int FILLERLEAGUE = 357;
    public static final int BUNDESLIGA = 394;
    public static final int BUNDESLIGA2 = 395;
    public static final int LIGUE = 396;
    public static final int LIGUE2 = 397;
    public static final int PREMIER_LEAGUE = 398;
    public static final int PRIMERA_DIVISION = 399;
    public static final int SEGUNDA_DIVISION = 400;
    public static final int SERIE_A = 401;
    public static final int PRIMERA_LIGA = 402;
    public static final int BUNDESLIGA3 = 403;
    public static final int EREDIVISIE = 404;
    public static final int CHAMPIONS_LEAGUE = 405;

    public static String getLeague(Context context, int league_num)
    {
        switch (league_num) {
            case SERIE_A:
                return context.getString(R.string.seria_a);
            case PREMIER_LEAGUE:
                return context.getString(R.string.premierleague);
            case CHAMPIONS_LEAGUE:
                return context.getString(R.string.champions_league);
            case PRIMERA_DIVISION:
                return context.getString(R.string.primera_division);
            case FILLERLEAGUE:
                return context.getString(R.string.filler_leage);
            case LIGUE:
            case LIGUE2:
                return context.getString(R.string.ligue);
            case SEGUNDA_DIVISION:
                return context.getString(R.string.segunda_division);
            case PRIMERA_LIGA:
                return context.getString(R.string.primera_liga);
            case EREDIVISIE:
                return context.getString(R.string.eredivisie);
            case BUNDESLIGA:
            case BUNDESLIGA2:
            case BUNDESLIGA3:
                return context.getString(R.string.bundesliga);
            default:
                //todo strings.xml
                return context.getString(R.string.unknown_league);
        }
    }

    public static String getMatchDay(int match_day, int league_num) {
        if (league_num == CHAMPIONS_LEAGUE) {
            if (match_day <= 6) {
                return "Group Stages, Matchday : 6";
            } else if (match_day == 7 || match_day == 8) {
                return "First Knockout round";
            } else if (match_day == 9 || match_day == 10) {
                return "QuarterFinal";
            } else if (match_day == 11 || match_day == 12) {
                return "SemiFinal";
            } else {
                return "Final";
            }
        } else {
            return "Matchday : " + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals, int awaygoals) {
        if (home_goals < 0 || awaygoals < 0) {
            return " - ";
        } else {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName(String teamname) {
        if (teamname == null) {
            return R.mipmap.no_icon;
        }

        switch (teamname) { //This is the set of icons that are currently in the app. Feel free to find and add more
            //as you go.
            case "Arsenal London FC":
                return R.drawable.arsenal;
            case "Manchester United FC":
                return R.drawable.manchester_united;
            case "Swansea City":
                return R.drawable.swansea_city_afc;
            case "Leicester City":
                return R.drawable.leicester_city_fc_hd_logo;
            case "Everton FC":
                return R.drawable.everton_fc_logo1;
            case "West Ham United FC":
                return R.drawable.west_ham;
            case "Tottenham Hotspur FC":
                return R.drawable.tottenham_hotspur;
            case "West Bromwich Albion":
                return R.drawable.west_bromwich_albion_hd_logo;
            case "Sunderland AFC":
                return R.drawable.sunderland;
            case "Stoke City FC":
                return R.drawable.stoke_city;
            case "FC Zenit St. Petersburg":
                return R.mipmap.zenit_st_petersburg;
            case "Olympique Lyonnais":
                return R.mipmap.olympique_lyonnais;
            default:
                return R.mipmap.no_icon;
        }
    }


    /**
     * Check if there are connected networks.
     *
     * @param context
     * @return is there a connected network.
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

}
