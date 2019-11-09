package model;

import java.util.*;
import java.util.stream.IntStream;

public class Ladder {

	private List<Line> lines;

	public Ladder(int height, int playerSize) {

		lines = new ArrayList<>();

		IntStream.range(0, height).forEach(i -> {
			lines.add(new Line(playerSize));
		});
	}

	public List<Line> getLines() {
		return lines;
	}
}
