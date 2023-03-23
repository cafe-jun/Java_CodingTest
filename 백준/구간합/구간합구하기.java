package 백준.구간합;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;
// https://www.acmicpc.net/problem/2042
public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/junseok/personal/Java_CodingTest/testcase.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        StringTokenizer st = new StringTokenizer (tc , " ");
        System.out.println("구간합구하기.main");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); ;
        int K = Integer.parseInt(st.nextToken());
        System.out.println("구간합구하기.main");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("구간합구하기.main");

    }
}
