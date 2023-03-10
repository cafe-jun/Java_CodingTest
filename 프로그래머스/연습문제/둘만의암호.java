package 프로그래머스.연습문제;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class 둘만의암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks",	"wbqd",	5));
        System.out.println(solution("x",	"azyw",	1));
    }
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }


//    public static String solution(String s, String skip, int index) {
//        String answer = "";
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < skip.length(); i++) {
//            int c = skip.charAt(i);
//            if(!map.containsKey(c)) {
//                map.put(skip.charAt(i),c);
//            }
//        }
//        // char 97 ~ 122
//        Map<Character,Integer> totalMap = new HashMap<>();
//        int[] temp = new int[(int) 'z'-(int) 'a'+1-map.size()];
//        int idx = 0;
//        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
//            if(!map.containsKey((char) i)) {
//                temp[idx] =  i;
//                totalMap.put((char) i,idx);
//                idx+=1;
//            }
//        }
//        int[] total = new int[temp.length*3];
//        for (int i = 0; i < temp.length*3 ; i++) {
//            total[i] = temp[i%temp.length];
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            int jdx = totalMap.get(s.charAt(i));
////            if(jdx+index > total.length-1) {
////                answer += (char) total[jdx+index-total.length];
////            } else {
//            answer += (char) total[jdx+index];
////            }
//
//        }
//        return answer;
//    }
}
