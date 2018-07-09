package java_gof.creational;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Maze {
	// Builder > Participant > Product
	
	private Map<Integer, Room> rooms;

	public Maze() {
		this.rooms = new HashMap<Integer, Room>();
	}

	public void addRoom(Room r) {
		Integer roomNumber = Integer.valueOf(r.getRoomNumber());
		rooms.put(roomNumber, r);
	}

	public Room getRoom(int roomNo) {
		return this.rooms.get(Integer.valueOf(roomNo));
	}

	public Maze clone() {
		return new Maze();
	}

	public void showMapSites() {
		System.out.println();
		Iterator<Entry<Integer, Room>> iterator = this.rooms.entrySet().iterator();
		while (iterator.hasNext()) {
			iterator.next().getValue().ShowMapSite();
		}
	}
}
