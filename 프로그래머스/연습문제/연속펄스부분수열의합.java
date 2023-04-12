package 프로그래머스.연습문제;

public class 연속펄스부분수열의합 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, -1, 2, 4}));
        System.out.println(solution(new int[]{2,3,-6,1,3,-1,2,4}));
        System.out.println(solution(new int[]{2,3,-6,1,3,-1,2,4}));
        System.out.println(solution(new int[]{2,3,-6,1,3,-1,2,4}));

        

    }
    public static long solution(int[] sequence) {
        long answer = 0;
        long temp = sequence[0];
        long current = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if((current > 0 && sequence[i] < 0) || (current < 0 && sequence[i] > 0)) {
                current = sequence[i];
                temp += Math.abs(sequence[i]);
            } else {
                current = sequence[i];
                answer = Math.max(temp,answer);
                temp = Math.abs(sequence[i]);
            }
        }
        return answer;
    }
}
