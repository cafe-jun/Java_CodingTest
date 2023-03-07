package 프로그래머스.연습문제;

public class 덧칠하기 {
    public static void main(String[] args) {
        System.out.println(solution(8,4,new int[]{2, 3, 6}));
        System.out.println(solution(100,4,new int[]{2, 3, 95,96}));
        System.out.println(solution(5,4,new int[]{1, 3}));
        System.out.println(solution(4,1,new int[]{1, 2, 3, 4}));
    }
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int roller = 0;
        for (int i = 0; i < section.length; i++) {
            if(roller > n) {
                break;
            }
            if(roller< section[i]){
                roller = section[i]+(m-1);
                answer += 1;
            }
        }
        return answer;
    }
}
