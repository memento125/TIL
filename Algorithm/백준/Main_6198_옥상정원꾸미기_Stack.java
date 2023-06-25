import java.io.*;
import java.util.*;

public class Main_6198_옥상정원꾸미기_Stack {
    static int N;
    static Stack<Integer> stackBuilding;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stackBuilding = new Stack<>();

        long answer = 0;

        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            // 현재 들어온 값보다 큰 값만 남을 때까지, 스택을 비운다.
            while (!stackBuilding.isEmpty() && stackBuilding.peek() <= tmp) {
                stackBuilding.pop();
            }

            stackBuilding.push(tmp);
            answer += stackBuilding.size() - 1;
        }

        System.out.println(answer);
        br.close();
    }

}
