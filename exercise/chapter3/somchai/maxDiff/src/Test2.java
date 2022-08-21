public class Test2 {
    public static void main(String[] args) {
        for (int n = 3200; n < 100000; n*=2) {
            int[] a = new int[n];
            long startTime = System.nanoTime();
            int diff = maxDiff(a);
            long d = System.nanoTime() - startTime;
            System.out.println(n + " : " + d/1E9);
        }
    }

    public static int maxDiff(int[] d){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < d.length; i++) {
            if(d[i] > max) max = d[i];
            if(d[i] < min) min = d[i];
        }

        return max - min;
    }
}
