package java.creational;

public class MazeGame {

	// Builder Pattern > Participant > Director
	public Maze createMaze(MazeBuilder builder) {

		// this is the same construction process that the 'Intent' refers to
		builder.buildMaze();
		builder.buildRoom(1);
		builder.buildRoom(2);
		builder.buildDoor(1, 2);
		return builder.getMaze();

	}

}