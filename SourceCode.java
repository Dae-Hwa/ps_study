import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);

        // <노선, 역> 없으면 환승해야함
        Map<Integer, Set<Integer>> lines = new HashMap<>();
        // <현재노선, 이어진노선>
        Map<Integer, Set<Integer>> hubs = new HashMap<>();

        // <역, 노선>
        Map<Integer, Set<Integer>> stations = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            stations.put(i, new HashSet<>());
        }

        for (int i = 1; i <= L; i++) {
            lines.put(i, new HashSet<>());
            hubs.put(i, new HashSet<>());

            int[] input = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            Set<Integer> line = lines.get(i);
            for (int j = 0; j < input.length - 1; j++) {
                line.add(input[j]);
                stations.get(input[j]).add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            Set<Integer> station = stations.get(i);

            if (1 < station.size()) {
                for (int line : station) {
                    hubs.get(line).addAll(station);
                    hubs.get(line).remove(line);
                }
            }
        }

        Queue<int[]> bfs = new ArrayDeque<>();
        String[] lastInput = br.readLine().split(" ");

        int startingStation = Integer.parseInt(lastInput[0]);
        int targetStation = Integer.parseInt(lastInput[1]);

        boolean[] visited = new boolean[L + 1];
        for (int line : stations.get(startingStation)) {
            bfs.offer(new int[]{line, 0});
            visited[line] = true;
        }

        int answer = Integer.MAX_VALUE;

        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            int currentLineNumber = cur[0];

            int currentTransferCount = cur[1];

            Set<Integer> currentLine = lines.get(currentLineNumber);

            if (currentLine.contains(targetStation)) {
                if (currentTransferCount < answer) {
                    answer = currentTransferCount;
                }
            }

            // 환승
            Set<Integer> hub = hubs.get(currentLineNumber);
            currentTransferCount++;
            for (int nextLine : hub) {
                if (!visited[nextLine]) {
                    bfs.offer(new int[]{nextLine, currentTransferCount});
                    visited[nextLine] = true;
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println();
        }
    }
}
