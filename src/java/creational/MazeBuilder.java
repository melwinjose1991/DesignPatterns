package java.creational;

public abstract class MazeBuilder {
	// Builder > Participant > Builder

	public abstract void buildMaze();

	public abstract void buildRoom(int room);

	public abstract void buildDoor(int roomFrom, int roomTo);

	public abstract Maze getMaze();

}