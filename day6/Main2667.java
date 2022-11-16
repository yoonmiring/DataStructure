package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2667 {

    static Queue<Integer> q = new LinkedList<>();
    static int N;
    static int[][] arr;
    static boolean[][] visited; // 방문체크
    static int count; // 단지 집 숫자
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static ArrayList<Integer> result; // 단지 집의 수 저장

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';

            }
        }

        count = 0;

        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int c : result) {
            System.out.println(c);
        }
    }

    public static void dfs(int x, int y) {

        visited[x][y] = true; 
        
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y +dy[i];
            if(nx >=0 && ny>= 0 && nx<N && ny <N) {
                if(arr[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx,ny);
                    count++;
                }
            }
        }
    }
}
