package 프로그래머스;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        var resultOfRace = Stream.of(players).toArray(String[]::new);

        Map<String, Integer> rankOfPlayers = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankOfPlayers.put(players[i], i);
        }

        // calling에 들어있으면 순위 추월
        for (var calling : callings) {
            var currentRank = rankOfPlayers.get(calling);
            var overtakenPlayer = resultOfRace[currentRank - 1];

            // 불린 선수 세팅
            rankOfPlayers.put(calling, currentRank - 1);
            resultOfRace[currentRank - 1] = calling;

            // 뒤쳐진 선수 세팅
            rankOfPlayers.put(overtakenPlayer, currentRank);
            resultOfRace[currentRank] = overtakenPlayer;
        }

        return resultOfRace;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = "";
            String expected = "";
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
