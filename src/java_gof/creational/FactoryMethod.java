package java_gof.creational;

public class FactoryMethod {
	
	public static void main(String[] args) {
		
		MazeGame game;								
		Maze maze;
		
		game = new BombedMazeGame();		// ConcreteCreator created
		maze = game.CreateMaze(true);		// ConcreteProduct created
		maze.showMapSites();
		
		game = new EnchantedMazeGame();
		maze = game.CreateMaze(true);
		maze.showMapSites();
	}
	
}
