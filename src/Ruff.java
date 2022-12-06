

public class Ruff {

    static class Pair{

    }


    int moveApples(int input1, int[] input2){
        int avg = 0;
        int sum = 0;

        for(int i : input2){
            sum += i;
        }
        avg = sum / input1;



        int ans = 0;
        for(int i : input2){
            if (avg > i){
                ans = ans + Math.abs(avg - i);
            }
        }

        return ans;
    }




    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        String s = new String(array,0, array.length);
        System.out.println(s.codePointAt(2));



    }
}