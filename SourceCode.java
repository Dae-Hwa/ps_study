import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N * N];

        for (int i = 0; i < N * N; i++) {
            students[i] = Student.from(br.readLine().split(" "));
        }

        System.out.println(solution(N, students));
    }

    public static int solution(int N, Student[] students) {
        Student[][] classRoom = new Student[N][N];

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        for (Student student : students) {
            int maxFavoriteStudents = 0;
            int lastNumberOfEmptyPlaces = 0;
            int[] candidate = new int[]{-1, -1};
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (classRoom[i][j] != null) {
                        continue;
                    }
                    Queue<Integer> favoriteStudents = new ArrayDeque<>();
                    int numberOfEmptyPlaces = 0;
                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if (0 <= r && 0 <= c && r < N && c < N) {
                            Student adjStudent = classRoom[r][c];
                            if (adjStudent != null) favoriteStudents.add(adjStudent.number());
                            else numberOfEmptyPlaces++;

                        }
                    }
                    int numberOfFavoriteStudents = student.numberOfDuplicatedFavoriteStudentsWith(favoriteStudents);

                    if (maxFavoriteStudents < numberOfFavoriteStudents) {
                        maxFavoriteStudents = numberOfFavoriteStudents;
                        lastNumberOfEmptyPlaces = numberOfEmptyPlaces;
                        candidate[0] = i;
                        candidate[1] = j;
                    } else if (maxFavoriteStudents == numberOfFavoriteStudents && lastNumberOfEmptyPlaces < numberOfEmptyPlaces) {
                        lastNumberOfEmptyPlaces = numberOfEmptyPlaces;
                        candidate[0] = i;
                        candidate[1] = j;
                    } else if (candidate[0] == -1 && candidate[1] == -1) {
                        lastNumberOfEmptyPlaces = numberOfEmptyPlaces;
                        candidate[0] = i;
                        candidate[1] = j;
                    }
                }
            }
            classRoom[candidate[0]][candidate[1]] = student;
        }

        int satisfactionPoint = 0;
        int[] satisfactionPointMap = new int[]{0, 1, 10, 100, 1000};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Student student = classRoom[i][j];
                Queue<Integer> favoriteStudents = new ArrayDeque<>();
                for (int k = 0; k < 4; k++) {
                    int r = i + dr[k];
                    int c = j + dc[k];
                    if (0 <= r && 0 <= c && r < N && c < N) {
                        Student adjStudent = classRoom[r][c];
                        if (adjStudent != null) favoriteStudents.add(adjStudent.number());

                    }
                }
                int numberOfFavoriteStudents = student.numberOfDuplicatedFavoriteStudentsWith(favoriteStudents);
                satisfactionPoint += satisfactionPointMap[numberOfFavoriteStudents];
            }
        }

        return satisfactionPoint;
    }

    static class Student {
        private int number;
        private Set<Integer> favoriteStudents;

        private Student(int number, Set<Integer> favoriteStudents) {
            this.number = number;
            this.favoriteStudents = favoriteStudents;
        }

        public static Student from(String[] input) {
            int number = Integer.parseInt(input[0]);
            Set<Integer> favoriteStudents = Arrays.stream(Arrays.copyOfRange(input, 1, input.length))
                                                  .map(Integer::valueOf)
                                                  .collect(Collectors.toSet());
            return new Student(number, favoriteStudents);
        }

        public int numberOfDuplicatedFavoriteStudentsWith(Collection<Integer> favoriteStudents) {
            return (int) favoriteStudents.stream()
                                         .filter(this.favoriteStudents::contains)
                                         .count();
        }

        public int number() {
            return number;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }
    }
}

public class SourceCode {

    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        3,
                        new Main.Student[]{
                                Main.Student.from("4 2 5 1 7".split(" ")),
                                Main.Student.from("3 1 9 4 5".split(" ")),
                                Main.Student.from("9 8 1 2 3".split(" ")),
                                Main.Student.from("8 1 9 3 4".split(" ")),
                                Main.Student.from("7 2 3 4 8".split(" ")),
                                Main.Student.from("1 9 2 5 7".split(" ")),
                                Main.Student.from("6 5 2 3 4".split(" ")),
                                Main.Student.from("5 1 9 2 8".split(" ")),
                                Main.Student.from("2 9 3 1 4".split(" "))}
                },
                new Object[]{
                        3,
                        new Main.Student[]{
                                Main.Student.from("4 2 5 1 7".split(" ")),
                                Main.Student.from("2 1 9 4 5".split(" ")),
                                Main.Student.from("5 8 1 4 3".split(" ")),
                                Main.Student.from("1 2 9 3 4".split(" ")),
                                Main.Student.from("7 2 3 4 8".split(" ")),
                                Main.Student.from("9 8 4 5 7".split(" ")),
                                Main.Student.from("6 5 2 3 4".split(" ")),
                                Main.Student.from("8 4 9 2 1".split(" ")),
                                Main.Student.from("3 9 2 1 4".split(" "))}
                },
                new Object[]{
                        3,
                        new Main.Student[]{
                                Main.Student.from("4 2 5 1 7".split(" ")),
                                Main.Student.from("2 1 9 4 5".split(" ")),
                                Main.Student.from("5 8 1 4 3".split(" ")),
                                Main.Student.from("1 2 9 3 4".split(" ")),
                                Main.Student.from("7 2 3 4 8".split(" ")),
                                Main.Student.from("9 8 4 5 7".split(" ")),
                                Main.Student.from("6 5 2 3 4".split(" ")),
                                Main.Student.from("8 4 9 2 1".split(" ")),
                                Main.Student.from("3 9 2 1 4".split(" "))}
                }

        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = Main.solution((int) arguments[0], (Main.Student[]) arguments[1]);

            System.out.println(result);
        }
    }
}
