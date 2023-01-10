package 백준.bfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[] dm = {-1,0,1,0,0,0};
    static int[] dn = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/junseok/personal/Java_CodingTest/testcase.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        StringTokenizer st = new StringTokenizer (tc , " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] matrix = new int[h][n][m];
        int[][][] daym = new int[h][n][m];
        Queue<NodeTatot> q = new LinkedList();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] t = br.readLine().split(" ");
                for (int k = 0; k <m; k++) {
                    int value = Integer.parseInt(t[k]);
                    if(value == 1) {
                        q.offer(new NodeTatot(k,j,i,0));
                    }
                    matrix[i][j][k] = value;
                }
            }
        }

        while(!q.isEmpty()) {
            NodeTatot node = q.poll();
            for (int i = 0; i < 6; i++) {
                int nm = dm[i] + node.m;
                int nn = dn[i] + node.n;
                int nh = dh[i] + node.h;
                if (0 <= nm && nm < m && 0 <= nn && nn < n && 0 <= nh && nh < h) {
                    if(matrix[nh][nn][nm] == 0) {
                        daym[nh][nn][nm] = node.day+1;
                        matrix[nh][nn][nm] = 1;
                        q.offer(new NodeTatot(nm,nn,nh,node.day+1));
                    }
                }
            }
        }
        int zero_cnt = 0;
        int max_day = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <m; k++) {
                    if(matrix[i][j][k] == 0) {
                        zero_cnt = zero_cnt+1;
                    } else {
                        if(max_day < daym[i][j][k]) {
                            max_day = daym[i][j][k];
                        }
                    }
                }
            }
        }
        if(zero_cnt >0){
            System.out.println(-1);
        } else {
            System.out.println(max_day);
        }
    }

}
// 테스트
class NodeTatot {
    int m;
    int n;
    int h;
    int day;
    public NodeTatot(int m, int n, int h,int day) {
        this.m = m;
        this.n = n;
        this.h = h;
        this.day = day;
    }
}