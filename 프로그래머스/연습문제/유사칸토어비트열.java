package 프로그래머스.연습문제;

public class 유사칸토어비트열 {
    static int N;
    public static void main(String[] args) {
        System.out.println(solution(2,4,17));
    }
    public static int solution(int n, long l, long r) {
        int answer = 0;
        N = n;
        String temp = recurisve(n);
        for (long i = l; i < r; i++) {
            if(temp == '1') {
                answer += 1;
            };
        }
        return answer;
    }
    public static String recurisve(int x) {
        String str = "";
        if(x==0) {
            return "1";
        }
        str = recurisve(x-1);
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                temp += "11011";
            } else if (str.charAt(i) == '0') {
                temp += "00000";
            }
        }
        return temp;
    }
}
