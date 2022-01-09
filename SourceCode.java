import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        var answer = -1;
        var dungeonLength = dungeons.length;

        for (var i = 0; i < dungeonLength; i++) {
            var dungeon = dungeons[i];
            Deque<Node> visits = new ArrayDeque<>();
            var start = new Node(
                    k,
                    dungeons,
                    new HashSet<>(),
                    0
            );
            start.visit(i);
            visits.push(start);

            while (!visits.isEmpty()) {
                var cur = visits.pop();
                answer = Math.max(cur.count, answer);
                for (var j = 0; j < dungeonLength; j++) {
                    var next = cur.next();
                    if (next.visit(j)) {
                        // System.out.println(next.visited);
                        // System.out.println(next.count);
                        visits.push(next);
                    }
                }
            }
        }




        return answer;
    }
}

class Node {
    int fatigue;
    int[][] dungeons;
    Set<Integer> visited;
    int count;

    public Node(
            int fatigue,
            int[][] dungeons,
            Set<Integer> visited,
            int count
    ) {
        this.fatigue = fatigue;
        this.dungeons = dungeons;
        this.visited = visited;
        this.count = count;
    }

    public Node next() {
        return new Node(
                fatigue,
                dungeons,
                new HashSet<>(visited),
                count
        );
    }

    public boolean visit(int i) {
        if (!visited.add(i)) {
            return false;
        }

        var curDungeon = dungeons[i];

        if (fatigue < curDungeon[0]) {
            return false;
        }

        fatigue -= curDungeon[1];
        count++;

        return true;
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
