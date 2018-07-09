package java_gof.creational;

public class Room extends MapSite {
	private int roomNumber;
	private MapSite sides[] = { null, null, null, null };

	public Room() {
		super();
	}

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void Enter() {
	}

	public MapSite getSide(Direction direction) {
		return this.sides[direction.ordinal()];
	}

	public void setSide(Direction direction, MapSite mapSite) {
		this.sides[direction.ordinal()] = mapSite;
	}

	public Room clone() {
		return new Room();
	}

	public void Initailize(int n) {
		this.roomNumber = n;
	}

	public void ShowMapSite() {
		String string = getClass().getName();
		System.out.println(string);
		for (Direction direction : Direction.values()) {
			if (null != this.sides[direction.ordinal()]) {
				System.out.print(direction.name() + ":");
				this.sides[direction.ordinal()].ShowMapSite();
			}
		}
	}
}