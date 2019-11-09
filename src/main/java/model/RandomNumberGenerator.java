package model;

import java.util.Random;

public class RandomNumberGenerator {

	private static final int MAX_RANDOM = 2;

	public static int createNumber() {
		return new Random().nextInt(MAX_RANDOM);
	}

}
