public class Ruff {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        String s = new String(array,0, array.length);
        System.out.println(s.codePointAt(2));

    }
}