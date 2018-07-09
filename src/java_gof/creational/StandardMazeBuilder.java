package java_gof.creational;

public class StandardMazeBuilder extends MazeBuilder {
	// Participant : ConcreteBuilder
	
	private Maze current_maze;

	public StandardMazeBuilder() {
		this.current_maze = null;
	}

	public void buildMaze() {
		this.current_maze = new Maze();
	}

	public void buildRoom(int n) {
		if (null == this.current_maze.getRoom(n)) {
			Room room = new Room(n);
			this.current_maze.addRoom(room);
			room.setSide(Direction.NORTH, new Wall());
			room.setSide(Direction.SOUTH, new Wall());
			room.setSide(Direction.EAST, new Wall());
			room.setSide(Direction.WEST, new Wall());
		}
	}

	public void buildDoor(int n1, int n2) {
		Room r1 = this.current_maze.getRoom(n1);
		Room r2 = this.current_maze.getRoom(n2);
		Door door = new Door(r1, r2);
		r1.setSide(Direction.EAST, door);
		r2.setSide(Direction.WEST, door);
	}

	public Maze getMaze() {
		return this.current_maze;
	}
}