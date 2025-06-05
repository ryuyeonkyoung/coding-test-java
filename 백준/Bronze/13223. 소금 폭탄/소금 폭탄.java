import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] currTime = br.readLine().split(":");
        String[] putSaltTime = br.readLine().split(":");

        int hour = 0;
        int minute = 0;
        int second = 0;

        second += Integer.parseInt(putSaltTime[2]) - Integer.parseInt(currTime[2]);
        if (second < 0) {
            minute--; // 분 차감
            second += 60; // 초 보정
        }

        minute += Integer.parseInt(putSaltTime[1]) - Integer.parseInt(currTime[1]);
        if (minute < 0) {
            hour--; // 시간 차감
            minute += 60; // 분에 보정
        }

        hour += Integer.parseInt(putSaltTime[0]) - Integer.parseInt(currTime[0]);
        if (hour < 0) {
            hour += 24;
        }


        // 두 시간이 같으면 24시간으로 보정
        if (currTime[0].equals(putSaltTime[0]) && currTime[1].equals(putSaltTime[1]) && currTime[2].equals(putSaltTime[2])) {
            hour += 24;
        }

        System.out.printf("%02d:%02d:%02d", hour, minute, second);
    }
}