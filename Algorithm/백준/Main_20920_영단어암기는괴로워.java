import java.io.*;
import java.util.*;

public class Main_20920_영단어암기는괴로워 {
    static int N, M;
    static Voca[] vocaList;
    static class Voca implements Comparable<Voca>{
        String strVoca; // 단어
        int appearCnt;  // 등장 횟수

        public Voca(String strVoca, int appearCnt) {
            this.strVoca = strVoca;
            this.appearCnt = appearCnt;
        }

        @Override
        public int compareTo(Voca o) {
            if(this.appearCnt == o.appearCnt) {
                if(this.strVoca.length() == o.strVoca.length()) {
                    return this.strVoca.compareTo(o.strVoca);
                }

                return o.strVoca.length() - this.strVoca.length();
            }

            return o.appearCnt - this.appearCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //해시맵을 사용하여 단어는 Key 값으로, 등장 횟수는 Value 값으로 받는다.
        Map<String, Integer> vocaMap = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int n = 0; n < N; n++) {
            String inputString = br.readLine();

            // 입력 받은 단어가 M 글자 이상인 경우에만 단어장에 등록한다.
            if(inputString.length() >= M) {

                //이미 단어장에 존재하는 단어인 경우, Value 를 1 씩 증가시킨다.
                //단어장에 없는 신규 단어인 경우 Value 를 0 으로 등록한다.
                if(vocaMap.containsKey(inputString)) {
                    int curCnt = vocaMap.get(inputString) + 1;
                    vocaMap.put(inputString, curCnt);
                } else {
                    vocaMap.put(inputString, 1);
                }

            }
        }

        vocaList = new Voca[vocaMap.size()];
        int listIdx = 0;
        for(String str : vocaMap.keySet()) {
            vocaList[listIdx++] = new Voca(str, vocaMap.get(str));
        }

        Arrays.sort(vocaList);

        StringBuffer sb = new StringBuffer();
        for(int vocaIdx = 0; vocaIdx < vocaList.length; vocaIdx++) {
            sb.append(vocaList[vocaIdx].strVoca + "\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
