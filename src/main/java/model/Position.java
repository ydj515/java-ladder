package model;

import java.util.*;

public class Position {

	private final String TAB = LadderString.TAB();
	private final String HORIZONTAL_LINE = LadderString.HORIZONTAL_LINE();

	List<Integer> positionList = new ArrayList<>();

	private int rowPosition;
	private int colPosition;

	public Position(List<Player> players, List<String> inputResults, Ladder ladder) {
		move(players, inputResults, ladder);
	}

	private void move(List<Player> players, List<String> inputResults, Ladder ladder) {
		for (int i = 0; i < ladder.getLines().get(0).getPoints().size(); i += 2) {
			positionList.add(getPosition(i, ladder) / 2);
		}
	}

	private int getPosition(int i, Ladder ladder) {

		rowPosition = i;
		colPosition = 0;

		while (colPosition < ladder.getLines().size()) {
			judgeIsZeroPosition(ladder);
		}

		return rowPosition;
	}

	private boolean judgeIsZeroPosition(Ladder ladder) {
		return rowPosition == 0 ? judgeGoRignt(ladder) : judgeIslastPosition(ladder);
	}

	private boolean judgeIslastPosition(Ladder ladder) {
		boolean result = rowPosition == ladder.getLines().get(0).getPoints().size() - 1 ? judgeGoLeft(ladder)
				: ladder.getLines().get(colPosition).getPoints().get(rowPosition - 1).equals(TAB)
						&& ladder.getLines().get(colPosition).getPoints().get(rowPosition + 1).equals(TAB) ? moveDown()
								: judgeGoLefrOrRight(ladder);
		return result;
	}

	private boolean judgeGoLefrOrRight(Ladder ladder) {
		return ladder.getLines().get(colPosition).getPoints().get(rowPosition - 1).equals(HORIZONTAL_LINE)
				? moveLeft() && moveDown()
				: moveRight() && moveDown();

	}

	private boolean judgeGoRignt(Ladder ladder) {
		return ladder.getLines().get(colPosition).getPoints().get(rowPosition + 1).equals(HORIZONTAL_LINE)
				? moveDown() && moveRight()
				: moveDown();
	}

	private boolean judgeGoLeft(Ladder ladder) {
		return ladder.getLines().get(colPosition).getPoints().get(rowPosition - 1).equals(HORIZONTAL_LINE)
				? moveDown() && moveLeft()
				: moveDown();
	}

	private boolean moveDown() {
		colPosition++;
		return true;
	}

	private boolean moveLeft() {
		rowPosition -= 2;
		return true;
	}

	private boolean moveRight() {
		rowPosition += 2;
		return true;
	}

	public HashMap<String, String> getResultMap(List<String> inputResults, List<Player> players) {
		HashMap<String, String> resultMap = new HashMap<>();
		positionList.stream().forEach(i -> {
			resultMap.put(players.get(i).getName(), inputResults.get(positionList.get(i)).toString());
		});
		return resultMap;
	}

}
