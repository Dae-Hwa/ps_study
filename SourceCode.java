import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MINUTES;

class Solution {
    private static String parseChords(String chords) {
        for (int i = 'A'; i < 'G'; i++) {
            String target = Character.toString(i);
            chords = chords.replaceAll(target + "#+", target.toLowerCase());
        }

        return chords;
    }

    public String solution(String m, String[] musicinfos) {
        List<PlayedMusic> candidates = new ArrayList<>();

        for (int i = 'A'; i < 'G'; i++) {
            m = parseChords(m);
        }

        for (String musicinfo : musicinfos) {
            PlayedMusic playedMusic = PlayedMusic.of(musicinfo);

            if (playedMusic.hasSameMelodyTo(m)) {
                candidates.add(playedMusic);
            }
        }

        Optional<PlayedMusic> result = candidates.stream()
                                               .sorted(Comparator.comparing(PlayedMusic::duration).reversed())
                                               .findFirst();

        return result.isPresent() ? result.get().name() : "(None)";
    }

    private static class PlayedMusic {
        private String name;
        private int duration;
        private String chords;

        private PlayedMusic(String name, int duration, String chords) {
            this.name = name;
            this.duration = duration;
            this.chords = chords;
        }

        public static PlayedMusic of(String musicinfo) {
            String[] splitMusicinfo = musicinfo.split(",");

            return PlayedMusic.of(splitMusicinfo[0], splitMusicinfo[1], splitMusicinfo[2], splitMusicinfo[3]);
        }

        private static PlayedMusic of(String startTime, String endTime, String name, String chords) {
            chords = parseChords(chords);

            String[] splitStartTime = startTime.split(":");
            String[] splitEndTime = endTime.split(":");

            int startHour = Integer.parseInt(splitStartTime[0]);
            int startMinute = Integer.parseInt(splitStartTime[1]);
            int endHour = Integer.parseInt(splitEndTime[0]);
            int endMinute = Integer.parseInt(splitEndTime[1]);

            int startMin = startHour * 60 + startMinute;
            int endMin = endHour * 60 + endMinute;

            int duration = endMin - startMin;

//            if (s.isAfter(e)) {
//                duration = (e.getHour() + 24 - s.getHour()) * 60 + (e.getMinute() - s.getMinute());
//            }

            int chordsLength = chords.length();

            String repeatedChords = chords.repeat(duration / chordsLength);
            String remainingChords = chords.substring(0, duration % chordsLength);


            return new PlayedMusic(
                    name,
                    duration,
                    repeatedChords + remainingChords
            );
        }

        public boolean hasSameMelodyTo(String melody) {
            return chords.contains(melody);
        }

        public int duration() {
            return duration;
        }

        public String name() {
            return name;
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
//                new Object[]{
//                        "ABCDEFG",
//                        new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}
//                },
//                new Object[]{
//                        "ABCDEFG",
//                        new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:07,WORLD,ABCDEFG"}
//                },
//                new Object[]{
//                        "CC#BCC#BCC#BCC#B",
//                        new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}
//                },
//                new Object[]{
//                        "ABC",
//                        new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}
//                },
//                new Object[]{
//                        "A",
//                        new String[]{"13:00,13:05,WORLD0,ABCDEF", "23:55,00:00,HELLO,A", "13:00,13:05,WORLD,ABCDEF", "13:00,13:05,WORLD2,ABCDEF"}
//                },
//                new Object[]{
//                        "A",
//                        new String[]{"23:59,00:00,HELLO,A", "00:00,12:00,WORLD,ABCDEF"}
//                },
                new Object[]{
                        "CCB#CCB#CCC",
                        new String[]{"03:00,03:08,FOO,CCB#CCB#", "04:00,04:08,BAR,ABC"}
                },
                new Object[]{
                        "CCB#CCB#",
                        new String[]{"03:00,03:03,FOO,CCB#CCB#", "04:00,04:08,BAR,ABC"}
                },
                new Object[]{
                        "ABC",
                        new String[]{"12:00,12:14,HELLO,C#DEFGAB", "12:55,13:00,WORLD,ABCDEF", "13:00,13:05,WORLD2,ABCDEF", "23:59,12:05,WORLD3,ABCDEF"}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;


            String result = new Solution().solution((String) arguments[0], (String[]) arguments[1]);

            System.out.println(result);
        }
    }
}
