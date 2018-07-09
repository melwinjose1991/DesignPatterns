package java_gof.creational;

public class DoorNeedingSpell extends Door {

	public DoorNeedingSpell() {
		super();
	}

	public DoorNeedingSpell(Room r1, Room r2) {
		super(r1, r2);
	}

	public Door clone() {
		return new DoorNeedingSpell();
	}

}
