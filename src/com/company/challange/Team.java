package com.company.challange;

/* ArrayList<Team>;
Collections.sort (teams);
Create a generic class to implement a league table for sports.
The class should allow adding teams to the list and storing
lists of teams belonging to the league.

Your class should have a method of writing out the teams in alphabetical order.
First, we print the team at the top of the league.

Add only units of the same type to each detail.
- league instance - the program can not compile
if you try to add an incompatible team.
*/

import java.util.ArrayList;
// Player - top limit
public class Team <T extends Player> implements Comparable<Team<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost= 0;
    int tied = 0;
    private ArrayList<T> members = new  ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() + "is in team already");
            return false;
        } else{
            members.add(player);
            System.out.println(player.getName() + "picked for team");
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;

        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        //} else if (this.ranking() < this.ranking()) {
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
