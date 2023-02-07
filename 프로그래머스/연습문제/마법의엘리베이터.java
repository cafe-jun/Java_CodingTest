package 프로그래머스.연습문제;


import java.util.Arrays;

public class 마법의엘리베이터 {
    static int[] dp = new int[100000000];
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(65515));
    }
    public static int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int check = storey%10;
            storey /=10;
            if(check <= 4) {
                answer += check;
            } else if (check >= 6) {
                storey += 1;
                answer += (10-check);
            } else {
                if(storey%10 < 5) {
                    answer += check;
                } else {
                    storey += 1;
                    answer += (10-check);
                }

            }
        }
        return answer;
    }

}
