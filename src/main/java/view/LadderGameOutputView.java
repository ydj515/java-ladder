package view;

import java.util.*;
import java.util.stream.*;

import model.Ladder;

public class LadderGameOutputView {

	private final static String TAB = "\t";

	public static void printProcess(int height, List<String> players, Ladder ladder, List<String> results) {
		System.out.println("사다리 결과");
		System.out.println(String.join(TAB, players));
		printLadder(height, ladder);
		printResult(results);
	}

	private static void printLadder(int height, Ladder ladder) {
		IntStream.range(0, height).forEach(i -> {
			printLine(i, ladder);
			System.out.println();
		});
	}

	private static void printLine(int i, Ladder ladder) {
		for (int j = 0; j < ladder.getLines().get(i).getPoints().size(); j++) {
			System.out.print(ladder.getLines().get(i).getPoints().get(j));
		}
	}

	private static void printResult(List<String> results) {
		System.out.println(String.join(TAB, results));
	}

	public static void printPlayerResult(String playerReuslt) {
		System.out.println("실행 결과");
		System.out.println(playerReuslt);
	}
}
