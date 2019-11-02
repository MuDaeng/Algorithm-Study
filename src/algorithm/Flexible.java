package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flexible {
	private static final Food[] foods = { new Food("Wine", 89, 123), new Food("Beer", 90, 154), 
			new Food("Pizza", 95, 258), new Food("Burger", 100, 354), new Food("Fires", 90, 365),
			new Food("Coke", 79, 150), new Food("Apple", 50, 95), new Food("Donut", 10, 195) };
	
	public void testGreedy(int maxUnits) {
		System.out.println("Use greedy by value to allocate " + maxUnits + " calories");
		testGreedy(foods, maxUnits, Criteria.Value);
		System.out.println("Use greedy by calories to allocate " + maxUnits + " calories");
		testGreedy(foods, maxUnits, Criteria.Calories);
		System.out.println("Use greedy by density to allocate " + maxUnits + " calories");
		testGreedy(foods, maxUnits, Criteria.Density);
	}
	private void testGreedy(Food[] foods, int maxUnits, Criteria priority) {
		Food[] tmp = foods.clone();
		switch(priority) {
		case Value : 
			sort(tmp, (a, b) -> {return a < b.getValue();}, a -> {return (float) a.getValue();});
			break;
		case Calories :
			sort(tmp, (a, b) -> {return a > b.getCalories();}, a -> {return (float) a.getCalories();});
			break;
		case Density :
			sort(tmp , (a, b) -> {return a > getDensity(b);}, a -> { return getDensity(a);});
			break;
		}
		int count = 0;
		int calories = 0;
		int totalVal = 0;
		do {
			calories += tmp[count].getCalories();
			totalVal += tmp[count++].getValue();
		}while(count < tmp.length && calories < maxUnits);
		System.out.println("Total value of items taken : " + totalVal);
		for(int i = 0; i < count; i++) {
			System.out.println("\t"+ tmp[i].getName() + " : <" + tmp[i].getValue() + ", "+ tmp[i].getCalories() + ">");
		}
	}
	private void sort(Food[] foods, IBoolPriority boolPriority, IGetMember<Float> member) {
		for(int i = 0; i < foods.length; i++) {
			float bestValue = member.getter(foods[i]);
			int bestPos = i;
			for(int j = i + 1; j < foods.length; j++) {
				if(boolPriority.boolPriority(bestValue, foods[j])) {
					bestPos = j;
					bestValue = (float) member.getter(foods[j]);
				}
			}
			Food tmp = foods[i];
			foods[i] = foods[bestPos];
			foods[bestPos] = tmp;
		}
	}
	private float getDensity(Food food) {
		return food.getValue() / food.getCalories();
	}
}
