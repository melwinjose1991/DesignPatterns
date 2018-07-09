package java.creational;

public class CountingMazeBuilder extends MazeBuilder {
	// Participant : ConcreteBuilder
	
	private int room_count, door_count;
	private Maze maze;

	public CountingMazeBuilder() {
		this.room_count = this.door_count = 0;
	}

	public void buildMaze() {
	}

	public void buildRoom(int n) {
		this.room_count++;
	}

	public void buildDoor(int n1, int n2) {
		this.door_count++;
	}

	public void AddWall(int n, Direction direction) {
	}

	public Integer[] GetCounts() {
		Integer roomCount = Integer.valueOf(this.room_count);
		Integer doorCount = Integer.valueOf(this.door_count);
		Integer[] counts = { roomCount, doorCount };
		return counts;
	}

	public Maze getMaze() {
		return this.maze;
	}
}