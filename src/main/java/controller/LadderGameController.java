package controller;

import java.util.*;
import java.util.stream.*;

import model.Ladder;
import model.Player;
import model.Result;
import view.LadderGameInputView;
import view.LadderGameOutputView;

public class LadderGameController {

	public void run() {

		List<String> playersNames = LadderGameInputView.inputPlayers();
		List<Player> players = playersNames.stream().map(Player::new).collect(Collectors.toList());
		List<String> inputResults = LadderGameInputView.inputResult();

		int height = LadderGameInputView.inputLadderHigh();

		Ladder ladder = new Ladder(height, players.size());
		Result result = new Result(players, inputResults, ladder);

		LadderGameOutputView.printProcess(height, playersNames, ladder, inputResults);

		while (true) {
			String wantResultByPlayerName = LadderGameInputView.printWhosResult();

			if (wantResultByPlayerName.equals("종료")) {
				break;
			}

			LadderGameOutputView.printPlayerResult(result.getPlayerResult(wantResultByPlayerName));
		}

	}
}
