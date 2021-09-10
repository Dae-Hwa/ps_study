import java.text.DecimalFormat;
import java.text.Format;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if (play_time.equals(adv_time)) return "00:00:00";

        long[] viewCounts = new long[parseTime(play_time)];

        for (String log : logs) {
            String[] parsedLog = log.split("-");
            int startTime = parseTime(parsedLog[0]);
            int endTime = parseTime(parsedLog[1]);

            for (int i = startTime; i < endTime; i++) {
                viewCounts[i] += 1;
            }
        }

        int windowSize = parseTime(adv_time);

        long maxCount = 0;
        for (int i = 0; i < windowSize; i++) {
            maxCount += viewCounts[i];
        }

        long lastCount = maxCount;
        int maxTime = 0;
        for (int i = 1; i + windowSize < viewCounts.length; i++) {
            long curCount = (lastCount - viewCounts[i]) + viewCounts[i + windowSize];
            lastCount = curCount;

            if (maxCount < curCount) {
                maxCount = curCount;
                maxTime = i + 1;
            }
        }

        return parseTime(maxTime);
    }

    private int parseTime(String playTime) {
        String[] splitPlayTime = playTime.split(":");
        int result = Integer.valueOf(splitPlayTime[0]) * 3600;
        result += Integer.valueOf(splitPlayTime[1]) * 60;
        result += Integer.valueOf(splitPlayTime[2]);

        return result;
    }

    private String parseTime(int playTime) {
        int hour = playTime / 3600;
        playTime = playTime % 3600;
        int min = playTime / 60;
        int sec = playTime % 60;

        Format format = new DecimalFormat("00");

        return format.format(hour) + ":" + format.format(min) + ":" + format.format(sec);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        "02:03:55",
                        "00:14:15",
                        new String[]{
                                "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
                        },
                        "01:30:59"
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(
                    "actual : " + new Solution().solution((String) arguments[0], (String) arguments[1], (String[]) arguments[2]) + ", " +
                    "expected : " + arguments[3]
            );
        }
    }
}
