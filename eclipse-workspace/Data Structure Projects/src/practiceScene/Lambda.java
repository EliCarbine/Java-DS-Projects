package practiceScene;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        Player[] players = getPlayersArray();

        // TODO 1 - sort the players in ascending order by name and then (if the names are equal) by score
		//Comparator<Player> ascend = new Player();
        //Arrays.sort(players);;

        System.out.println("players sorted in ascending order by name and then by score: " + Arrays.toString(players));

        // TODO 2 - sort the players in ascending order by score and then (if the scores are equal) by name
		
        Comparator<Player> byScore = new score(); 
        Arrays.sort(players,byScore);

        System.out.println("players sorted in ascending order by score and then by name: " + Arrays.toString(players));

    }

    private static Player[] getPlayersArray() {
        return new Player[] {
                new Player("Jane", 56),
                new Player("John", 34),
                new Player("Olivia", 47),
                new Player("Kate", 67),
                new Player("Adam", 39),
                new Player("Josh", 60),
                new Player("Jane", 67),
                new Player("Adam", 65),
                new Player("Olivia", 47),
                new Player("Dave", 39)
        };
    }
}
class score extends Player{
	@Override
    public int compare(Player one,Player two) {
    	int name = one.getName().compareTo(two.getName());
    	int score = Integer.compare(one.getScore(), two.getScore());
    	
    	if (score != 0) {
    		return score;
    	}
    	return name;
    }
}
class Player implements Comparator<Player>{
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
    @Override
    public int compare(Player one,Player two) {
    	int name = one.getName().compareTo(two.getName());
    	int score = Integer.compare(one.getScore(), two.getScore());
    	
    	if (name != 0) {
    		return name;
    	}
    	return score;
    }
    
}

