import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                       .map(File::from)
                       .sorted((o1, o2) -> Comparator.comparing(File::head)
                                                   .thenComparing(File::number)
                                                   .compare(o1, o2)
                       ).map(File::name)
                       .toArray(value -> new String[value]);
    }

    private static class File {
        private String name;
        private String head;
        private int number;

        private File(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }

        public static File from(String name) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            for (char each : name.toCharArray()) {
                if ('0' <= each && each <= '9') {
                    number.append(each);
                } else if (number.length() == 0) {
                    head.append(each);
                } else if (head.length() != 0) {
                    break;
                }
            }

            if (number.length() == 0) {
                number.append(0);
            }

            return new File(
                    name,
                    head.toString().toLowerCase(),
                    Integer.valueOf(number.toString())
            );
        }

        public String name() {
            return name;
        }

        public String head() {
            return head;
        }

        public int number() {
            return number;
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{new String[]{
                        "img12.png", "img10.png", "img02.png", "Img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
                }},
                new Object[]{new String[]{
                        "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
                }},
                new Object[]{new String[]{
                        "F 5 Freedom Fighter", "F 014", "B 50 Superfortress", "A 10 Thunderbolt II", "F 14 Tomcat, f 14"
                }},
                new Object[]{new String[]{
                        "a"
                }}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String[] result = new Solution().solution((String[]) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
