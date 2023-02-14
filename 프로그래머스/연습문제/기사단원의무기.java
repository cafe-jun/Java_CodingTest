package 프로그래머스.연습문제;

public class 기사단원의무기 {
    public static void main(String[] args) {
        System.out.println(solution(5,3,2));
        System.out.println(solution(10,3,2));
    }
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 0; i < number; i++) {
            // 1 부터 시작
            int kg = getDivisor(i+1);
            if(limit < kg) {
                answer += power;
            } else {
                answer += kg;
            }
        }
        return answer;
    }
    private static int getDivisor(int num) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    cnt++;
                } else {
                    cnt += 2;
                }
            }
        }
        return cnt;
    }

}
