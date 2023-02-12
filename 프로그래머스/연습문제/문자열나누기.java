package 프로그래머스.연습문제;

import java.util.ArrayList;

public class 문자열나누기 {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }
    public static int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xCount = 0;
        int elseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(x == s.charAt(i)) {
                xCount += 1;
            } else {
                elseCount += 1;
            }
            if(xCount == elseCount) {
                if(i == s.length()-1) {
                    answer += 1;
                    xCount =0;
                    elseCount=0;
                    break;
                }
                x = s.charAt(i+1);
                answer += 1;
                xCount =0;
                elseCount=0;
            }
        }
        if(xCount >0 || elseCount >0) {
            answer += 1;
        }
        return answer;
    }
}
