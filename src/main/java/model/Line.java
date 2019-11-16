package model;

import java.util.*;
import java.util.stream.*;

public class Line {

	private ArrayList<String> points;

	private final String PIPE = LadderString.PIPE();
	private final String TAB = LadderString.TAB();
	private final String HORIZONTAL_LINE = LadderString.HORIZONTAL_LINE();

	public Line(int playerSize) {
		points = new ArrayList<>();
		createLines(playerSize);
	}

	public ArrayList<String> getPoints() {
		return points;
	}

	private void createLines(int playerSize) {
		IntStream.range(0, 2 * playerSize - 1).forEach(i -> {
			checkEvenOrOdd(i);
		});
	}

	private boolean checkEvenOrOdd(int index) {

		String result = (index % 2 == 0) ? addString(PIPE)
				: checkRandomNumber(RandomNumberGenerator.createNumber(), index);

		return Optional.ofNullable(result).isPresent();
	}

	private String checkRandomNumber(int randomNumber, int index) {

		String result = (randomNumber == 1) ? addLine(index) : addString(TAB);

		return result;
	}

	private String addLine(int index) {

		String result = null;

		try {
			result = points.get(index - 2).equals(HORIZONTAL_LINE) ? addString(TAB) : addString(HORIZONTAL_LINE);
		} catch (Exception e) {
			result = addString(HORIZONTAL_LINE);
		}

		return result;
	}

	private String addString(String toAddString) {
		points.add(toAddString);

		return toAddString;
	}
}
