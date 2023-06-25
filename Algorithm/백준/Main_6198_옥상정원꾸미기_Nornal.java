import java.io.*;

public class Main_6198_옥상정원꾸미기_Nornal {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[] arrayBuilding = new long[N];

        for(int i = 0; i < N; i++) {
            arrayBuilding[i] = Long.parseLong(br.readLine());
        }

        long answer = 0;

        for(int curIdx = 0; curIdx < N - 1; curIdx++) {
            long currentBuilding = arrayBuilding[curIdx];
            for(int buildIdx = curIdx + 1; buildIdx < N; buildIdx++) {
                if(currentBuilding <= arrayBuilding[buildIdx]) {
                    break;
                }

                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

}
