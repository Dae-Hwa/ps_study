import java.util.Arrays;

public class Utils {
    private Utils() {
    }

    /**
     * toString으로 출력된 array를 실제로 입력 가능하도록 파싱
     *
     * @param arrayToString String value "[value1, value2]"
     * @return String value "{value1, value2}"
     */
    public static String parseArrayToString(String arrayToString) {
        return arrayToString.replaceAll("\\[", "{")
                            .replaceAll("]", "}");
    }

    /**
     * array를 실제로 입력 가능한 형태로 파싱
     *
     * @param array Some Object Array [value1, value2]
     * @return String value "{value1, value2}"
     */
    public static String arrayToStringForInput(Object[] array) {
        return parseArrayToString(Arrays.deepToString(array));
    }
}
