import java.time.LocalTime;

class Solution {
    private static final long milli = 1_000_000L;

    public int solution(String[] lines) {
        int answer = 0;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] parsedLine = line.split(" ");
            LocalTime endTime = endTimeOf(parsedLine);
            LocalTime startTime = startTimeOf(parsedLine);

            int startLeft = 1;
            int startRight = 1;
            int endLeft = 1;
            int endRight = 1;

            for (int j = 0; j < lines.length; j++) {
                if (i == j) continue;

                String candidateLine = lines[j];
                String[] parsedCandidateLine = candidateLine.split(" ");
                LocalTime candidateEndTime = endTimeOf(parsedCandidateLine);
                LocalTime candidateStartTime = startTimeOf(parsedCandidateLine);

                if (isIncludedTime(startTime.minusSeconds(1).plusNanos(milli), candidateStartTime, candidateEndTime)) {
                    startLeft++;
                }

                if (isIncludedTime(startTime, candidateStartTime, candidateEndTime)) {
                    startRight++;
                }

                if (isIncludedTime(endTime.minusSeconds(1).plusNanos(milli), candidateStartTime, candidateEndTime)) {
                    endLeft++;
                }

                if (isIncludedTime(endTime, candidateStartTime, candidateEndTime)) {
                    endRight++;
                }
            }

            answer = Math.max(answer, Math.max(Math.max(startLeft, startRight), Math.max(endLeft, endRight)));
        }

        return answer;
    }

    private boolean isIncludedTime(LocalTime baseTime, LocalTime targetStart, LocalTime targetEnd) {
        LocalTime baseEnd = baseTime.plusSeconds(1).minusNanos(milli);

        return baseTime.isAfter(targetStart) &&  baseTime.isBefore(targetEnd) ||
               baseEnd.isAfter(targetStart) && (baseEnd.equals(targetStart) || baseEnd.isBefore(targetEnd)) ||
               (baseTime.equals(targetStart) || baseTime.isAfter(targetStart)) && (baseEnd.equals(targetStart) || baseEnd.isBefore(targetEnd)) ||
               (baseTime.equals(targetStart) || baseTime.isBefore(targetStart)) && (baseEnd.equals(targetStart) || baseEnd.isAfter(targetEnd)) ||
               baseTime.equals(targetStart) && baseEnd.equals(targetEnd);
    }

    private LocalTime endTimeOf(String[] parsedLine) {
        return LocalTime.parse(parsedLine[1]);
    }

    private LocalTime startTimeOf(String[] parsedLine) {
        double executeSeconds = Double.parseDouble(parsedLine[2].substring(0, parsedLine[2].length() - 1));
        long executeNanos = (long) (executeSeconds * 1000 * milli) - milli;
        return endTimeOf(parsedLine).minusNanos(executeNanos);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
//                new Object[]{new String[]{
//                        "2016-09-15 01:00:04.001 2.0s",
//                        "2016-09-15 01:00:07.000 2s"
//                }},
//                new Object[]{new String[]{
//                        "2016-09-15 01:00:04.002 2.0s",
//                        "2016-09-15 01:00:07.000 2s"
//                }},
//                new Object[]{new String[]{
//                        "2016-09-15 01:00:02.500 0s",
//                        "2016-09-15 01:00:04.000 3.0s"
//                }},
//                new Object[]{new String[]{
//                        "2016-09-15 01:00:04.001 0.001s",
//                        "2016-09-15 01:00:04.000 3.0s"
//                }},
                new Object[]{new String[]{
                        "2016-09-15 01:00:03.001 0.001s",
                        "2016-09-15 01:00:04.001 0.001s"
                }},
                new Object[]{new String[]{
                        "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s"
                }}
        };

        System.out.println(LocalTime.parse("21:00").isAfter(LocalTime.parse("21:00")));

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String[]) arguments[0]));
        }
    }
}
