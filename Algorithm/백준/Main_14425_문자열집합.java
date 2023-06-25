import java.io.*;
import java.util.*;

public class Main_14425_문자열집합 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> mapN = new HashMap<>();

        for(int nIdx = 0; nIdx < N; nIdx++) {
            mapN.put(br.readLine(), 0);
        }

        int answer = 0;

        for(int mIdx = 0; mIdx < M; mIdx++) {
            if(mapN.containsKey(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}