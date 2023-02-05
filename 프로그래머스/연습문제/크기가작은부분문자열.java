package 프로그래머스.연습문제;

public class 크기가작은부분문자열 {
    public static void main(String[] args) {
        System.out.println(solution("3141592"	,"3141592"));
        System.out.println(solution("3141592"	,"271"));
        System.out.println(solution("500220839878","7"));
        System.out.println(solution("10203","15"));
    }
    public static int solution(String t, String p) {
        int answer = 0;
        double target = Double.parseDouble(p);
        for (int i = 0; i < t.length()-p.length()+1; i++) {
            if(Double.parseDouble(t.substring(i,p.length()+i)) <= target) {
                answer+= 1;
            }
        }
        return answer;
    }
}
