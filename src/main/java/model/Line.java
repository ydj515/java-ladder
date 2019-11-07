package model;

import java.util.*;
import java.util.stream.*;

public class Line {

	private ArrayList<String> points;

	private final String PIPE = "|";
	private final String TAB = "\t";
	private final String HORIZONTAL_LINE = "-------";

	public Line(int playerSize) {
		points = new ArrayList<>();
		createLines(playerSize, points);
	}

	public ArrayList<String> getPoints() {
		return points;
	}

	private void createLines(int playerSize, List<String> points) {
		IntStream.range(0, 2 * playerSize - 1).forEach(i -> {
			checkEvenOrOdd(i, points);
		});
	}

	private void checkEvenOrOdd(int index, List<String> points) {

		if (index % 2 == 0) { // 짝수
			points.add(PIPE);
		}

		else { // 홀수
			int randomNumber = RandomNumberGenerator.createNumber();
			checkRandomNumber(randomNumber, points, index);
		}
	}

	private void checkRandomNumber(int randomNumber, List<String> points, int index) {
		if (randomNumber == 1) {
			if (index == 1) {
				points.add(HORIZONTAL_LINE);
			} else if (points.get(index - 2).equals(HORIZONTAL_LINE)) { // 바로 옆에 "-------" 이거 못옴
				// lines.add("aa");
				points.add(TAB);
			} else {
				points.add(HORIZONTAL_LINE);
			}

		}

		else {
			points.add(TAB);
		}
	}

}
