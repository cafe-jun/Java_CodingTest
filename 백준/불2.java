package 백준;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//  #: 벽
//  .: 지나갈 수 있는 공간
//  J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
//  F: 불이 난 공간
public class 불2 {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new  FileReader("/Users/junseok/personal/Java_CodingTest/testcase.txt"));
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        StringTokenizer st = new StringTokenizer (tc , " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String [][] matrix = new String[r][c];
        Queue<Node> jp = new LinkedList();
        Queue<Node> fp = new LinkedList();

        // 행의 개수
        for (int i = 0; i < matrix.length; i++) {
            String[] t = br.readLine().split("");
            // 열의 개수
            for (int j = 0; j < matrix[0].length; j++) {
                if(t[j].equals("J")) {
                    jp.offer(new Node(i,j,0));

                } else if (t[j].equals("F")) {
                    fp.offer(new Node(i,j,0));
                }
                matrix[i][j] = t[j];
            }
        }
        int time = 0;
        // BFS
        while(true) {
            time+=1;
            while(!fp.isEmpty()) {

                if (fp.peek().time >= time){
                    break;
                }
                Node fn = fp.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = dr[i] + fn.r;
                    int nc = dc[i] + fn.c;
                    if (0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix[0].length) {
                        if (matrix[nr][nc].equals(".") || matrix[nr][nc].equals("J")) {
                            fp.offer(new Node(nr,nc,time));
                            matrix[nr][nc] = "F";
                        }
                    }
                }
            }
            while(jp.peek().time < time) {
                Node jn = jp.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = dr[i] + jn.r;
                    int nc = dc[i] + jn.c;
                    if (0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix[0].length) {
                        if(matrix[nr][nc].equals(".")) {
                            jp.offer(new Node(nr,nc,time));
                            matrix[nr][nc] = "J";
                        }
                    } else {
                        System.out.println(time);
                        return;
                    }
                }
                if(jp.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
    }
}

class Node {
     int r;
     int c;
     int time;

    public Node(int r, int c,int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}