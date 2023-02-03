package 프로그래머스.연습문제;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class 둘만의암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks",	"wbqd",	5));
        System.out.println(solution("x",	"azyw",	1));
    }
    public static String solution(String s, String skip, int index) {
        String answer = "";
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < skip.length(); i++) {
            int c = skip.charAt(i);
            if(!map.containsKey(c)) {
                map.put(skip.charAt(i),c);
            }
        }
        // char 97 ~ 122
        Map<Character,Integer> totalMap = new HashMap<>();
        int[] total = new int[(int) 'z'-(int) 'a'+1-map.size()];
        int idx = 0;
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            if(!map.containsKey((char) i)) {
                total[idx] =  i;
                totalMap.put((char) i,idx);
                idx+=1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int jdx = totalMap.get(s.charAt(i));
            if(jdx+index > total.length-1) {
                answer += (char) total[jdx+index-total.length];
            } else {
                answer += (char) total[jdx+index];
            }

        }
        return answer;
    }
}
