package 백준.bfs;

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
                    jp.offer(new Node(i,j));
                } else if (t[j].equals("F")) {
                    fp.offer(new Node(i,j));
                }
                matrix[i][j] = t[j];
            }
        }
        int time = 0;
        // BFS
        while(true) {
            time+=1;
            if(!fp.isEmpty()) {
                int fsize = fp.size();
                for (int t = 0; t < fsize; t++) {
                    Node fn = fp.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = dr[i] + fn.r;
                        int nc = dc[i] + fn.c;
                        if (0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix[0].length) {
                            if (matrix[nr][nc].equals(".") || matrix[nr][nc].equals("J")) {
                                fp.offer(new Node(nr,nc));
                                matrix[nr][nc] = "F";
                            }
                        }
                    }
                }

            }
            if(!jp.isEmpty()) {
                int jsize = jp.size();
                for (int s = 0; s < jsize; s++) {
                    Node jn = jp.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = dr[i] + jn.r;
                        int nc = dc[i] + jn.c;
                        if (0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix[0].length) {
                            if(matrix[nr][nc].equals(".")) {
                                jp.offer(new Node(nr,nc));
                                matrix[nr][nc] = "J";
                            }
                        } else {
                            System.out.println(time);
                            return;
                        }
                    }
                }
            }
            if(jp.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}

class Node {
     int r;
     int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}