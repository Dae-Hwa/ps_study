import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = br.readLine().split(" ");

        // 역 개수
        int N = Integer.parseInt(firstInput[0]);
        int L = Integer.parseInt(firstInput[1]);

        List<List<Integer>> stationToLine = new ArrayList<>();
        List<List<Integer>> lineToStation = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            stationToLine.add(new ArrayList<>());
        }

        lineToStation.add(new ArrayList<>());

        for (int i = 1; i <= L; i++) {
            int[] lineInput = Arrays.stream(br.readLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();

            List<Integer> station = new ArrayList<>();
            for (int j = 0; j < lineInput.length - 1; j++) {
                stationToLine.get(lineInput[j]).add(i);
                station.add(lineInput[j]);
            }
            lineToStation.add(station);
        }

        int[] lineTransferCount = new int[L + 1];
        int[] stationTransferCount = new int[N + 1];

        Arrays.fill(stationTransferCount, Integer.MAX_VALUE);
        Arrays.fill(lineTransferCount, Integer.MAX_VALUE);

        String[] lastInput = br.readLine().split(" ");

        int start = Integer.parseInt(lastInput[0]);
        int end = Integer.parseInt(lastInput[1]);

        if (start == end) {
            System.out.println(0);
            return;
        }

        Queue<Integer> bfs = new ArrayDeque<>();

        for (int line : stationToLine.get(start)) {
            bfs.offer(line);
            stationTransferCount[start] = 0;
            lineTransferCount[line] = 0;
        }


        while (!bfs.isEmpty()) {
            int currentLine = bfs.poll();
            int currentTransferCount = lineTransferCount[currentLine];

            List<Integer> nextStations = lineToStation.get(currentLine);

            for (int nextStation : nextStations) {
                if (stationTransferCount[nextStation] != Integer.MAX_VALUE) continue;
                if (nextStation == end) {
                    System.out.println(currentTransferCount);
                    return;
                }
                List<Integer> nextLines = stationToLine.get(nextStation);

                stationTransferCount[nextStation] = currentTransferCount;

                for (int nextLine : nextLines) {
                    if (lineTransferCount[nextLine] != Integer.MAX_VALUE) continue;
                    lineTransferCount[nextLine] = currentTransferCount + 1;
                    bfs.offer(nextLine);
                }
            }
        }
        System.out.println(-1);
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
