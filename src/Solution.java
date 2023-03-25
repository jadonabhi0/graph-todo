import java.util.*;

public class Solution {

    public static void helper(int n, int i){
        if(i == 10) return;
        int[] array = new int[10];
        array[i] = n;
        System.out.println(Arrays.toString(array));
        helper(n-1,i+1);

    }

    public static void main(String[] args) {
        helper(10,0);
    }
}