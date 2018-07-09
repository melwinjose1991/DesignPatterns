package java_gof.creational;

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

	// Factory Method > Participant > AbstractCreator
	public Maze CreateMaze(boolean useFactoryMethod) {

		Maze maze = MakeMaze();

		Room r1 = MakeRoom(1);
		Room r2 = MakeRoom(2);
		Door door = MakeDoor(r1, r2);

		maze.addRoom(r1);
		maze.addRoom(r2);

		r1.setSide(Direction.NORTH, new Wall());
		r1.setSide(Direction.EAST, door);
		r1.setSide(Direction.SOUTH, new Wall());
		r1.setSide(Direction.WEST, new Wall());
		r2.setSide(Direction.NORTH, new Wall());
		r2.setSide(Direction.EAST, new Wall());
		r2.setSide(Direction.SOUTH, new Wall());
		r2.setSide(Direction.WEST, door);

		return maze;

	}

	// Factory Methods
	public Maze MakeMaze() {
		return new Maze();
	}

	public Room MakeRoom(int n) {
		return new Room(n);
	}

	public Wall MakeWall() {
		return new Wall();
	}

	public Door MakeDoor(Room r1, Room r2) {
		return new Door(r1, r2);
	}
	// Different games can subclass MazeGame to specialize parts of the maze.
	// MazeGane subclasses can redefine some or all of the methods to specify
	// variations in products.
	
	// Abstract Factory vs Builder
	//	https://sites.google.com/site/sureshdevang/abstract-factory-vs-builder-design-patterns
	
	// Factory Methods vs Abstract Factory
	//	https://dzone.com/articles/factory-method-vs-abstract

}