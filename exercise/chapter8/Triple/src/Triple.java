public class Triple {
    private int a, b, c;

    public Triple(int a, int b, int c) {

        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;

        this.a = x;
        this.b = y;
        this.c = z;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple triple)) return false;

        if (a != triple.a) return false;
        if (b != triple.b) return false;
        return c == triple.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
}
