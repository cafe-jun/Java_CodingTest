package 프로그래머스.KAKAOBLINDRECRUITMENT2018;

public class 방금그곡 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B",new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        for (String musicinfo: musicinfos) {
            String[] info = musicinfo.split(",");
            String start_time = info[0];
            String end_time = info[1];
            String name = info[2];
            String score = info[3];

            // Date Format 이상
        }
        return answer;
    }
}


