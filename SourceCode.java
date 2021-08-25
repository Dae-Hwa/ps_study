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

        Map<Integer, Set<Integer>> nextStationMap = new HashMap<>();
        Map<Integer, Set<Integer>> stationLineMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            nextStationMap.put(i + 1, new HashSet<>());
            stationLineMap.put(i + 1, new HashSet<>());
        }

        for (int i = 0; i < L; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            int lineNumber = i + 1;
            for (int j = 0; j < input.length - 1; j++) {
                Set<Integer> nextStations = nextStationMap.get(input[j]);

                if (0 < j) {
                    int left = j - 1;
                    nextStations.add(input[left]);
                }

                if (j < input.length - 2) {
                    int right = j + 1;
                    nextStations.add(input[right]);
                }

                Set<Integer> lines = stationLineMap.get(input[j]);
                lines.add(lineNumber);

                nextStationMap.put(input[j], nextStations);
                stationLineMap.put(input[j], lines);
            }
        }

        String[] lastLine = br.readLine().split(" ");

        int startingPoint = Integer.parseInt(lastLine[0]);
        int endPoint = Integer.parseInt(lastLine[1]);

        int[] transferCounts = new int[N + 1];
        Arrays.fill(transferCounts, Integer.MAX_VALUE);
        transferCounts[startingPoint] = 0;

        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{startingPoint, -1});

        while (!bfs.isEmpty()) {
            int[] current = bfs.poll();

            int currentStation = current[0];
            int lastStationNumber = current[1];

            Set<Integer> lastLines = stationLineMap.getOrDefault(lastStationNumber, new HashSet<>());
            Set<Integer> nextStations = nextStationMap.get(currentStation);
            int currentTransferCount = transferCounts[currentStation] != Integer.MAX_VALUE ? transferCounts[currentStation] : 0;

            for (int nextStation : nextStations) {
                Set<Integer> nextLines = stationLineMap.get(nextStation);
                int nextTransferCount = currentTransferCount;
                if (!lastLines.isEmpty()) {
                    int cnt = 0;
                    for (int nextLine : nextLines) {
                        if (lastLines.contains(nextLine)) {
                            cnt++;
                            break;
                        }
                    }

                    if (cnt == 0) {
                        nextTransferCount++;
                    }
                }

                if (nextTransferCount < transferCounts[nextStation]) {
                    transferCounts[nextStation] = nextTransferCount;
                    bfs.offer(new int[]{nextStation, currentStation});
                }
            }
        }

        System.out.println(
                transferCounts[endPoint] != Integer.MAX_VALUE ?
                transferCounts[endPoint] : -1
        );
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
