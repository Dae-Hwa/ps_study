import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int K = Integer.parseInt(firstInput[1]);
        int M = Integer.parseInt(firstInput[2]);

        List<List<Integer>> stationToHyperTube = new ArrayList<>();
        List<List<Integer>> hyperTubeToStation = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            stationToHyperTube.add(new ArrayList<>());
        }

        for (int hyperTubeIndex = 0; hyperTubeIndex < M; hyperTubeIndex++) {
            int[] stationInput = Stream.of(br.readLine().split(" "))
                                       .mapToInt(Integer::parseInt)
                                       .toArray();

            List<Integer> stations = new ArrayList<>();
            for (int stationIndex = 0; stationIndex < K; stationIndex++) {
                stationToHyperTube.get(stationInput[stationIndex]).add(hyperTubeIndex);
                stations.add(stationInput[stationIndex]);
            }
            hyperTubeToStation.add(stations);
        }

        System.out.println(solution(N, stationToHyperTube, hyperTubeToStation));
    }

    public static int solution(int N, List<List<Integer>> stationToHyperTube, List<List<Integer>> hyperTubeToStation) {
        Queue<int[]> bfs = new ArrayDeque<>();

        int startingStation = 1;
        if (N == 1) return 1;

        boolean[] visitedStation = new boolean[N + 1];
        visitedStation[startingStation] = true;

        boolean[] visitedHyperTube = new boolean[hyperTubeToStation.size()];

        for (int hyperTubeNumber : stationToHyperTube.get(1)) {
            bfs.offer(new int[]{hyperTubeNumber, 2});
            visitedHyperTube[hyperTubeNumber] = true;
        }

        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            int curHyperTubeNumber = cur[0];
            int curCnt = cur[1];

            List<Integer> nextStation = hyperTubeToStation.get(curHyperTubeNumber);
            for (int nextStationNumber : nextStation) {

                if (visitedStation[nextStationNumber]) {
                    continue;
                }

                if (nextStationNumber == N) {
                    return curCnt;
                }

                visitedStation[nextStationNumber] = true;

                List<Integer> nextHyperTube = stationToHyperTube.get(nextStationNumber);

                for (int nextHyperTubeNumber : nextHyperTube) {
                    if (visitedHyperTube[nextHyperTubeNumber]) {
                        continue;
                    }

                    visitedHyperTube[nextHyperTubeNumber] = true;

                    bfs.offer(new int[]{nextHyperTubeNumber, curCnt + 1});
                }
            }
        }

        return -1;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        9,
                        Arrays.asList(
                                Arrays.asList(),
                                Arrays.asList(0, 1),
                                Arrays.asList(0),
                                Arrays.asList(0, 2),
                                Arrays.asList(1),
                                Arrays.asList(1, 3),
                                Arrays.asList(2, 3, 4),
                                Arrays.asList(2, 3),
                                Arrays.asList(4)
                        ),
                        Arrays.asList(
                                Arrays.asList(
                                        1, 2, 3
                                ), Arrays.asList(
                                        1, 4, 5
                                ), Arrays.asList(
                                        3, 6, 7
                                ), Arrays.asList(
                                        5, 6, 7
                                ), Arrays.asList(
                                        6, 8, 9
                                )
                        )
                },
                new Object[]{
                        1,
                        Arrays.asList(
                                Arrays.asList(),
                                Arrays.asList(0)
                        ),
                        Arrays.asList(
                                Arrays.asList(
                                        1
                                )
                        )
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(Main.solution((int) arguments[0], (List<List<Integer>>) arguments[1], (List<List<Integer>>) arguments[2]));
        }
    }
}
