package com.company.challange;

import com.company.challange.FootballPlayer;
import com.company.challange.League;

public class Main {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread());

        League<Team<FootballPlayer>> footballLeagPoland = new League<>("Liga mistrzów");
        Team<FootballPlayer> lech = new Team<>("Lech");
        Team<FootballPlayer> legia = new Team<>("Legia");

        footballLeagPoland.add(lech);
        footballLeagPoland.add(legia);

        lech.matchResult(legia, 1, 3);
        lech.matchResult(legia, 2, 2);
        legia.matchResult(lech, 1, 0);

        footballLeagPoland.showLeagueTable();

        FootballPlayer roberLeandowski = new FootballPlayer("Robert Lewandowski");
        FootballPlayer kubaBlaszczykowski = new FootballPlayer("Kuba Błaszczykwoski");

        lech.addPlayer(roberLeandowski);
        legia.addPlayer(kubaBlaszczykowski);
        legia.addPlayer(kubaBlaszczykowski);

    }
}
