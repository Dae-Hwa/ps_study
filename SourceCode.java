import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> pointMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            List<Integer> pointList = pointMap.getOrDefault(y, new ArrayList<>());
            pointList.add(x);
            pointMap.put(y, pointList);
        }

        System.out.println(solution(pointMap));
    }

    public static int solution(Map<Integer, List<Integer>> pointMap) {

        int answer = 0;

        for (List<Integer> pointList : pointMap.values()) {
            Collections.sort(pointList);

            for (int i = 0; i < pointList.size(); i++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if (0 < i) {
                    left = pointList.get(i) - pointList.get(i - 1);
                }
                if (i + 1 < pointList.size()) {
                    right = pointList.get(i + 1) - pointList.get(i);
                }

                answer += Math.min(left, right);
            }
        }


        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        Map.of(
                                1, new ArrayList<>(List.of(0, 3, 5)),
                                2, new ArrayList<>(List.of(1, 4))
                        ),
                        13
                },
                new Object[]{
                        Map.of(
                                1, new ArrayList<>(List.of(6, 9, 0, 3, 4)),
                                2, new ArrayList<>(List.of(7, 10))
                        ),
                        16
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(Main.solution((Map<Integer, List<Integer>>) arguments[0]));
            String expected = String.valueOf(arguments[1]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
