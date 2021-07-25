import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                       .map(File::from)
                       .sorted((o1, o2) -> {
                                   int comparingResult = Comparator.<String>naturalOrder().compare(o1.head(), o2.head());

                                   if (comparingResult == 0) {
                                       comparingResult = Comparator.<Integer>naturalOrder().compare(o1.number(), o2.number());
                                   }

                                   return comparingResult;
                               }
                       ).map(File::name)
                       .toArray(value -> new String[value]);
    }
}

class File {
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
            if (isNumber(each)) {
                number.append(each);
            } else if (number.length() == 0 && !isNumber(each)) {
                head.append(each);
            } else if (head.length() != 0 && !isNumber(each)) {
                break;
            }
        }

        if(number.length() == 0) {
            number.append(0);
        }

        return new File(name, head.toString().toLowerCase(), Integer.valueOf(number.toString()));
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

    private static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
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
