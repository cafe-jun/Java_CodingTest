package 프로그래머스.연습문제;

import java.lang.reflect.Array;
import java.util.PriorityQueue;

public class 테이블해시함수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 4},{1, 0, 1, 0}, {0, 1, 0, 1}, {7, 7, 7, 7}}, 2, 2, 3));
        System.out.println(solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}},2,2,3));


    }
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        PriorityQueue<Row> queue = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            int[] temp = new int[data[i].length];
            for (int j = 0; j < data[i].length; j++) {
                temp[j] = data[i][j];
            }
            queue.offer(new Row(temp,col));
        }
        int[] result = {};
        int index = 1;
        while(!queue.isEmpty()) {
            Row row = queue.poll();
            if(index >= row_begin && index <= row_end) {
                result = row.setDivid(index);
                int temp = 0;
                for (int i = 0; i < result.length; i++) {
                    temp += result[i];
                }
                answer ^= temp;
            }
            index++;
        }
        return answer;
    }
}

class Row implements  Comparable<Row> {
    private int[] row;
    private int column;

    public Row(int[] row,int column) {
        this.row = row;
        this.column = column-1;
    }

    public int getLength() {
        return this.row.length;
    }
    public int[] setDivid(int index) {
        for (int i = 0; i < this.row.length; i++) {
            this.row[i] %= index;
        }
        return this.row;
    }
    @Override
    public int compareTo(Row o) {
         if(this.row[this.column] < o.row[this.column]) {
             return -1;
         } else if (this.row[1] == o.row[1]) {
             // 내림 차순
             return this.row[0] <= o.row[0] ? 1 : -1;
         }else {
             return 1;
         }
    }
}
