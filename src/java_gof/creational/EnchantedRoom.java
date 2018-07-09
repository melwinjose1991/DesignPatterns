package java_gof.creational;

public class EnchantedRoom extends Room {

	public EnchantedRoom() {
		super();
	}

	public EnchantedRoom(int roomNumber) {
		super(roomNumber);
	}

	public EnchantedRoom clone() {
		return new EnchantedRoom();
	}

}
