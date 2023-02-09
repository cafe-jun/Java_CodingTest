package 프로그래머스.연습문제;

public class 유사칸토어비트열 {
    static int N;
    public static void main(String[] args) {
        System.out.println(solution(2,4,17));
    }
    public static int solution(int n, long l, long r) {
        long answer = r-l+1;
        for(long i=l-1;i<=r-1;i++){
            for(int j=0;j<n;j++){
                if((i/(int)Math.pow(5,j))%5==2){
                    answer--;
                    break;
                }
            }
        }

        return (int) answer;
    }
}
