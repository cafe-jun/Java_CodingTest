package 프로그래머스.연습문제;

import java.util.ArrayList;
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
        PriorityQueue<BookTime> bookQueue = new PriorityQueue();
        for (int i = 0; i < book_time.length; i++) {
            bookQueue.offer(new BookTime(book_time[i][0],book_time[i][1]));
        }
        ArrayList<BookTime> list = new ArrayList<>();
        while(!bookQueue.isEmpty()) {
            BookTime bookTime = bookQueue.poll();
            // 만료 판단하기
            for (int i = 0; i < list.size(); i++) {
                if(bookTime.getStartTime() >= list.get(i).getEndTime()) {
                    list.remove(i);
                }
            }
            list.add(bookTime);
            answer = Math.max(answer,list.size());
        }
        return answer;
    }
}

class BookTime implements Comparable<BookTime>{
    public int getEndTime() {
        return endTime;
    }
    public int getStartTime() {
        return startTime;
    }

    private int startTime;
    private int endTime;

    public BookTime(String startTime, String endTime) {
        String[] splitStartTime = startTime.split(":");
        this.startTime = Integer.parseInt(splitStartTime[0]) * 60 + Integer.parseInt(splitStartTime[1]);
        String[] splitEndTime = endTime.split(":");
        this.endTime = Integer.parseInt(splitEndTime[0])*60 + Integer.parseInt(splitEndTime[1])+10;
    }

    @Override
    public int compareTo(BookTime o) {
        return this.startTime<= o.startTime ? -1 : 1;
    }
}
