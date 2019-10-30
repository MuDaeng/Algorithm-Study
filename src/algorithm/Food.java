package algorithm;

public class Food {
	private String name;
	private int value;
	private int calories;
	
	public Food(String name, int value, int calories) {
		this.name = name;
		this.value = value;
		this.calories = calories;
	}
	public String getName() {
		return name;
	}
	public int getValue() {
		return value;
	}
	public int getCalories() {
		return calories;
	}
}
