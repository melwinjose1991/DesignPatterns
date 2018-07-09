package java_gof.creational;

public class BuilderClient {
	
	public static void main(String[] args) {

		Maze maze;
		MazeGame maze_game = new MazeGame();
		
		StandardMazeBuilder standard_maze_builder = new StandardMazeBuilder();
		maze_game.createMaze(standard_maze_builder);
		maze = standard_maze_builder.getMaze();
		maze.showMapSites();

		CountingMazeBuilder counting_maze_builder = new CountingMazeBuilder();
		maze_game = new MazeGame();
		maze = maze_game.createMaze(counting_maze_builder);
		Integer counts[] = counting_maze_builder.GetCounts();
		System.out.println("The maze has " + counts[0].intValue() + " rooms and " + counts[1].intValue() + " doors");
		
	}
}