package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ABACD", "BCEFD"},new String[]{"ABCD","AABB"}));
        System.out.println(solution(new String[]{"AA"},new String[]{"B"}));
        System.out.println(solution(new String[]{"AGZ", "BSSS"},new String[]{"ASA","BGZ"}));
    }
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character,Integer> minKeymap = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if(minKeymap.containsKey(c)){
                    minKeymap.put(c,Math.min(minKeymap.get(c),j+1));
                } else {
                    minKeymap.put(c,j+1);
                }
            }
        }
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if(minKeymap.containsKey(c)){
                    count += minKeymap.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
