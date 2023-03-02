package 프로그래머스.연습문제;

public class 푸드파이트대회 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
        System.out.println(solution(new int[]{1, 7, 1, 2}));
    }
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            if(count > 0) {
                for (int j = 0; j < count; j++) {
                    left.append(i);
                }
            }
        }
        answer += left.toString() + "0" + left.reverse().toString();
        return answer;
    }
}
