package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        list.sort(Comparator.naturalOrder());

        int max = 0;
        int cnt = 0;
        int end = 0;
        if (n < 5) {
            end = n;
        }

        for (int i = 0; i < end; i++) {
            int newNum = list.get(i) + 4;
            for (int j = 0; j < n - 1; j++) {
                int compareNum = list.get(i + j);
                if (newNum >= compareNum) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > max) {
                max = cnt;
            }
            cnt = 0;
        }
        System.out.println(5 - max);

    }
}
