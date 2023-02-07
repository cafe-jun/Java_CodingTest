package 프로그래머스.연습문제;


import java.util.Arrays;

public class 마법의엘리베이터 {
    static int[] dp = new int[100000000];
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
    }
    public static int solution(int storey) {
        int answer = 0;
        int idx = 0;
        while(storey > 0) {
            int check = storey%(int)Math.pow(10,idx+1);
            if(check <= 4) {
                storey -= check*(int) Math.pow(10,idx);
                answer += check;
            } else if (check >= 6) {
                storey += (10-check)*(int) Math.pow(10,idx);
                answer += (10-check);
            }
            idx +=1;

        }
        return answer;
    }

}
