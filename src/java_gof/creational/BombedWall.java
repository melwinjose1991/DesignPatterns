package java_gof.creational;

public class BombedWall extends Wall {
	private boolean hasBomb;

	public BombedWall clone() {
		BombedWall wall = new BombedWall();
		wall.SetBomb(hasBomb);
		return wall;
	}

	public boolean HasBomb() {
		return this.hasBomb;
	}

	public void SetBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
}