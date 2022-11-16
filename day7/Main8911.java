package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main8911 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int minX=0, minY=0, maxX=0, maxY=0, dir=0, nowX=0, nowY=0;

            String command = br.readLine();

            for(int j=0;j<command.length();j++) {
                char c = command.charAt(j);
                
                if(c=='F') { //한 눈금 앞으로
                    nowX = nowX+dx[dir];
                    nowY = nowY+dy[dir];
                }else if(c=='B') { //한 눈금 뒤로
                    nowX = nowX-dx[dir];
                    nowY = nowY-dy[dir];
                }else if(c=='L') { // 왼쪽으로 90도
                    if(dir==0) dir=3;
                    else dir--;
                }else if(c=='R') { // 오른쪽으로 90도
                    if(dir==3) dir=0;
                    else dir++;
                }
                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            sb.append((Math.abs(minX)+Math.abs(maxX))*(Math.abs(minY)+Math.abs(maxY))+"\n");
        }
        System.out.println(sb.toString());
    }
}
