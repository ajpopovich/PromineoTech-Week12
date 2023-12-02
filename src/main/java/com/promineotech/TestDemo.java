package com.promineotech;

import java.util.Random;

public class TestDemo {

public int addPositive(int a, int b) {
	if (a >= 0 && b >= 0) {
		return a + b;
	} else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}
public static double calculateAreaOfRectangle(double length, double width) {
	return length * width;
	//this method simply calculates the area of a rectangle with a given length and width
}
public int randomNumberSquared() {
	int result = getRandomInt();
	return result * result;
}
public int getRandomInt() {
	Random random = new Random();
	return random.nextInt(10) + 1;
}


}
