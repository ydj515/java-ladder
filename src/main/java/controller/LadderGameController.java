package controller;

import java.util.*;
import java.util.stream.*;

import model.Ladder;
import model.Player;
import view.LadderGameInputView;
import view.LadderrGameOutputView;

public class LadderGameController {

	public void run() {

		List<String> playersNames = LadderGameInputView.inputPlayers();
        List<Player> players = playersNames.stream().map(Player::new)
                .collect(Collectors.toList());

		int height = LadderGameInputView.inputLadderHigh();
		Ladder ladder = new Ladder(height, players.size());

		LadderrGameOutputView.printProcess(height, playersNames, ladder);
	}

}
