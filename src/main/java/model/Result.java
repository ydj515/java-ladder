package model;

import java.util.*;

public class Result {

	private HashMap<String, String> resultMap = new HashMap<>();
	private List<Player> players;

	public Result(List<Player> players, List<String> inputResults, Ladder ladder) {
		validSize(players, inputResults);

		this.players = players;
		Position position = new Position(players, inputResults, ladder);
		resultMap = position.getResultMap(inputResults, players);
	}

	public String getPlayerResult(String wantResultByPlayerName) {

		validWantResultByPlayerName(wantResultByPlayerName);

		if (wantResultByPlayerName.equals("all")) {
			String result = "";

			for (int i = 0; i < players.size(); i++) {
				result = result + players.get(i).getName() + " : " + resultMap.get(players.get(i).getName()) + "\n";
			}

			return result;
		}

		return resultMap.get(wantResultByPlayerName);
	}

	private void validSize(List<Player> players, List<String> inputResults) {
		if (players.size() != inputResults.size()) {
			throw new IllegalArgumentException("이름의 수와 결과의 수가 다릅니다.");
		}
	}

	private void validWantResultByPlayerName(String wantResultByPlayerName) {
		if (!wantResultByPlayerName.equals("all") && resultMap.get(wantResultByPlayerName) == null) {
			throw new IllegalArgumentException("원하는 결과를 잘못 입력하였습니다.");
		}
	}

}