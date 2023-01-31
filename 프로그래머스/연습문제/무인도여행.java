package 프로그래머스.연습문제;


import java.util.*;

public class 무인도여행 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
        System.out.println(solution(new String[]{"XXX","XXX","XXX"}));
    }
    public static int[] solution(String[] maps) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int[] answer = {};
        int [][] matrix = new int[maps.length][maps[0].length()];
        int [][] temp = new int[maps.length][maps[0].length()];
        Queue<Point> pointList = new LinkedList();
        List<Integer> templist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Point> stack = new Stack<>();
        // matrix 만들기
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
               if(maps[i].charAt(j) == 'X') {
                  matrix[i][j] = 0;
               } else {
                   matrix[i][j] = Character.getNumericValue(maps[i].charAt(j));
               }
            }
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if(matrix[i][j] > 0 && temp[i][j] == 0) {
                    pointList.offer(new Point(i,j));
                    templist.add(matrix[i][j]);
                    temp[i][j] = 1;
                    while(!pointList.isEmpty()) {
                        Point point = pointList.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = dr[k]+point.r;
                            int nc = dc[k]+point.c;
                            if(0<=nr&&nr< maps.length && 0<=nc&&nc< maps[0].length()) {
                                if(matrix[nr][nc] > 0 && temp[nr][nc] == 0) {
                                    System.out.println("if안"+nr+":"+nc);
//                                    matrix[nr][nc] += matrix[point.r][point.c];
                                    pointList.offer(new Point(nr,nc));
                                    temp[nr][nc] = 1;
                                    templist.add(matrix[nr][nc]);
                                }
                            }
                        }
                    }
                    list.add(templist.stream().mapToInt(Integer::intValue).sum());
                    templist.clear();
                }
            }
        }
        answer=list.stream().sorted().mapToInt(i -> i).toArray();
        if(answer.length==0) {
            answer = new int[]{-1};
        }
        return answer;
    }
}

class Point {
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    int r;
    int c;
}