
public class Game {

	public static void main(String[] args) {
		
		final Data game  = new Data(4);
		final Moderator moderator  = new Moderator(game);
		final Player player1 = new Player(game, 0);
		final Player player2 = new Player(game, 1);
		final Player player3 = new Player(game, 2);
		final Player player4 = new Player(game, 3);
		
		Thread moderatorThread  = new Thread(moderator);
		Thread player1Thread = new Thread(player1);
		Thread player2Thread = new Thread(player2);
		Thread player3Thread = new Thread(player3);
		Thread player4Thread = new Thread(player4);
		
		
		moderatorThread. start();
		player1Thread.start();
		player2Thread.start();
		player3Thread.start(); 
		player4Thread.start(); 
				
	}
}
