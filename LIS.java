import java.util.*;
import java.io.*;

public class LIS {
    
    static void longestIncreasingSubsequence(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max =0;

        for (i =0; i < n; i++) {
            lis[i] = 1;
        }
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1; 
                }
            }
        }
        for (int l : lis) {
            if (max < l) {
                max = l;
            }
        }
        System.out.println(Arrays.toString(lis));
        System.out.println(max);

    }

    static int longestCommonSubsequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int lcs[][] = new int[l1+1][l2+1];
        for (int i = 0; i < l1+1; i++) {
            lcs[i][0] = 0;
        }
        for (int i =0; i < l2+1; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i < l1 +1; i++) {
            for (int j = 1; j < l2 +1; j++) {
                lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                if (c1[i-1] == c2[j-1]) {
                    lcs[i][j] = Math.max(lcs[i][j], lcs[i-1][j-1] +1);
                }
            }
        }
        return (lcs[l1][l2]);

    }

    static int knapsack(int[] val, int[] wt, int w) {
        int n = val.length;
        int ks[][] = new int[n+1][w+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i == 0 || j == 0) {
                    ks[i][j] = 0;
                } else if (wt[i-1] > j) {
                    ks[i][j] = ks[i-1][j];
                } else {
                    ks[i][j] = Math.max(val[i-1] + ks[i-1][j-wt[i-1]], ks[i-1][j]);
                }
            }
        }
        return ks[n][w];
    }

    static int lps(String s1) {
        int len = s1.length();
        int arr[][] = new int[len][len];

        for (int i = 0; i < len; i++) {
            arr[i][i] = 1;
        }

        for (int L = 2; L <=len; L++) {
            for (int i = 0; i < len - L + 1; i++) {
                int j = i + L - 1;
                if (s1.charAt(i) ==  s1.charAt(j) && L == 2) {
                    arr[i][j] = 2;
                } else {
                    if (s1.charAt(i) ==  s1.charAt(j)) {
                        arr[i][j] = arr[i+1][j-1] +2;
                    } else {
                        arr[i][j] = Math.max(arr[i][j-1], arr[i+1][j]);
                    }
                }
            }
        }
        return arr[0][len-1];
    }


    public static void main(String[] args) {
        // int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
        // longestIncreasingSubsequence(arr, arr.length);
        // System.out.println(longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    //        int val[] = new int[]{60, 100, 120}; 
    // int wt[] = new int[]{10, 20, 30}; 
   
    //     System.out.println(knapsack(val, wt, 50));
    System.out.println(lps("BBABCBCAB"));
    
    
    
    }
}