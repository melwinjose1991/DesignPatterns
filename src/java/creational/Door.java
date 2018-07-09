package java.creational;

public class Door extends MapSite {
	
	private Room room1, room2;
	private boolean isOpen = false;

	public void Enter() {
	}

	public Door() {
		super();
	}

	public Door(Room r1, Room r2) {
		this.room1 = r1;
		this.room2 = r2;
	}

	public void Initialize(Room r1, Room r2) {
		this.room1 = r1;
		this.room2 = r2;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void open() {
		this.isOpen = true;
	}

	public void close() {
		this.isOpen = false;
	}

	public Room OtherSideFrom(Room r) {
		if (room1.equals(r)) {
			return room2;
		}
		if (room2.equals(r)) {
			return room1;
		}
		return null;
	}

	public Door clone() {
		return new Door();
	}
}