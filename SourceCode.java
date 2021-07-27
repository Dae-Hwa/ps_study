import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Set<Character> skillsCanNotLearning = new HashSet<>();

        for (int i = 1; i < skill.length(); i++) {
            skillsCanNotLearning.add(skill.charAt(i));
        }

        for (String skillTree : skill_trees) {
            int skillIndex = 0;

            Set<Character> currentSkillsCanNotLearning = new HashSet<>(skillsCanNotLearning);

            boolean isFailed = false;

            for (char c : skillTree.toCharArray()) {
                if (currentSkillsCanNotLearning.contains(c)) {
                    isFailed = true;
                    break;
                }

                if (c == skill.charAt(skillIndex)) {
                    skillIndex++;

                    if (skillIndex == skill.length()) {
                        break;
                    } else {
                        currentSkillsCanNotLearning.remove(skill.charAt(skillIndex));
                    }
                }

            }

            if (!isFailed) answer++;
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        "CBD",
                        new String[]{"BACDE", "CBADF", "AECB", "BDA"}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((String) arguments[0], (String[]) arguments[1]);

            System.out.println(result);
        }
    }
}
