package java_gof.creational;

public class BombedMazeGame extends MazeGame {
	// FactoryMethod > Participant > ConcreteCreator
	
	public BombedMazeGame() {
	}

	public Wall MakeWall() {
		return new BombedWall();
	}

	public Room MakeRoom(int roomNumber) {
		return new RoomWithABomb(roomNumber);
	}
	
}