package 프로그래머스.연습문제;

import java.util.PriorityQueue;

public class 호텔대실 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},{"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"},{"10:20", "12:30"}}));

    }
    public static int solution(String[][] book_time) {
        int answer = 0;
        // book_time 다 초로 변경
        // 끝나는 시간이 있는지
        PriorityQueue bookQueue = new PriorityQueue();
        return answer;
    }
}

class BookTime implements Comparable<BookTime>{
    private int startTime;
    private int endTime;

    public BookTime(String startTime, String endTime) {
        startTime.split(':');
        this.startTime = startTime.split(':');
        this.endTime = endTime;
    }

    @Override
    public int compareTo(BookTime o) {
        return 0;
    }
}
