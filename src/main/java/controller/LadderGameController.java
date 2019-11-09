package controller;

import java.util.*;

import model.Ladder;
import model.Player;
import view.LadderGameInputView;
import view.LadderrGameOutputView;

public class LadderGameController {

	public void run() {

		List<String> playersNames = LadderGameInputView.inputPlayers();
		List<Player> players = createPlayerList(playersNames);

		int height = LadderGameInputView.inputLadderHigh();
		Ladder ladder = new Ladder(height, players.size());

		LadderrGameOutputView.printProcess(height, playersNames, ladder);
	}

	private List<Player> createPlayerList(List<String> playersName) {
		List<Player> players = new ArrayList<>();
		playersName.stream().forEach(i -> {
			players.add(new Player(i));
		});

		return players;
	}

}
