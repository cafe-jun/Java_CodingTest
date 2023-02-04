package 프로그래머스.연습문제;

import java.util.Arrays;

public class 숫자변환하기 {
    static int[] dp = new int[1000000+1];
    public static void main(String[] args) {
        System.out.println(solution(10	,40,	5));
        System.out.println(solution(10	,40,	30));
        System.out.println(solution(2,5,	4));

    }
    public static int solution(int x, int y, int n) {
        Arrays.setAll(dp, num -> Integer.MAX_VALUE);
        int answer = 0;
        if (x==y) {
            return answer;
        }
        dp[x] = 0;
        dfs(x+n,y,n,1);
        dfs(x*2,y,n,1);
        dfs(x*3,y,n,1);
        if(Integer.MAX_VALUE == dp[y]) {
            return -1;
        }
        return dp[y];
    }
    public static int dfs(int x,int y,int n,int count) {
        if(dp[x] != Integer.MAX_VALUE) {
            dp[x] =Math.min(count,dp[x]);
            return dp[x];
        }
        if(x >= y) {
            return dp[x];
        }
        dp[x] = Math.min(dfs(x+n,y,n,count+1),dp[x]);
        dp[x] = Math.min(dfs(x*2,y,n,count+1),dp[x]);
        dp[x] = Math.min(dfs(x*3,y,n,count+1),dp[x]);
        return dp[x];
    }
}

