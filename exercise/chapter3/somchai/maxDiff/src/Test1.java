public class Test1 {
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
        int maxDiff = 0;
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                maxDiff = Math.max(Math.abs(d[i] - d[j]), maxDiff);
            }
        }
        return maxDiff;
    }
}
