package java_gof.creational;

public abstract class MapSite implements Cloneable {
	
	private int test;

	public MapSite() {
		test = 1;
	}

	public int getTest() {
		return test;
	}

	public abstract void Enter();

	public void ShowMapSite() {
		String string = getClass().getName();
		System.out.println(string);
	}

}